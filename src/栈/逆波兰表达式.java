package 栈;

import java.util.Stack;

public class 逆波兰表达式 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            //如果当前位置的操作数为数字
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
            //运算符
            else {
                char c = tokens[i].charAt(0);
                int b = stack.pop();
                int a = stack.pop();
                if (c == '+') {
                    stack.push(a+b);
                } else if (c == '-') {
                    stack.push(a-b);
                } else if (c == '*') {
                    stack.push(a*b);
                } else {
                    stack.push(a/b);
                }
            }
        }
        return stack.pop();
    }
}
