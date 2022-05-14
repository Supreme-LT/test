package cn.edu.goodsprovider;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient//能够被注册中心发现，能够扫描到这个服务
@MapperScan(basePackages = "cn.edu.goodsprovider.dao")
@EnableCircuitBreaker//熔断机制的开启
public class GoodsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsProviderApplication.class, args);
    }

    //配置收集流数据的servlet
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(servlet);
        registration.setName("HystrixMetricsStreamServlet");
        registration.setLoadOnStartup(1);
        registration.addUrlMappings("/hystrix.stream");
        return registration;
    }

}
