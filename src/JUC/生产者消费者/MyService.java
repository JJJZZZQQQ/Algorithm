package JUC.生产者消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition producerCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();
    private boolean hasValue =  false;

    public void set() {
        try {
            lock.lock();
            while (hasValue == true) {
                producerCondition.await();
            }
            System.out.println("生产者生产了★");
            hasValue = true;
            consumerCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (hasValue == false) {
                consumerCondition.await();
            }
            System.out.println("消费者消费了☆");
            hasValue = false;
            producerCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
