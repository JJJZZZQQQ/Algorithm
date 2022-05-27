package 剑指offer;


public class 数组中超过一半的数字 {
    public int majorityElement(int[] nums) {
        int mode = 0, survival = 0;
        for (int i = 0; i < nums.length; i++) {
            //此时说明之前的数全部都抵消了，我们应该设置一个新的众数
            if(survival == 0)mode = nums[i];
            survival += (nums[i] == mode ? 1 : -1);
        }
        return mode;
    }
}
