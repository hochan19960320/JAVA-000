package com.geektime.java.aop.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 加入aop操作的类，实现InvocationHandler接口
 */
public class InvocationHandlerImpl implements InvocationHandler {

    /**
     * 我们要代理的真实的对象
     */
    private Object subject;

    /**
     * 构造方法,传入需要代理的对象
     * @param subject
     */
    public InvocationHandlerImpl(Object subject) {
        this.subject = subject;
    }

    /**
     *
     * @param proxy  代理类实例
     * @param method 被调用的方法对象
     * @param args   调用参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("在调用之前，我要干点啥呢？");

        System.out.println("Method:" + method);

        Object returnValue = method.invoke(subject, args);

        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("在调用之后，我要干点啥呢？");

        return returnValue;
    }
}
