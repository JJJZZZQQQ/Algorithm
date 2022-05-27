package JUC;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 场景：线程间交换数据
 * 需求：校对两个人的工作结果是否一致
 */
public class ExchangerTest {
    //交换器
    private static final Exchanger<String> EXCHANGER = new Exchanger<String>();
    //线程池
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            String A = "银行流水A";
            try {
                String B = EXCHANGER.exchange(A);
                System.out.println(B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            String B = "银行流水B";
            try {
                String A = EXCHANGER.exchange(B);
                System.out.println(A);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.shutdown();
    }

}
