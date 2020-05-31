package io.sofastack.stockmng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockMngApplication {

    public static void main(String[] args) {
        System.out.println("开搞");
        //*************** 注意 ******************//
        //1. 本地同时启动 myserver-app 和 myclient-app 时，由于 tomcat 端口冲突问题，需要修改 myclient-app 的 端口号为 8084
        //2. 将 myserver-app 和 myclient-app 发布到云上环境时，由于默认健康检查端口是 8080，所以需要注释掉该行代码
        //System.setProperty("server.port", "8084");
        //3. 由于本地启动没有注册中心，所以使用本地直连的方式访问本地启动的 myserver-app，发布到线上的时候需要注释掉该行代码
        //System.setProperty("run.mode", "TEST");
        //********************************//
        SpringApplication.run(StockMngApplication.class, args);

    }

}
