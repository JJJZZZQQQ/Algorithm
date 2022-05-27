package 剑指offer;

import javax.security.auth.Subject;

public class II左旋转字符串 {

    /**
     输入: s = "abcdefg", k = 2
     输出: "cdefgab"
     */
    public String reverseLeftWords1(String s, int n) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < array.length; i++) {
            sb.append(array[i]);
        }
        for (int i = 0; i < n;i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
