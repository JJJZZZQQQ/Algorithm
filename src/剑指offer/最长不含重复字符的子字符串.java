package 剑指offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的子字符串 {

    @Test
    public void test () {
        System.out.println(lengthOfLongestSubstring("abcabcbbca"));
    }
    public int lengthOfLongestSubstring(String s) {
        //左右两指针
        //一开始都为0
        //边界，右指针 == s.length - 1
        char[] arr = s.toCharArray();
        //左闭右闭
        int left = 0, right = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(right < arr.length) {
            //每次看一下arr[right]是否已经在子串里面了。
            //如果在,就从这里重新开始，并且清空HashMap
            if(map.containsKey(arr[right])) {
                //这一步是什么意思？为什么不需要清空HashMap了？
                //其实这是一种优化
                //当右窗口的字母已经出现过的时候
                //只会有两种情况
                // 一种是index < left 说明在左窗口前面出现的(因为没有清空HashMap)，这时就不需要管了，说明此时的子串里不包括该字母
                // 一种是index >= left 说明该字母在此时的子串中出现了，我们就要把左窗口移动到出现过的位置 + 1
                //归根结底，我们是在考虑所有的情况，然后让每一种情况都能满足 窗口的条件。
                left = Math.max(left,map.get(arr[right]) + 1);
            }
            //如果不在，sum++,并判断是否更新max，并加入hash表
            map.put(arr[right],right);
            max = Math.max(max ,right - left + 1);
            //移动右窗口
            right++;

        }
        return max;
    }

}
