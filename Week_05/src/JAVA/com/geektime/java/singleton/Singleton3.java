package com.geektime.java.singleton;

/**
 * 静态内部类
 */
public class Singleton3 {

    private Singleton3(){}

    /**
     * 静态内部类在外层类被加载时，静态内部类并不会实例化
     */
    private static class SingletonInstance{
        private final static Singleton3 INSTANCE = new Singleton3();
    }
    public static Singleton3 getInstance(){
        return SingletonInstance.INSTANCE;
    }
    /**
     * 和饿汉式一样，JVM类加载机制保证初始化时只有一个线程。而静态内部类方式在Singleton3被装载时并不会立即实例化，而是在需要实例化时，
     * 调用getInstance方法，才会装载SingletonStance类，从而完成singleton的实例化。
     */
}
