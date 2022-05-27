package 力扣200题;

public class 寻找重复数 {
    //链表的值是下标，数组的值是 节点之间的指针
    public int findDuplicate(int[] nums) {
        int slow = 0 , fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)break;
        }
        //此时slow = fast
        int t1 = 0, t2 = slow;
        while (t1 != t2) {
            t1 = nums[t1];
            t2 = nums[t2];
        }
        return t1;
    }
}
