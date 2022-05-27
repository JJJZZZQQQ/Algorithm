package labuladong的算法小抄;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class 最小覆盖子串 {

    @Test
    public void test() {
        System.out.println(minWindow("a", "aa"));
    }
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }
        int [] need = new int[128];

        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int left = 0, right = 0;
        int start = 0;
        int size = Integer.MAX_VALUE;
        int needCount = t.length();
        //该窗口左闭右开
        while (right < s.length()) {
            //将此时的右边界加入窗口
            char c = s.charAt(right);
            //说明需要该字符
            if(need[c] > 0) {
                needCount--;
            }
            need[c]--;
            //如果需要的needCount，尝试缩小左窗口,注意边界
            if (needCount == 0) {
                //循环退出时的条件是：左边边界到了第一个 need值等于0或者大于0的 ，就说明此时的这个左边界是刚刚好的
                while (left < right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)]++;
                    left++;
                }
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

}
