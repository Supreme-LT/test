package cn.edu.goodsui.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//标明这是一个配置类
public class AppConfig {

    //ribbon 调用使用的是RestTempLate对象
    @LoadBalanced//负载均衡设置(启动ribbon的负载均衡)
    @Bean//相当于 配置文件中的<bean></bean>
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
