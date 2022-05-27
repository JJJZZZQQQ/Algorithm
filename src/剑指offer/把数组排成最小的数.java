package 剑指offer;

public class 把数组排成最小的数 {
    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
    public void quickSort(int [] nums, int left, int right) {
        if(left >= right)return;
        int partion = nums[left];
        int free = left;
        int i = left;
        int j = right;
        while (i < j) {
            while(i < j && equals(nums[j],partion)){j--;}
            nums[free] = nums[j];
            free = j;
            while(i < j && !equals(nums[i],partion)){i++;}
            nums[free] = nums[i];
            free = i;
        }
        nums[i] = partion;
        quickSort(nums, left, i - 1 );
        quickSort(nums, i + 1 ,right);
    }
    /** true 就是 a 大 ，false 就是b 大*/
    public boolean equals(int a,int b) {
        String sa = Integer.toString(a);
        String sb = Integer.toString(b);
        return (sa+sb).compareTo(sb + sa) >= 0;
    }
}
