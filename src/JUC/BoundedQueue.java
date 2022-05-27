package JUC;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * take方法：如果队列已经空了，那就阻塞线程，取出来一个对象之后就唤醒所有线程
 *
 * put方法：如果队列已经满了，那就阻塞线程，添加进去一个对象之后就唤醒所有线程
 *
 * 注意：通过数组实现队列，还隐含了一个用数组实现循环队列的思路
 */
public class BoundedQueue <T>{

    private Object [] items;

    private Lock lock = new ReentrantLock();

    private int capacity;

    private int size = 0;

    /**
     * 用数组实现的队列，需要保存队头和队尾的下标
     */
    private int head , tail;

    /**
     * 由于队列满了阻塞的生产者线程
     */
    private Condition fullCondition = lock.newCondition();

    /**
     * 由于队列空了阻塞的消费者线程
     */
    private Condition emptyCondition = lock.newCondition();


    public BoundedQueue(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
    }

    public void put(T t) {
        lock.lock();
        try {
            while (size == capacity) {
                fullCondition.await();
            }
            items[head] = t;
            //循环添加到数组中
            if(++head == capacity) {
                head = 0;
            }
            ++size;
            emptyCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    public T take() {
        lock.lock();
        try {
            while (size == 0) {
                emptyCondition.await();
            }
            Object x = items[tail];
            if(++tail == capacity) {
                tail = 0;
            }
            --size;
            fullCondition.signalAll();
            return (T) x;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }


}
