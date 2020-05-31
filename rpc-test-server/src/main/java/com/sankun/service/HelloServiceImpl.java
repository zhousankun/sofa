package com.sankun.service;

public class HelloServiceImpl implements HelloService{
    static int count = 0;
    public String sayHello() {
        return "hello !!!~~~~~~~~~~~你已经hello的次数"+(++count);
    }
}
