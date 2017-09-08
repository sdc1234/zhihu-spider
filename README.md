1.项目背景

从一开始是想编写一个单纯的知乎爬虫，并实现其持久化，并由此展开周期性爬取知乎问题及答案以及其用户资料信息，完善前后端分离归档分类，信息检索等项目模块。但是在实现过程中，我逐渐发现自己对信息爬取的技能知识掌握严重不足，萌发了搭建知乎信息中转持久化的数据流平台，并提供HTML+JSON和RabbitMQ等消息接口，从而使有兴趣的伙伴开发并使用其熟悉的语言环境，实现信息爬取，从而持久化到此项目中来，完成最开始的开发目标。

2.项目的基础理论

(1).面向数据流的项目开发。将我需要什么数据，转换为我能提供什么功能让你帮我提供什么样的数据。实现从信息获取，信息持久，信息展示，信息检索的整体的数据流功能程序开发。

(2).面向接口的项目开发。采用HTML+JSON和RabbitMQ的消息接口，从而让异构系统可轻松调用，爬虫的客户端、服务器端、信息展示的前端可实现完美解耦，职责清晰，并行开发。
    
3.项目的部署运行

推荐基于Docker容器的部署运行

(1).项目的部署运行依赖于mysql和rabbitmq，请准确配置其内容后进行打包部署

(2).在其项目根目录下使用gradle打成jar包

```
$ gradle build

//打成的jar包默认在./build/libs路径下。
```
(3).将jar包上传至/home/zhuhu路径下

(4).编写Dockerfile文件
    
```
FROM keensoft/centos7-java8

MAINTAINER sunzc

# set timezone to PRC
ENV TZ="Asia/Shanghai" LANG=en_US.UTF-8  PRO_ENV="prod"

ADD zhihu-spider-1.0.0.jar /home/App.jar

ENTRYPOINT java -jar /home/App.jar
```

(5).编写start.sh文件，用于启动jar程序，并且镜像启动后执行
    
```
java -jar /home/App.jar

```
(6).编写docker打镜像命令文件build.sh

```
docker build -t cacubd-server-collector:0.0.1 .

```

(7).通过Dockerfile和build.sh将jar包打成docker镜像

```
$ sh build.sh

#打成的镜像信息为 zhihu-spider:1.0.0
```

(8).通过docker run命令启动docker容器

```
docker run --name zhihu-spider -p 8902:8080 -v /home/zhihu/logs:/home/zhihu/logs -e TZ=Asia/Shanghai    -e  spring.profiles.active=local  --restart=always -d zhihu-spider:1.0.0

//详细信息可参考 http://blog.csdn.net/sun1021873926/article/details/72862644
```

(9).项目启动后查看启动日志

```
$ docker logs -f zhihu-spider
```

(10).成功启动后访问swagger资源页面，检测restful风格的方法调用

```
//访问路径如下

//http://127.0.0.1:8902
```

(11).当然，当打包成jar后，也可以直接使用以下命令在java8的环境中启动

```
$ java -jar zhihu-spider-1.0.0.jar
```

4.项目的发展方向

(1).项目的多版本客户端配套开发。初步规划应包含go,python,java,php等语言的爬虫功能，并通过接口进行数据的持久化实现。

(2).前端信息展示和信息检索的配套开发。初步规前端端完全分离，使用Redux+Flux+webpack+Babel进行整合开发。

(3).服务器端多节点微服务设计实现，依赖中间件的集群部署实现，从而提高项目生产环境的可靠性和稳定性。

5.相关文档链接

[zhihu-spider之Lombok——zhihu-spider开源项目使用技术详解（其一）](http://blog.csdn.net/sun1021873926/article/details/73354634)

[zhihu-spider之Swagger——zhihu-spider开源项目使用技术详解（其二）](http://blog.csdn.net/sun1021873926/article/details/74078235)

[zhihu-spider之Druid——zhihu-spider开源项目使用技术详解（其三）](http://blog.csdn.net/sun1021873926/article/details/74504997)

[zhihu-spider之Mybatis——zhihu-spider开源项目使用技术详解（其四）](http://blog.csdn.net/sun1021873926/article/details/75138982)

[zhihu-spider之RabbitMQ——zhihu-spider开源项目使用技术详解（其五）](http://blog.csdn.net/sun1021873926/article/details/75576786)

[zhihu-spider之Feign——zhihu-spider开源项目使用技术详解（其六）](http://blog.csdn.net/sun1021873926/article/details/76692867)

[zhihu-spider之Hystrix——zhihu-spider开源项目使用技术详解（其七）](http://blog.csdn.net/sun1021873926/article/details/76695362)