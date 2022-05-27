package JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 通过AQS实现一个独占锁
 *
*/
public class Mutex implements Lock {

    /**
     * 静态代理模式
     * 代理类:Mutex
     * 被代理类:SYNC
    * */
    private final static Sync SYNC = new Sync();


    @Override
    public void lock() {
        SYNC.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        SYNC.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return SYNC.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return SYNC.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        SYNC.release(1);
    }

    @Override
    public Condition newCondition() {
        return SYNC.newCondition();
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 获取独占锁
         *
         */
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 释放独占锁
         */
        @Override
        protected boolean tryRelease(int arg) {
            if(getState() == 0) {
                throw  new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 是否处于占用状态
         * */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }
}
