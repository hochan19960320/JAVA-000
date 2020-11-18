package com.geektime.java.aop.staticProxy;

/**
 * 静态代理实现aop
 */
public class aopSimpleDemo {
    public static void main(String[] args) {
        ProxySVCImpl proxySVC = new ProxySVCImpl(new TargetSVCImpl());
        proxySVC.execute();

    }
}
