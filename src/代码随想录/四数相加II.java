package 代码随想录;

import java.util.HashMap;
import java.util.Map;

public class 四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map12 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int key = nums1[i] + nums2[j];
                map12.put(key, map12.getOrDefault(key, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int key = -(nums3[i] + nums4[j]);
                res += map12.getOrDefault(key, 0);
            }
        }
        return res;
    }
}
