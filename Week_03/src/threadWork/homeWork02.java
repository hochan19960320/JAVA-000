
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class homeWork02 {
    private static int result;

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，

        Thread thread = new Thread(()->homeWork02.result = sum());
        // 异步执行 下面方法

        synchronized (homeWork02.class){
            homeWork02.result = sum();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+homeWork02.result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
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
