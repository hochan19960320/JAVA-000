package com.geektime.java.singleton;

/**
 * 懒汉式双重检查
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2(){}

    public static  Singleton2 getInstance(){
        if(singleton2 == null){
            synchronized (Singleton2.class){
                if(singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
    /**
     * 优点：线程安全，延迟加载，效率高。
     */
}
