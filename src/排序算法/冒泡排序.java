package 排序算法;

public class 冒泡排序 {
    public static void main(String[] args) {
        int [] nums = {3,2,10,3,-1,3,0};
        //sort(nums);
        sort2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static  void sort(int [] nums){
        int n = nums.length;
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < n-i-1; j++ ){
                if(nums[j]>nums[j+1]){
                    int t = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = t;
                }
            }
        }

    }
    /**优化版*/
    public static  void sort2(int [] nums){
        int n = nums.length;
        for(int i = 0 ; i < n ; i++ ){
            boolean flag = false;
            for(int j = 0 ; j < n-i-1; j++ ){
                if(nums[j]>nums[j+1]){
                    int t = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = t;
                    flag = true;
                }
            }
            if(!flag)break;
        }

    }

}
