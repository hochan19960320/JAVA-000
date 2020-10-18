package com.geektime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoaderTest {

    public static void main(String[] args) {
        HelloClassLoader loader = new HelloClassLoader("E:\\geek-JAVA\\JAVA-000\\Week_01\\src\\com\\geektime\\");
        try {
            Class<?> clazz = loader.loadClass("Hello");
            System.out.println("加载此类的类的加载器为: " +clazz.getClassLoader().getClass().getName());
            System.out.println("加载此类的类的父类加载器为: " +clazz.getClassLoader().getParent().getClass().getName());

            try {
                System.out.println("调用hello方法结果为:");
                Method method = clazz.getMethod("hello");
                method.invoke(clazz.newInstance());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
