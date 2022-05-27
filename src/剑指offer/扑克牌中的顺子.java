package 剑指offer;

import java.util.HashSet;

public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        //不用排序，遍历一遍
        // 找到0的个数，有没有重复的数，除0外最大最小的数
        int max = 0;
        int min = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 )continue;
            if(set.contains(nums[i]))return false;
            else {
                set.add(nums[i]);
                if(nums[i] > max)max = nums[i];
                if(nums[i] < min)min = nums[i];
            }

        }
        //0可以替补，所以中间的过程我们不需要考虑
        //我们只需要考虑最大值与最大值的差值有没有超过4即可，如果超过了4，说明再怎么替补都不可能是顺子
        return max - min < 5;
    }
}
