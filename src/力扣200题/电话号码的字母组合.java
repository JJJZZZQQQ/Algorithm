package 力扣200题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 电话号码的字母组合 {
    static HashMap<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0)return res;
        dfs(digits, 0, n, new StringBuilder());
        return res;
    }

    public void dfs(String digits, int step, int n, StringBuilder now) {
        if (step == n) {
            res.add(new String(now));
            return;
        }
        char c = digits.charAt(step);
        String s = map.get(c);
        char[] array = s.toCharArray();
        for (char c1 : array) {
            now.append(c1);
            dfs(digits, step + 1 , n , now);
            now.deleteCharAt(step);
        }
    }
}
