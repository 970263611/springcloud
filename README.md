# springcloud
最新版本2.2.3的springcloud全家桶。包含gateway、eureka、hystrix、feign、ribbon、config。eureka和mvc还有service都是多节点集群部署，用ribbon实现了负载均衡，hystrix实现了熔断保护。实现了gateway和hystrix的整合，feign和hystrix的整合，开箱即用，提供了示例节点，还有使用和测试文档。

## 测试方式

maven install api---编译api项目并把jar放到本地库

**启动顺序：**

1.config

2.eureka-server-1、eureka-server-2、eureka-server-3

3.service-1、service-2、service-3

4.mvc-1、mvc-2

5.gateway

**测试链接：**

**有的时候会持续调到一个节点，因为没刷新配置中心的节点**

 http://localhost:9099/filter（负载均衡和网关代理）

 http://localhost:9099/hystrix 测试hystrix过滤器和熔断

mvc-1会失败跳转，mvc-2成功。失败两次后会熔断10秒

为什么这个需要加mvc节点名字呢---因为这个没有配置路由规则

 http://localhost:9099/mvc/drink?username=dwq&sex=nan&age=24 

service-1和service-3成功，service-2失败

service-2失败会熔断10秒，无法被调用到

**注意：使用此项目需要联网，因为整合了springcloud config，需要去github拉取配置**

如果无法联网，可以删除掉所有项目下bootstrap.properties文件，使用all-properties文件夹下对应的配置文件

查看配置示例：http://localhost:9090/gateway-dev.properties

附：

Spring Cloud Config 有它的一套访问规则，我们通过这套规则在浏览器上直接访问就可以。

```yaml
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```

{application} 就是应用名称，对应到配置文件上来，就是配置文件的名称部分，例如我上面创建的配置文件。

{profile} 就是配置文件的版本，我们的项目有开发版本、测试环境版本、生产环境版本，对应到配置文件上来就是以 application-{profile}.yml 加以区分，例如application-dev.yml、application-sit.yml、application-prod.yml。

{label} 表示 git 分支，默认是 master 分支，如果项目是以分支做区分也是可以的，那就可以通过不同的 label 来控制访问不同的配置文件了。