# 该镜像需要依赖的基础镜像
FROM openjdk:8
# 指定维护者名称
MAINTAINER tanli tanli_0908@163.com
# 将targer目录下的jar包复制到docker容器/home/springboot目录下面目录下面
ADD ./target/tan-tools-0.0.1-SNAPSHOT.jar /home/springboot/tan-tools-0.0.1-SNAPSHOT.jar
# 声明服务运行在8080端口
EXPOSE 8888
# 执行命令
CMD ["nohup","java","-jar","/home/springboot/tan-tools-0.0.1-SNAPSHOT.jar","&"]
