package codeTop;

public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length - 1 , k - 1);
        return nums[k - 1];
    }
    //倒序
    public void quickSort(int [] nums , int left , int right,int index) {
        //边界为一个元素
        if(left >= right)return;
        random_partition(nums,left,right);
        int zhuyuan = nums[left];
        int i = left,j = right;
        while (i < j) {
            while (i < j && nums[j] <= zhuyuan){
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] >= zhuyuan) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = zhuyuan;
        if(i > index) quickSort(nums,left,i - 1 , index);
        else if(i < index)quickSort(nums,i + 1,right, index);
    }
    public void random_partition(int[] nums, int left, int right)
    {
        int i = left + (int)(Math.random() * (right-left+1));
        int t = nums[left];
        nums[left] = nums[i];
        nums[i] = t;
    }


}
