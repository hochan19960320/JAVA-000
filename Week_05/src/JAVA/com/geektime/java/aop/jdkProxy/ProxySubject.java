package com.geektime.java.aop.jdkProxy;

public class ProxySubject implements  Subject {
    @Override
    public String SayHello(String name) {
        return "hello " + name;

    }

    @Override
    public String SayGoodBye() {
        return " good bye ";
    }
}
