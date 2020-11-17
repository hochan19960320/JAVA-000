package com.geektime.java;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class homeWork06 {

    private final static CyclicBarrier c = new CyclicBarrier(1,()->{
        System.out.println("异步计算结果为："+ homeWork06.result);
    });

    private static int result;

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();
        homeWork06.CyclicBarrierSum(c);
        // 确保  拿到result 并输出
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }
    private static void CyclicBarrierSum(CyclicBarrier c){
        try {
            result = homeWork06.sum();
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
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
