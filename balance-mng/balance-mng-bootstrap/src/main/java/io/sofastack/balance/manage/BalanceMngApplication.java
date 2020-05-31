package io.sofastack.balance.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author yuanyuan
 * @since 2019/6/10
 */
@SpringBootApplication
//@ImportResource({ "classpath:rpc-server-config.xml" })
public class BalanceMngApplication {
    public static void main(String[] args) {
        SpringApplication.run(BalanceMngApplication.class, args);
    }
}
