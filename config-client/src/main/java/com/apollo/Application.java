package com.apollo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *  配置中心客户端应用示例
 * @author ce.sun
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Value("${foo}")
	private String foo;
	
	@RequestMapping("/foo")
	public String foo() {
		return this.foo;
	}
}
