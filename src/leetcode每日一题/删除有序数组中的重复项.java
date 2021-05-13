package leetcode每日一题;

public class 删除有序数组中的重复项 {
    public static void main(String args[]){
        //只需维护i之前以及i所包含的数组满足都不重复的要求即可
        //快慢指针，慢指针用来维护数组，快指针用来遍历原数组，并把符合要求的数添加到慢指针维护的数组里
        int [] nums = {0,0,1,1,1,2,2,2,3,3,4,5};
        int i = 0;
        for(int j = 1 ; j <nums.length; j++){
            if(nums[i]!=nums[j]){
                if( j-i > 1)nums[i+1] = nums[j];
                i++;
            }
        }
        System.out.println(i+1);
    }
}
