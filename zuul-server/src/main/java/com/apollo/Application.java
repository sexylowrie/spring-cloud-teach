package com.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.pre.DebugFilter;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class Application {

    @Bean
    public DebugFilter debugFilter(){
        return new DebugFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
