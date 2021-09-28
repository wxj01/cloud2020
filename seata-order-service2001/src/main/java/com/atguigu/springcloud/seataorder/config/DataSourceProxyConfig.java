package com.atguigu.springcloud.seataorder.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * @author wxj
 * @version 1.0
 * @description: TODO 使用Seata对数据源进行代理
 * @date 2021/9/26 0026 16:56
 */
@Configuration
public class DataSourceProxyConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    @Bean
    public DataSourceProxy dataSourceProxy(DataSource dataSource){
        return new DataSourceProxy(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceProxy);

//      sqlSessionFactoryBean调用的方法中setMapperLocations可能是导致读取不到mapper资源的原因
//
//关于PathMatchingResourcePatternResolver : https://www.cnblogs.com/loveLands/articles/9863195.html
//果然getResource 和 getResources不同
//
//getResource()：
//1.从类的根路径下获取文件
//getResources():
//1.获取所有类路径下的指定文件
//可以通过classpath前缀指定，从所有的类路径下获取指定文件，与classpath前缀的区别是classpath前缀只能获取当类路径下的资源文件，而classpath前缀可以获取所有类路径下的资源文件，包括jar包中的。
//      sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource(mapperLocations));



        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        return sqlSessionFactoryBean.getObject();
    }
}