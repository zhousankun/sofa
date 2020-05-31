package com.alipay.samples.rpc.impl;

import com.alipay.samples.rpc.SampleService;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import org.springframework.stereotype.Service;

@Service
@SofaService(interfaceType = SampleService.class , bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class SampleServiceImpl implements SampleService {
    private int count = 0;

    @Override
    public String hello() {
        return "Hello sankun !!! SOFARpc! times = " + count++;
    }
}
