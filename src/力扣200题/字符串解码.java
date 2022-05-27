package 力扣200题;

import java.util.Deque;
import java.util.LinkedList;

public class 字符串解码 {
    //模拟不了哈
    //3[a2[c]]
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        //当前字符串倍数
        int multi = 0;
        //首先，每一个[]对应的操作都有两个变量，所以应该有两个栈
        //存放当前[]的倍数
        Deque<Integer> stack_multi = new LinkedList<>();
        //存放当前[] 准备重复的字符串
        Deque<String> stack_res = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                //把当前倍数放进去之后
                stack_multi.push(multi);
                //开启一段新的旅程前把 这一次旅程的 重复字符串放进去，等下次旅程结束了再取出来用
                stack_res.push(res.toString());
                multi = 0;
                //当前[]里的重复字符串
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp);
            } else if (c >= '0' && c <='9'){
                multi = multi * 10 + (c - '0');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
    public String decodeStringMe(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Deque <Integer> stack_multi = new LinkedList<>();
        Deque <String> stack_res = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if(c == '[') {
                stack_res.push(res.toString());
                stack_multi.push(multi);
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                Integer cur_multi = stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp);
            } else if(c >= '0' && c <= '9') {
                multi = multi * 10 + (c - '0');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
