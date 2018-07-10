###Eureka提供了内置的默认设置。

默认配置，适用于大多数场景；您可以使用任何您想要的机制扩展以下默认配置类，以提供您自己的配置值。 **注意:请不要使用这些接口 **，它们只是用于文档目的，将来可能会改变

* [Cloud配置](https://github.com/netflix/eureka/blob/master/eureka - client/src/main/java/java/java/java/com/netflix/appflix/appinfo/appinfo/index.java)
		
		
* [Eureka客户端](https://github.com/Netflix/eureka/blob/master/eureka-client/src/main/java/com/netflix/discovery/DefaultEurekaClientConfig.java)


* [Eureka服务端](https://github.com/Netflix/eureka/blob/master/eureka-core/src/main/java/com/netflix/eureka/DefaultEurekaServerConfig.java)

请注意，上面的内容还作为Eureka中所有上述配置的默认配置值的文档。

###自定义注册信息

有时，您可能想要为注册和查询添加特定于部署环境的自定义元数据。例如，您可能想要传播一个定制的环境id，该id对于您的特定部署env应该是可用的。Eureka提供了添加自定义元数据作为键的能力:标准注册数据之外的值对。你可以用两种方法做到:

*   获取配置数据

	String myValue = instanceInfo.getMetadata().get("myKey");

* 通过配置静态设置:

	eureka.metadata.mykey=myvalue 将键值对添加到eureka的Metadata中。

通过代码动态设置:

要动态地做到这一点，您首先需要提供您自己的自定义实现[EurekaInstanceConfig](https://github.com/Netflix/eureka/blob/master/eureka-client/src/main/java/com/netflix/appinfo/EurekaInstanceConfig.java)接口。然后可以重载public Map<String, String> getMetadataMap()方法，以返回包含所需元数据值的元数据映射。
可以参考[PropertiesInstanceConfig](https://github.com/Netflix/eureka/blob/master/eureka-client/src/main/java/com/netflix/appinfo/PropertiesInstanceConfig.java)，了解提供上述基于配置的系统的示例实现。