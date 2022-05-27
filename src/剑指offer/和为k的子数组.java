package 剑指offer;

import java.util.HashMap;

public class 和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>preSum = new HashMap<>();
        preSum.put(0 , 1);
        int res = 0 , sum_j = 0;
        for (int num : nums) {
            sum_j += num;
            int sum_i = sum_j - k;
            if(preSum.containsKey(sum_i)) {
                res += preSum.get(sum_i);
            }
            preSum.put(sum_j,preSum.getOrDefault(sum_j,0) + 1);
        }
        return res;
    }
}
