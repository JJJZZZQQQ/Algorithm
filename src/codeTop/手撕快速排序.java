package codeTop;

public class 手撕快速排序 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0,nums.length - 1);
        return nums;
    }
    public void quickSort(int[] nums , int left , int right) {
        //边界
        if(left >= right)return;
        int i = left,j =  right;
        random(nums,left,right);
        int p = left;
        int zhuyuan = nums[p];
        while (i < j) {
            while (i < j && nums[j] >= zhuyuan) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= zhuyuan) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = zhuyuan;
        //下一次递归
        quickSort(nums,left,i - 1);
        quickSort(nums,i + 1 ,right);
    }
    public void random(int [] nums , int left , int right) {
        int i = left + (int) (Math.random() * (right - left + 1));
        int t = nums[i];
        nums[i] = nums[left];
        nums[left] = t;
    }
}
