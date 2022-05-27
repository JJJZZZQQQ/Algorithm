package codeTop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class 有效的括号 {
    public boolean isValid(String s) {
        Deque <Character> stack  = new LinkedList<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '(')return false;
            }else if(c == '}'){
                if(stack.isEmpty() || stack.pop() != '{')return false;
            } else if(c == ']'){
                if(stack.isEmpty() || stack.pop() != '[')return false;
            }
        }
        return stack.isEmpty();
    }
}
