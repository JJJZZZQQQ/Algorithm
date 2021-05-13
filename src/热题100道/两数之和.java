package 热题100道;

import java.util.HashMap;

public class 两数之和 {
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        for (int i : twoHashSum(nums, 9)) {
            System.out.println(i);
        }
    }
    /** 暴力枚举进行组合*/
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0 ; i < n;i++){
            for(int j = i+1 ; j < n ;j++){
                if(nums[i]+nums[j]==target)return new int[]{i,j};
            }
        }
        return null;
    }
    /**方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高
     * 因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素
     * 这种方法就是使用哈希表*/
    public static int [] twoHashSum(int[] nums, int target){
        HashMap<Integer,Integer>map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])
            )return new int[]{i,map.get(target-nums[i])};
        }
        return null;
    }
}
