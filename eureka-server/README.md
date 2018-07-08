## spring-cloud eureka-server

### ��� 

* ��ʾ���ṩeureka-server�ĵ���ģʽ�Լ���Ⱥģʽ

* eurekaһ���ο�
	
	eureka-glance-cn.md
	eureka-glance-en.md

*  Ĭ�������о��ο�

	eureka-overriding-default-config.md

### ��������˵�� 
	
* ����ģʽ �ο������ļ�> 
	
	application-dev.propertoes,����ģʽ������������ע��
	
*  ��Ⱥģʽ �ο������ļ� 

	application-test1.propertoes,application-test2.propertoes,application-test3.propertoes;
	����eureka֮���໥ע��

*  ����ע��ʱ��ʾip��ַ

	eureka.instance.preferIpAddress=true

*  ����ʵ��idΪ ip+port

	eureka.instance.instanceId=${spring.cloud.client.ipAddress}:${server.port}

*  ������ʱ����

	eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:8080/eureka/,
	http://${eureka.instance.hostname}:8081/eureka/


*  ����security����,�����û����Լ�����

	security.basic.enabled=true
	security.user.name=apollo
	security.user.password=1234qwer

*  ��֤����ʱ����

	eureka.client.serviceUrl.defaultZone=http://apollo:1234qwer@${eureka.instance.hostname}:8080/eureka/,
	http://apollo:1234qwer@${eureka.instance.hostname}:8081/eureka/
    	