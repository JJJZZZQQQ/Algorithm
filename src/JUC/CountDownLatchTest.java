package JUC;


import java.util.concurrent.CountDownLatch;

/**
 * 需求：实现一个线程等待多个线程执行完成之后再执行
 * 方法1：使用Thread类的Join方法
 * 方法2：使用CountDownLatch类
 */
public class CountDownLatchTest {
    private static final int N = 2;

    static CountDownLatch c = new CountDownLatch(N);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            c.countDown();
        }).start();
        new Thread(() -> {
            System.out.println(2);
            c.countDown();
        }).start();

        c.await();
        System.out.println(3);
    }
}
