###Eureka�ṩ�����õ�Ĭ�����á�

Ĭ�����ã������ڴ����������������ʹ���κ�����Ҫ�Ļ�����չ����Ĭ�������࣬���ṩ���Լ�������ֵ�� **ע��:�벻Ҫʹ����Щ�ӿ� **������ֻ�������ĵ�Ŀ�ģ��������ܻ�ı�

* [Cloud����](https://github.com/netflix/eureka/blob/master/eureka - client/src/main/java/java/java/java/com/netflix/appflix/appinfo/appinfo/index.java)
		
		
* [Eureka�ͻ���](https://github.com/Netflix/eureka/blob/master/eureka-client/src/main/java/com/netflix/discovery/DefaultEurekaClientConfig.java)


* [Eureka�����](https://github.com/Netflix/eureka/blob/master/eureka-core/src/main/java/com/netflix/eureka/DefaultEurekaServerConfig.java)

��ע�⣬��������ݻ���ΪEureka�������������õ�Ĭ������ֵ���ĵ���

###�Զ���ע����Ϣ

��ʱ����������ҪΪע��Ͳ�ѯ����ض��ڲ��𻷾����Զ���Ԫ���ݡ����磬��������Ҫ����һ�����ƵĻ���id����id���������ض�����envӦ���ǿ��õġ�Eureka�ṩ������Զ���Ԫ������Ϊ��������:��׼ע������֮���ֵ�ԡ�����������ַ�������:

*   ��ȡ��������

	String myValue = instanceInfo.getMetadata().get("myKey");

* ͨ�����þ�̬����:

	eureka.metadata.mykey=myvalue ����ֵ����ӵ�eureka��Metadata�С�

ͨ�����붯̬����:

Ҫ��̬��������һ�㣬��������Ҫ�ṩ���Լ����Զ���ʵ��[EurekaInstanceConfig](https://github.com/Netflix/eureka/blob/master/eureka-client/src/main/java/com/netflix/appinfo/EurekaInstanceConfig.java)�ӿڡ�Ȼ���������public Map<String, String> getMetadataMap()�������Է��ذ�������Ԫ����ֵ��Ԫ����ӳ�䡣
���Բο�[PropertiesInstanceConfig](https://github.com/Netflix/eureka/blob/master/eureka-client/src/main/java/com/netflix/appinfo/PropertiesInstanceConfig.java)���˽��ṩ�����������õ�ϵͳ��ʾ��ʵ�֡�