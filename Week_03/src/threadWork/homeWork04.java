import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class homeWork04 {

    private final static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，

        int result = sum(homeWork04.semaphore); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private static int sum(Semaphore semaphore){
        try{
            semaphore.acquire();
            return fibo(36);
        }catch(InterruptedException e){
            return 0;
        }finally {
            semaphore.release();
        }
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
