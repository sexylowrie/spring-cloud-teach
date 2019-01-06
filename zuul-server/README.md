## spring-cloud zuul-server 

### 简介 

zuul-server网关项目示例，zuul的核心功能是实现了反向代理，保护了内部服务的安全，
使其不直接对外暴露，本文将介绍zuul的使用以及分析其核心源码的实现。

### zuul实践

如果只是想单纯的实现网关的功能，不需要依赖配置中心等服务，直接使用@EnableZuulServer注解即可

但需要注意配置文件中将不能配置

    