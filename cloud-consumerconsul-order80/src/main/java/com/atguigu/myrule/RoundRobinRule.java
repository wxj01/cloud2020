package com.atguigu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

//轮训算法，即用一个计数器count%集群总数 来得到一个值，把这个值拿去获取服务集群里面的其中一个
public class RoundRobinRule extends AbstractLoadBalancerRule {

    //这个是一个原子类，可以在多线程下保证线程安全.
    private AtomicInteger nextServerCyclicCounter;
    private static final boolean AVAILABLE_ONLY_SERVERS = true;
    private static final boolean ALL_SERVERS = false;

    private String specificBranches = "consul-provider-payment-8006";

    private static Logger log = LoggerFactory.getLogger(RoundRobinRule.class);

    //初始化这个原子类的值为0，
    public RoundRobinRule() {
        nextServerCyclicCounter = new AtomicInteger(0);
    }

    //这里的ILoadbalance接口其实相当于springcloud中的discoveryclient,可以用来发现服务
    public RoundRobinRule(ILoadBalancer lb) {
        this();
        setLoadBalancer(lb);
    }

    //最重要的地方!!!!!!!!!!!
    public Server choose(ILoadBalancer lb, Object key) {
        //判断lb是否为空
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        }

        Server server = null;
        int count = 0;//计数器
        //循环
        while (server == null && count++ < 10) {
            /**获取可得到的节点，意思就是获取活的节点，心跳还在的节点,这个主要的用处拿来判断活
             *的节点是否为0
             */
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();//获取所有服务
            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            // 这是通过特定参数分支获取对应的服务
            Optional<Server> payment8001 = allServers.stream().filter(server1 -> server1.getMetaInfo().getInstanceId().equals(specificBranches)).findAny();
            Server server1 = payment8001.get();
            System.out.println(server1.getPort());



            //判断服务是否为0
            if ((upCount == 0) || (serverCount == 0)) {
                log.warn("No up servers available from load balancer: " + lb);
                return null;
            }

            //使用CAS来获得上面所有list的一个索引,这个方法的调用在下面
            int nextServerIndex = incrementAndGetModulo(serverCount);
            server = allServers.get(nextServerIndex);

            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }
            //判断一下这个节点是否还在或者可读，如果不可读的话就要重新去找过一个可用的节点
            if (server.isAlive() && (server.isReadyToServe())) {
                return (server);
            }

            // Next.
            server = null;
        }

        //超过10个就不获取的意思吗？这里不是很懂
        if (count >= 10) {
            log.warn("No available alive servers after 10 tries from load balancer: "
                    + lb);
        }
        return server;
    }

    /**
     * Inspired by the implementation of {@link
    AtomicInteger#incrementAndGet()}.
     *
     * @param modulo The modulo to bound the value of the counter.
     * @return The next value.
    说白了就是用来获取list.size()之间的某一个服务
     */
    private int incrementAndGetModulo(int modulo) {
        for (;;) {
            //用CAS来实现，nextServerCyclicCounter是这个类的私有属性，原子类
            int current = nextServerCyclicCounter.get();
            int next = (current + 1) % modulo;
            //判断并比较，如果这个原子的value与期望值相等，那就替换,不然就一直获取最新的值来
            //来进行比较
            if (nextServerCyclicCounter.compareAndSet(current, next))
                return next;
        }
    }


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        System.out.println("iClientConfig:"+iClientConfig);
        System.out.println(iClientConfig.getClientName());
        System.out.println(iClientConfig.getNameSpace());
        System.out.println(iClientConfig.getProperties());
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
}

