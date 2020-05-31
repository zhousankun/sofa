package com.alipay.mytestsofa.controller;

import com.alipay.samples.rpc.SampleService;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @SofaReference(interfaceType = SampleService.class, binding = @SofaReferenceBinding(bindingType = "bolt"))
    SampleService sampleService;

    @RequestMapping("/test")
    public String test(){
        return sampleService.hello();
    }

}
