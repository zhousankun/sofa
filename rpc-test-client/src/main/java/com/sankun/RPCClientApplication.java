package com.sankun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath:rpc-client-config.xml" })
@SpringBootApplication
public class RPCClientApplication {

    public static void main(String[] args) {
        System.out.println("开搞");
        SpringApplication.run(RPCClientApplication.class, args);
    }

}
