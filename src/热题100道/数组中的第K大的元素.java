package 热题100道;

import org.junit.Test;
import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 数组中的第K大的元素 {
    @Test
    public void test(){
        int [] nums = {47,4,2,6,3,5,2,6};
        Arrays.sort(nums);
        System.out.println(findKthLargest(nums,2));
        System.out.println(queueFind2(nums,2));
    }
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1,k);
        return nums[nums.length-k];
    }
    public void quickSort(int [] nums ,int left ,int right,int k){
        if(left>=right)return;
        random_partition(nums ,left ,right);
        int zhuyuan = nums[left];
        int i = left;
        int j = right;
        while(i<j) {
            while (i < j && nums[j] >= zhuyuan) {
                j--;
            }
            nums[i] = nums[j];
            while(i < j && nums[i] <= zhuyuan){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = zhuyuan;
        //需要的位置在主元左边，左递归
        if(i > nums.length-k) quickSort(nums , left , i-1,k);
        //需要的位置在主元右边，右递归
        else if(i < nums.length-k)quickSort(nums , i+1 ,right,k);
    }
    //随机选取主元
    public void random_partition(int[] nums, int left, int right)
    {
        int i = left + (int)(Math.random() * (right-left+1));
        int t = nums[left];
        nums[left] = nums[i];
        nums[i] = t;
    }
    /** 维护一个长度为len的最大堆，然后再pop出k-1个数*/
    public int queueFind1(int [] nums ,int k ){
        //最大堆，默认建立的是一个最小堆，用lambda表达式建立最大堆
        PriorityQueue <Integer> maxheap = new PriorityQueue<>(nums.length,(a,b)->b-a);
        for (int num : nums) {
            maxheap.add(num);
        }
        for(int i = 0 ; i < k-1 ; i++){
            maxheap.poll();
        }
        return maxheap.peek();
    }
    /** 优化空间。只维护一个长度为k的最小堆，堆里存的是前k个最大的数,堆顶就是第k大的数*/
    public int queueFind2(int [] nums ,int k ){
        PriorityQueue <Integer> maxheap = new PriorityQueue<>(k);
        for (int num : nums) {
            if(maxheap.size()<k){
                maxheap.add(num);
            }
            else{
                if(maxheap.peek()<num){
                    maxheap.poll();
                    maxheap.add(num);
                }
            }
        }
        return maxheap.peek();
    }
}
