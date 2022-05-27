package JUC;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        ConditionUseCase conditionUseCase = new ConditionUseCase();

        new Thread(() -> {
            try {
                conditionUseCase.conditionWait1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                conditionUseCase.conditionSignal1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                conditionUseCase.conditionWait2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                conditionUseCase.conditionSignal1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



    }
    public void test () {
        Object o = new Object();
        Thread thread = new Thread();
        thread.interrupt();
        thread.isInterrupted();
        thread.stop();
    }
    class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("线程一直在执行");
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                }
            }catch (InterruptedException e) {
                Logger.getLogger(MyThread.class.getName()).info(Thread.currentThread().getName() + "线程结束了");
            }
        }
        //AtomicInteger
    }
    private static class Sync extends AbstractQueuedSynchronizer {

    }
}
