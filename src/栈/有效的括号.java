package 栈;

import java.util.Stack;

public class 有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            //如果是左括号,直接push
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                stack.push(s.charAt(i));
            }
            //如果是右括号
            else {
                if(stack.isEmpty())
                    return false;
                char c = stack.pop();
                if(s.charAt(i) == ')'){
                    if(c != '(') {
                        return false;
                    }
                } else if(s.charAt(i) == '}') {
                    if(c != '{') {
                        return false;
                    }
                } else {
                    if(c != '[') {
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
