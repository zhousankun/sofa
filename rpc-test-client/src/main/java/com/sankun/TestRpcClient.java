package com.sankun;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.sankun.service.HelloService;
import io.sofastack.balance.manage.facade.BalanceMngFacade;

public class TestRpcClient {
    public static void main(String[] args) {
        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName()) // 指定接口
                .setProtocol("bolt") // 指定协议
                .setDirectUrl("bolt://127.0.0.1:12200"); // 指定直连地址
        // 生成代理类
        HelloService helloService = consumerConfig.refer();
        while (true) {
            System.out.println(helloService.sayHello());
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }
//
//        ConsumerConfig<BalanceMngFacade> consumerConfig = new ConsumerConfig<BalanceMngFacade>()
//                .setInterfaceId(BalanceMngFacade.class.getName()) // 指定接口
//                .setProtocol("bolt") // 指定协议
//                .setDirectUrl("bolt://127.0.0.1:22200"); // 指定直连地址
//        // 生成代理类
//        BalanceMngFacade balanceMngFacade = consumerConfig.refer();
//        while (true) {
//            balanceMngFacade.createUser("zhouasnkun");
//            System.out.println("好了");
//            try {
//                Thread.sleep(2000);
//            } catch (Exception e) {
//            }
//        }

    }
}
