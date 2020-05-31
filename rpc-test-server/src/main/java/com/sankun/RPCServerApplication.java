package com.sankun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath:rpc-server-config.xml" })
@SpringBootApplication
public class RPCServerApplication {

    public static void main(String[] args) {
        System.out.println("开搞");
        SpringApplication.run(RPCServerApplication.class, args);
    }

}
