package 队列;

import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈 {
    class MyStack {

        private Queue<Integer> queue1;

        private Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<Integer>();
            queue2 = new LinkedList<Integer>();
        }

        public void push(int x) {
            queue2.add(x);
            queue2.addAll(queue1);
            Queue <Integer> t = queue1;
            queue1 = queue2;
            queue2 = t;
            while (!queue2.isEmpty()){
                queue2.remove();
            }
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
