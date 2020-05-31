package com.alipay.mytestsofa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource({"classpath*:META-INF/myserver-app/*.xml"})
@SpringBootApplication
public class MyServerAppSpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(MyServerAppSpringApplication.class);

    public static void main(String[] args) {
        //*************** 注意 ******************//
        //1. 本地同时启动 myserver-app 和 myclient-app 时，由于 tomcat 端口冲突问题，需要修改 myserver-app 的 端口号为 8083
        //2. 将 myserver-app 和 myclient-app 发布到云上环境时，由于默认健康检查端口是 8080，所以需要注释掉这行代码
        System.setProperty("server.port", "8083");

        SpringApplication.run(MyServerAppSpringApplication.class);

        printMsg("SofaRpc Application (myserver-app) started on 8083 port.");
    }

    private static void printMsg(String msg) {
        System.out.println(msg);
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }
}
