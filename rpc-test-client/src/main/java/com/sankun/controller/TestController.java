package com.sankun.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.sankun.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

//    @SofaReference(interfaceType = SampleService.class, binding = @SofaReferenceBinding(bindingType = "bolt"))
//    SampleService sampleService;
    //这里使用 @autowired会报错
    @Resource
    private HelloService helloService;

    @RequestMapping("/test")
    public String test(){
        return helloService.sayHello();
    }

}
