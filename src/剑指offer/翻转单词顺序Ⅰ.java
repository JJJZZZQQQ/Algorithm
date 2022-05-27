package 剑指offer;

import org.junit.Test;

import java.util.ArrayList;

public class 翻转单词顺序Ⅰ {
    @Test
    public void test(){
        reverseWords("the sky is blue");
    }

    /** 不能使用分隔字符串的形式，因为可能两个单词之间有多个空格*/
    public String reverseWords(String s) {
        //去除两侧的空格
        s = s.trim();
        int right = s.length() - 1;
        int left = s.length() - 1;
        char[] array = s.toCharArray();
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        while(left-- >= 0) {
            //如果是字母，有两种情况
            if(array[left] != ' ') {
                // 如果之前也是字母，继续左移
                //如果之前输出的是空格，说明到了下一个字母，把右指针也移到当前字母
                if(!flag) {
                    right = left;
                }
                flag = true;
            }
            //如果是空格，也有两种情况
            //第一种之前如果是空格直接拼接
            //如果之前是字母，则拼接当前left+1到right的单词
            else if(array[left] == ' ') {
                if(!flag) {
                    sb.append(' ');
                } else {
                    sb.append(s.substring(left + 1,right));
                    right = left;
                }
                flag = false;
            }
        }
        return sb.toString();
    }
}
