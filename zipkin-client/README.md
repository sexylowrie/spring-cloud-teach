## spring-cloud zipkin-client 

### 简介 

zipkin客户端示例

### 1.开发演示配置 

参考以下配置

	application-dev1.properties
	application-dev2.properties

### 2.测试演示配置

参考以下配置

    application-test1.properties
    application-test2.properties

### 3.生产演示配置

参考以下配置

    application-prod.properties
	
### TIPS
    
    生产保证zipkin-server多机部署，利用域名+负载工具实现高可用
    
    在客户端配置zipkin-server相应的域名即可
