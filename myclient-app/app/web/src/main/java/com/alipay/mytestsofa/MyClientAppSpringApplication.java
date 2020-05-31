package com.alipay.mytestsofa;

import com.alipay.samples.rpc.SampleService;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.TimeUnit;

//@ImportResource({"classpath*:META-INF/myclient-app/*.xml"})
@SpringBootApplication
public class MyClientAppSpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(MyClientAppSpringApplication.class);

    public static void main(String[] args) {
        //*************** 注意 ******************//
        //1. 本地同时启动 myserver-app 和 myclient-app 时，由于 tomcat 端口冲突问题，需要修改 myclient-app 的 端口号为 8084
        //2. 将 myserver-app 和 myclient-app 发布到云上环境时，由于默认健康检查端口是 8080，所以需要注释掉该行代码
        System.setProperty("server.port", "8084");
        //3. 由于本地启动没有注册中心，所以使用本地直连的方式访问本地启动的 myserver-app，发布到线上的时候需要注释掉该行代码
        System.setProperty("run.mode", "TEST");
        //********************************//

        SpringApplication springApplication = new SpringApplication(MyClientAppSpringApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);

        if (logger.isInfoEnabled()) {
            printMsg("SofaRpc Application (myclient-app) started on 8084 port.");
        }

        //2. 调用 SOFARpc 服务
        final SampleService sampleService = (SampleService) applicationContext.getBean("sampleServiceRef");

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        String response = sampleService.hello();
//                        printMsg("Response from myserver-app: " + response);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        try {
//                            TimeUnit.SECONDS.sleep(3);
//                        } catch (InterruptedException e) {
//                            //ignore
//                        }
//                    }
//
//                }
//
//            }
//        }).start();

//        //3. 调用 SOFARest 服务
//        final SampleRestFacade sampleRestFacade = (SampleRestFacade) applicationContext.getBean("restServiceRef");

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        String response = sampleRestFacade.hello();
//                        //如果需要体验 SofaRest 功能，取消注释掉以下代码即可
//                        //printMsg("Response from myserver-app: " + response);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        try {
//                            TimeUnit.SECONDS.sleep(3);
//                        } catch (InterruptedException e) {
//                            //ignore
//                        }
//                    }
//
//                }
//
//            }
//        }).start();

    }

    private static void printMsg(String msg) {
        System.out.println(msg);
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }
}
