package 代码随想录;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 四数之和 {
    /**
     *
     * [-1,0,1,2,-1,-4]
     *  -4,-4,-1,-1,0,1,2,3,4
     * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //第一个数不要去重
            if(i > 0 && nums[i - 1] == nums[i])continue;;
            for (int j = i + 1; j < n; j++) {
                //第一个数不要去重
                if(j > i + 1 && nums[j - 1] == nums[j])continue;;
                int tar = target - (nums[i] + nums[j]);
                int left = j + 1 , right = n - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > tar) {
                        right--;
                    } else if (nums[left] + nums[right] < tar) {
                        left++;
                    } else {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j], nums[left], nums[right])));
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }
            }
        }
        return res;
    }
}
