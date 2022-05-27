package 剑指offer;

import java.util.Stack;

public class 验证栈序列 {

    public boolean validateStackSequencesx(int[] pushed, int[] popped) {
        //一个栈
        Stack<Integer> stack = new Stack<Integer>();
        int pushIndex = 0;
        for(int popIndex = 0;  popIndex < popped.length ; popIndex++) {
            //当pop时，判断栈顶是否是要pop 的元素，如果是，就直接pop，
            if(!stack.isEmpty() && stack.peek().equals(popped[popIndex])) {
                stack.pop();
                popIndex++;
            } else {
                //如果不是,或者为空,从push队列中push进栈直到为要pop的元素，然后再把队顶pop
                //如果push队列已经空了，那么就说明此时pop的顺序不对，返回false。
                while(pushIndex < pushed.length && pushed[pushIndex] != popped[popIndex]) {
                    stack.push(pushed[pushIndex]);
                    pushIndex++;
                }
                //最后一次出来的时候和pop的值相等的值push进去
                pushIndex++;
                popIndex++;
                if(pushIndex >= pushed.length && popIndex != popped.length)return false;
            }
        }
        return true;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //一个栈
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for( int i = 0 ; i < pushed.length ; i++) {
            stack.push(pushed[i]);
            while (j < popped.length && !stack.isEmpty() &&stack.peek().equals(popped[j])) {
                stack.pop();
                j++;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
