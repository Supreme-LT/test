package cn.edu.customerprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.edu.customerprovider.dao")
public class CustomerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerProviderApplication.class, args);
    }

}
