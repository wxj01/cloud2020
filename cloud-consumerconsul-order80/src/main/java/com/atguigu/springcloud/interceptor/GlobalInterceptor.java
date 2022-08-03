package com.atguigu.springcloud.interceptor;

import com.atguigu.springcloud.util.FeatureContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalInterceptor implements HandlerInterceptor {

    //http://dev-finance.sany.com.cn/client/muti1#/index
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        String path = request.getRequestURI();

//        Optional<String> any = Arrays.stream(path.split("/")).filter(s -> s.contains("#")).findAny();
//        String result = any.get().replace("#", "");

        // 从uri 获取featureName 参数
        String[] split = path.split("/");
        String result = split[split.length - 1];
        System.out.println(result);

        System.out.println(result);

        //如果参数不为空，放入threadLocal 中
//        if (result != null ) {
//            FeatureContext.set(result);
//        }

        FeatureContext.set("consul-provider-payment-8008");

        return true;

//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
