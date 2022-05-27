package 力扣200题;

import java.util.HashMap;

public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        //hashmap记录和为 key 的连续子数组的个数
        HashMap<Integer, Integer> map = new HashMap<>();
        //不选也是一种情况
        map.put(0, 1);
        int res = 0;
        //代表 0 到  j 的数组之和
        int sum_j = 0;
        for (int num : nums) {
            //前 j 个数字的和
            sum_j += num;
            // k = sum[j] - sum[i] , 从 i 到  j 的子数组 之和 等于 k 的条件,  j 是固定的 ，主要是通过hashmap找 i
            int sum_i = sum_j - k;
            //看之前有没有出现过 sum_i
            if (map.containsKey(sum_i)) {
                res += map.get(sum_i);
            }
            // i 和 j肯定是 一前一后，这样还能判重
            map.put(sum_j, map.getOrDefault(sum_j, 0) + 1);
        }
        return res;
    }
}
