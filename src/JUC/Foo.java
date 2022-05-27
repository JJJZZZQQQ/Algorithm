package JUC;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
/**
/**
 * 通过信号量实现
 * 针对second 和 third 都设置一个信号量资源，从而实现线程等待的情况

class Foo {
    Semaphore semaphoreTwo ;
    Semaphore semaphoreThree;
    public Foo() {
        semaphoreTwo = new Semaphore(0);
        semaphoreThree = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphoreTwo.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphoreTwo.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphoreThree.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphoreThree.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
*/

/**
 * 通过Synchronized实现
 * 通过一个变量的值来实现
 * 类似生产者消费者模型
 */
class Foo {
    int x = 1;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (Foo.class) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            x = 2;
            Foo.class.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (Foo.class) {
            while (x != 2) {
                Foo.class.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            x = 3;
            Foo.class.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (Foo.class) {
            // printThird.run() outputs "third". Do not change or remove this line.
            while (x != 3) {
                Foo.class.wait();
            }
            printThird.run();
        }
    }
}
