package com.geektime.java.singleton;

/**
 * 饿汉式
 */
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private  Singleton1(){};

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
    /**
     * 优点：这种写法比较简单，就是在类加载的时候就完成了实例化，避免了线程同步问题
     * 缺点：在类装载的时候就完成实例化，没有达到lazyLoading的效果，如果从头到尾没有使用过这个实例，则会早成内存的浪费
     *
     */
}
