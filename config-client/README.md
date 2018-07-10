## spring-cloud config-client 

### 简介 

* 配置中心客户端示例

### 单机直连配置 

参考 一下配置，直接启动即可；此方式直接从配置中心获取相关配置

	application-dev.properties

### 集群高可用配置

参考一下配置，部署多个应用即可；此方式是将自己注册到注册中心，然后从注册中心（eureka-server）获取配置中心（config-server）信息，进而获取相关配置
	  
	1.需要本应用注册到eureka-server集群，所以pom文件需要引入
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka</artifactId>
		</dependency>
		
	2.application-test.properties
	
	3.Application类新增@EnableEurekaClient注解 

