package JUC;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public void conditionWait1() throws InterruptedException {
        lock.lock();
        try {
            condition1.await();
        } finally {
            lock.unlock();
        }
        System.out.println("wait执行完毕");
    }

    public void conditionSignal1() throws InterruptedException {
        lock.lock();

        try {
            condition1.signal();
        }finally {
            lock.unlock();
        }
        System.out.println("sign执行完毕");
    }
    public void conditionWait2() throws InterruptedException {
        lock.lock();
        try {
            condition2.await();
        } finally {
            lock.unlock();
        }
        System.out.println("wait执行完毕");
    }

    public void conditionSignal2() throws InterruptedException {
        lock.lock();

        try {
            condition2.signal();
        }finally {
            lock.unlock();
        }
        System.out.println("sign执行完毕");
    }

}
