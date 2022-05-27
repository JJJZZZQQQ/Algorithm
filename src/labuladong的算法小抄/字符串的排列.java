package labuladong的算法小抄;

import org.junit.Test;

public class 字符串的排列 {

    @Test
    public void test() {
        System.out.println(checkInclusion("abc", "bbbca"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int [] need = new int[128];
        for( int i = 0; i < s1.length() ; i++) {
            need[s1.charAt(i)]++;
        }
        int left = 0,right = 0 ,needCount = s1.length();
        while(right < s2.length()) {
            char c = s2.charAt(right);
            if(need[c] > 0) {
                needCount--;
            }
            need[c]--;
            if(needCount == 0) {
                while(left < right && need[s2.charAt(left)] < 0) {
                    need[s2.charAt(left)]++;
                    left++;
                }
                if(right - left + 1 == s1.length())
                    return true;
            }
            right++;
        }
        return false;
    }
}
