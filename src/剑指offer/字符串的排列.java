package 剑指offer;

import org.junit.Test;

import java.util.*;

/**
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class 字符串的排列 {

    /**
     * 递归：
     * 递归结束的条件：为字符串的最后一个字符，并且把当前的字符串添加到结果里面
     * 递归的过程：
     * 如何去重：直接不用LinkedList，直接用HashSet就行了
     * 更快的剪纸去重：在每一个位置添加字符的时候判断这个字符有没有使用过
     */
    private HashSet<String> list = new HashSet<>();

    private String source;

    private boolean[] flag;

    public String[] permutation(String s) {
        source = s;
        flag = new boolean[s.length()];
        fun("");
        return list.toArray(new String[0]);
    }

    public void fun(String s) {
        if (s.length() == source.length()) {
            list.add(s);
            return;
        }
        Map<Character, Integer> charFlag = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            if (flag[i]) {
                continue;
            }
            if (charFlag.size() != 0 && charFlag.get(source.charAt(i)) != null) {
                continue;
            }
            flag[i] = true;
            fun(s + source.charAt(i) + "");
            flag[i] = false;
            charFlag.put(source.charAt(i), 1);
        }
    }


    public String[] permutation2(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        boolean[] visited = new boolean[s.length()];
        List<String> res = new ArrayList<>();
        dep(stack, top, s, visited, res);
        return res.toArray(new String[0]);
    }

    void dep(char[] stack, int top, String s, boolean[] visited, List<String> res) {
        if (top == s.length() - 1) {
            res.add(new String(stack));
            return;
        }
        Map<Character, Integer> hisMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) {
                continue;
            }
            if (hisMap.size() != 0 && hisMap.get(s.charAt(i)) != null) {
                continue;
            }
            visited[i] = true;
            stack[++top] = s.charAt(i);
            dep(stack, top, s, visited, res);
            visited[i] = false;
            hisMap.put(stack[top--], 1);
        }
    }

    @Test
    public void test() {
        String[] abcs = permutation("abc");
        for (String abc : abcs) {
            System.out.println(abc);
        }
    }
}
