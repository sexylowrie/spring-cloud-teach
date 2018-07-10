## spring-cloud config-server

### 简介 

* 配置中心服务端示例

### 单机直连配置 

参考 一下配置，直接启动即可

	application-dev.properties

### 集群高可用配置

参考一下配置，多个服务器部署多个应用，注册到eureka-server集群即可
	  
	1.需要本应用注册到eureka-server集群，pom文件引入
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka</artifactId>
		</dependency>
		
	2.application-test.properties
	
	3.Application类新增@EnableEurekaClient注解 

