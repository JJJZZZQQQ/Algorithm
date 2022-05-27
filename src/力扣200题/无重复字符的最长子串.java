package 力扣200题;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串 {

    @Test
    public void a() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character , Integer> exist = new HashMap<>();
        int left = 0 ;
        int max = 0;
       for(int right = 0 ; right < s.length() ; right++) {
            //如果子串中不存在
            if(!exist.containsKey(s.charAt(right))){
                max = Math.max(max , right - left + 1);
            } else {
                //清空旧的left到新的left之间的字符
                int newLeft = exist.get(s.charAt(right))  + 1;
                for(int i = left + 1 ; i < newLeft ; i++)
                    exist.remove(s.charAt(i));
                left = newLeft;
            }
           exist.put(s.charAt(right),right);
        }
        return max;
    }
}
