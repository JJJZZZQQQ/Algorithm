package JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 需求：限制只有N个线程可以获取资源，其他的线程会阻塞
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for(int i = 0 ; i < THREAD_COUNT ;i++) {
            threadPool.execute( () -> {
                try {
                    s.acquire();
                    //s.tryAcquire();
                    System.out.println("save Date");
                    s.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

        threadPool.shutdown();
    }
}
