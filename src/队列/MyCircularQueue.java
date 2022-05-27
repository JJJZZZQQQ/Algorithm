package 队列;

class MyCircularQueue {

    private int[] array;

    private int n;

    private int head = 0;
    private int tail = 0;

    public MyCircularQueue(int k) {
        this.array = new int[k + 1];
        this.n = k + 1;
    }

    public boolean enQueue(int value) {
        //队列满的情况
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % n;
        return true;
    }

    public boolean deQueue() {
        //队列空的情况
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % n;
        return true;
    }

    public int Front() {
        //队列空的情况
        if (isEmpty()) {
            return -1;
        }
        return array[head];
    }

    public int Rear() {
        //队列空的情况
        if (isEmpty()) {
            return -1;
        }
        int t = tail - 1;
        if(t < 0)t += n;
        return array[t];
    }

    public boolean isEmpty() {
        //队列空的情况
        if (head == tail) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (head == (tail + 1) % n) {
            return true;
        } else {
            return false;
        }
    }
}
