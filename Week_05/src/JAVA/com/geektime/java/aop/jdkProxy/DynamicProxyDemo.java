package com.geektime.java.aop.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理演示
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        //代理的真实对象
        ProxySubject proxySubject =  new ProxySubject();
        InvocationHandlerImpl handler = new InvocationHandlerImpl(proxySubject);
        ClassLoader loader = proxySubject.getClass().getClassLoader();
        Class[] interfaces = proxySubject.getClass().getInterfaces();
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);
        System.out.println("动态代理对象的类型："+subject.getClass().getName());

        String hello = subject.SayHello("小绵羊");
        System.out.println(hello);


    }


}
