#spring-cloud eureka-server


###配置说明
	
单机模式 参考配置文件> 
	
	application-dev.propertoes,单机模式不向其他服务注册
	
集群模式 参考配置文件 

	application-test1.propertoes,application-test2.propertoes,application-test3.propertoes;
	三组eureka之间相互注册

配置注册时显示ip地址

	eureka.instance.preferIpAddress=true

配置实例id为 ip+port

	eureka.instance.instanceId=${spring.cloud.client.ipAddress}:${server.port}

开启security配置,配置用户名以及密码

	security.basic.enabled=true
	security.user.name=apollo
	security.user.password=1234qwer

无密码时配置

	eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:8080/eureka/,
	http://${eureka.instance.hostname}:8081/eureka/

验证密码时配置

	eureka.client.serviceUrl.defaultZone=http://apollo:1234qwer@${eureka.instance.hostname}:8080/eureka/,
	http://apollo:1234qwer@${eureka.instance.hostname}:8081/eureka/
    	