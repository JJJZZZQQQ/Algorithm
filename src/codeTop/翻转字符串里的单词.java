package codeTop;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 翻转字符串里的单词 {
    public String reverseWords(String s) {
        String trim = s.trim();
        StringBuilder res = new StringBuilder();
        int length = trim.length();
        //左指针代表开始取值的开始，right代表取值的末尾
        int left = length - 1, right = length - 1;
        //代表是否出现过字母
        boolean flag = false;
        for (int i = length - 1; i >= 0; i--) {
            if (trim.charAt(i) == ' ') {
                if(!flag){
                    right = i - 1;
                    continue;
                }
                res.append(trim.substring(left, right + 1));
                res.append(" ");
                right = i - 1;
                flag = false;
            } else {
                left = i;
                flag = true;
            }
        }
        res.append(trim.substring(left,right + 1));
        return res.toString();
    }
    public String reverseWordsAPI(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
