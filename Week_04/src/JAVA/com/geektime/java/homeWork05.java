package com.geektime.java;

import java.util.concurrent.CountDownLatch;

public class homeWork05 {

    private final static CountDownLatch c = new CountDownLatch(1);

    private static int result = 0;

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();

        CountDownLatchSum(homeWork05.c); //这是得到的返回值
        c.await();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ homeWork05.result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private static void CountDownLatchSum(CountDownLatch c){
        result = homeWork05.sum();
        c.countDown();
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

}
