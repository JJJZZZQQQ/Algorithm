package labuladong的算法小抄;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class 找到字符串中所有字母异位词 {

    @Test
    public void test () {
        for (Integer anagram : findAnagrams("cbaebabacd", "abc")) {
            System.out.println(anagram);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        int [] need = new int[128];
        int needCount = p.length();
        int left = 0 , right = 0;
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i)]++;
        }
        while(right < s.length()) {
            char c = s.charAt(right);
            if(need[c] > 0) {
                needCount--;
            }
            need[c]--;
            if(needCount == 0) {
                while(left < right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)]++;
                    left++;
                }
                //记录当前位置
                if(right - left + 1 == p.length())
                    res.add(left);
                //进入下一次可能的窗口
                need[s.charAt(left)]++;
                needCount++;
                left++;
            }
            right++;
        }
        return res;
    }
}
