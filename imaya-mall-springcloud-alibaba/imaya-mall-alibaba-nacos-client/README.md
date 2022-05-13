## 前言
Spring Cloud 构建于 Spring Boot 之上，在 Spring Boot 中有两种上下文，一种是 bootstrap，另外一种是 application。


## 区别
bootstrap.yml 和 application.yml 都可以用来配置参数。

bootstrap.yml 用来程序引导时执行，应用于更加早期配置信息读取。可以理解成系统级别的一些参数配置，这些参数一般是不会变动的。

application.yml 可以用来定义应用级别的， 应用程序特有配置信息，可以用来配置后续各个模块中需使用的公共参数等。
如果搭配 spring-cloud-config 使用， application.yml 里面定义的文件可以实现动态替换。

## 加载顺序
若application.yml 和 bootstrap.yml 在同一目录下：bootstrap.yml 先加载，application.yml 后加载

bootstrap.yml 用 application 上下文的引导阶段。bootstrap.yml 由父 Spring ApplicationContext 加载。


## 属性覆盖问题
启动上下文时，Spring Cloud 会创建一个 Bootstrap Context，作为 Spring 应用的 Application Context 的父上下文。

初始化的时候，Bootstrap Context 负责从外部源加载配置属性并解析配置。这两个上下文共享一个从外部获取的 Environment。

> 但是若 application.yml 与 bootstrap 存在相同的配置项，还是会覆盖 bootstrap，而 application.yml 里面的内容可以动态替换。

## bootstrap.yml典型的应用场景
- 当使用 Spring Cloud Config Server （或者Spring Cloud Alibaba Nacos）配置中心时，
这时必须将 spring.application.name 和 spring.cloud.config.server.git.uri（或者spring.cloud.nacos.config）配置在 bootstrap.yml 配置文件中，
添加连接到配置中心的配置属性来加载外部配置中心的配置信息
- 一些固定不变的属性
- 一些加密/解密的场景

如果说 Eureka 是第一代服务发现与服务注册组件，那么，Alibaba Nacos 就是第二代服务发现与服务注册组件。相对于 Eureka 来说，Nacos 效率更高，且功能更加丰富，目前已经被广泛的应用到各个微服务架构的工程中去了。

## 1 开发环境下使用简单的 Nacos 单机版本就可以了，但是生产环境，一定要搭建集群版本，这里面有哪些细节吗？
- 想要搭建集群版本，需要做哪些配置？这些配置参数又是什么含义呢？…
- 使用单机版本与集群版本，工程应该怎么去配置呢？…

## 2 Nacos 是如何实现服务注册与发现的呢？
- 它在保存注册的微服务的元信息时，使用了什么样的数据结构呢？…
- 它是怎么支持服务发现的？…
- 注册的微服务肯定要去考虑心跳监测，你能说清楚这里面的逻辑吗?..

## 3 动态配置其实是使用了 Nacos 的配置管理功能，这里面有些细节你需要考虑？
- Nacos 是如何定位一条配置的？即它的数据模型是怎样的？…
- 微服务是 pull Nacos 中的配置，还是 Nacos 向微服务去 push 呢？…
