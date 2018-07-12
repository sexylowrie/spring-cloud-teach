package com.apollo;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * zipkin-client
 * 
 * @author ce.sun
 * @date 2018-07-07
 *
 */
@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	Logger LOGGER=LoggerFactory.getLogger(Application.class);
			
	
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	/**
	 * 	http://localhost:9011/trade
	 * zipkin-clientA --> zipkin-clientB
	 * @return
	 */
	@RequestMapping("/trade")
	public String trade(HttpServletRequest request) {
		LOGGER.info("receive trade request");
		return restTemplate.getForObject("http://localhost:9012/deal/trade", String.class);
	}

	/**
	 * 	http://localhost:9012/refund
	 * zipkin-clientB --> zipkin-clientA
	 * @return
	 */
	@RequestMapping("/refund")
	public String refund() {
		LOGGER.info("receive refund request");
		return restTemplate.getForObject("http://localhost:9011/deal/refund", String.class);
	}

	@RequestMapping("/deal/trade")
	public String dealTrade(HttpServletRequest request) {
		LOGGER.info("deal trade request");
		return "trade success";
	}

	@RequestMapping("/deal/refund")
	public String dealRefund() {
		LOGGER.info("deal refund request");
		return "refound success";
	}

}
