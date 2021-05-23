package 热题100道;

import org.junit.Test;

public class 只出现一次的数字 {

    @Test
    public void test(){
        int [] nums = {2,2,3,3,5};
        System.out.println(singleNumber(nums));
    }
    /** 按位异或的3个特点：
     　　（1） 0^0=0，0^1=1 0异或任何数＝任何数
     　　（2） 1^0=1，1^1=0 1异或任何数－任何数取反
     　　（3） 任何数异或自己＝把自己置0
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
