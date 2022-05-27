package 代码随想录;

import java.util.*;

public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet <Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if(set.contains(i)) {
                resSet.add(i);
            }
        }
        int [] array = new int[resSet.size()];
        int index = 0;
        for (Integer integer : resSet) {
            array[index++] = integer;
        }
        return array;
    }
}
