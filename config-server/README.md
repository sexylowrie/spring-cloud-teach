## spring-cloud config-server

### 简介 

配置中心服务端示例

### 1.单机直连配置 

参考以下配置

	bootstrap-dev.properties

### 2.注册到eureka单机

参考以下配置

    bootstrap-test.properties

### 3.注册eureka集群

参考以下配置，部署多个应用即可；

    bootstrap-prod.properties
	
### TIPS
    
    方式1直接从配置中心获取相关配置
    
   	方式2,方式3均是将自己注册到注册中心，然后从注册中心（eureka-server）获取配置中心（config-server）信息，进而获取相关配置
   	
   	方式2注册的eureka-server为单机部署
   	
   	方式3注册的eureka-server为集群部署
   	
    方式2，方式3都需要执行进行以下配置
        
        1.pom文件引入
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
        
        2.Application类新增@EnableEurekaClient注解 
   	

