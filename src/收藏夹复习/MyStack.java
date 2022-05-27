package 收藏夹复习;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queueEmpty ;
    Queue <Integer> queueFull ;
    public MyStack() {
        queueEmpty = new LinkedList<>();
        queueFull = new LinkedList<>();
    }

    public void push(int x) {
        queueEmpty.add(x);
        queueEmpty.addAll(queueFull);
        Queue t = queueEmpty;
        queueEmpty = queueFull;
        queueFull = t;

    }

    public int pop() {
        return queueFull.isEmpty() ? -1 : queueFull.poll();
    }

    public int top() {
        return queueFull.isEmpty() ? -1 : queueFull.peek();
    }

    public boolean empty() {
        return queueFull.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */