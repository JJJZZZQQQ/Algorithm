package 排序算法;

public class 插入排序 {
    public static void main(String[] args) {
        int [] nums = {3,2,10,3,-1,3,0};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static  void sort(int [] nums){
        int n = nums.length;
        for(int i = 1 ; i < n ; i++){
            int j = i-1;
            while(j>=0&&nums[j]>nums[i]){
                j--;
            }
            int t = nums[i];
            for(int k = i; k > j + 1 ; k--){
                nums[k] = nums[k-1];
            }
            nums[j+1] = t;
        }

    }
}
