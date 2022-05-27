package codeTop;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        //用来取代HashMap，这样更快
        int [] exist = new int[150];
        Arrays.fill(exist, -1);
        int left = 0 , right = 0;
        int max = 0;
        char[] array = s.toCharArray();
        while (right < array.length) {
            //exist的下标
            int index = array[right];
            //缩小左窗口
            if(exist[index] != -1) {
                //c在窗口里的话，那么他的下标肯定比left 大于等于
                if(exist[index] >= left)left = exist[index] + 1;
            }
            exist[index] = right;
            max = Math.max(max,right - left + 1);
            right++;
        }

        return max;
    }
}
