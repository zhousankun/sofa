package com.sankun;


import com.alipay.sofa.rpc.config.ApplicationConfig;
import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.RegistryConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import com.sankun.service.HelloService;
import com.sankun.service.HelloServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ServerPublic {
    public static void main(String[] args) {
        //1、 构建RegistryConfig 注册配置
        RegistryConfig registryConfig = new RegistryConfig().setProtocol("sofa").setAddress("127.0.0.1:9603");
//        RegistryConfig registryConfig1 = new RegistryConfig().setProtocol("zookeeper").setAddress("127.0.0.1:2181");
        List<RegistryConfig> registryConfigs = new ArrayList<RegistryConfig>();
        registryConfigs.add(registryConfig);
//        registryConfigs.add(registryConfig1);
        // 2、构建ServerConfig 服务配置
        List<ServerConfig> serverConfigs = new ArrayList<ServerConfig>();
        ServerConfig serverConfig = new ServerConfig().setProtocol("bolt").setPort(12200).setDaemon(false);
        ServerConfig serverConfig1 = new ServerConfig().setProtocol("rest").setPort(12200).setDaemon(false);
        serverConfigs.add(serverConfig);
        serverConfigs.add(serverConfig1);
        // 3、构建发布配置
        ProviderConfig<HelloService> providerConfig = new ProviderConfig<HelloService>()
                .setApplication(new ApplicationConfig()
                        .setAppName("paul"))
                .setInterfaceId(HelloService.class.getName())
                .setRef(new HelloServiceImpl())
                .setServer(serverConfigs)
                .setRegistry(registryConfig);
        // 4、正式发布
        providerConfig.export();
    }
}
