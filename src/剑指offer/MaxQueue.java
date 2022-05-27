package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    Queue<Integer> queue;
    //递减队列
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) return -1;
        return deque.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        //把所有小于value的数全部在有序队列中弹出
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.addLast(value);
    }


    public int pop_front() {
        if (queue.isEmpty()) return -1;
        Integer poll = queue.poll();
        if (poll.equals(deque.peek())) {
            deque.pollFirst();
        }
        return poll;
    }
}
