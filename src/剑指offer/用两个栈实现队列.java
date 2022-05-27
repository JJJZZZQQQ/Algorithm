package 剑指offer;


import java.util.Stack;

/** 思路：
 * 一个栈全部放进去然后再全部拿出来，就会倒序一次，我们执行一次这样的操作，
 * 那么从第二个栈的头部拿出来的值相当于栈一尾部的值
 * 这样就实现了一头进，一头出的操作*/
class 用两个栈实现队列 {

    Stack<Integer> stack1;
    Stack<Integer>stack2;
    public 用两个栈实现队列() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        //出队队列不为空
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        //出队队列为空
        else {
            //入队队列为空
            if(stack1.isEmpty())
                return -1;
            else {
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
