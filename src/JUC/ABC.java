package JUC;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * 顺序打印ABC
 * 循环十次
 */
public class ABC {
    private final static int N = 10;

    /**
     * 1:A执行
     * 2:B执行
     * 3:C执行
     */
    private int shunxun = 1;

    private Object lock = new Object();

    class A extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < N; i++) {
                    while (shunxun != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    shunxun = 2;
                    lock.notifyAll();
                }
            }
            System.out.println("A执行完");
        }
    }

    class B extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < N; i++) {
                    while (shunxun != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    shunxun = 3;
                    lock.notifyAll();
                }
            }
            System.out.println("B执行完");
        }
    }

    class C extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < N; i++) {
                    while (shunxun != 3) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    shunxun = 1;
                    lock.notifyAll();
                }
            }
            System.out.println("C执行完");
        }
    }

    @Test
    public void test() throws InterruptedException {
        new A().start();
        new B().start();
        new C().start();
        Thread.sleep(1000);
    }
}


