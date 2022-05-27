package 力扣200题;

import java.util.LinkedList;
import java.util.List;

public class 找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //由于都在 1 到 n 之间
        //所以每个 数组元素都能在 0 到 n - 1 中找到对应的 下标
        //如果给任意一个数 加上 1，那么肯定会大于 n
        //我们给这些值对应的下标 加上 n，那么只要出现过的值，对应下标的元素肯定大于n
        int n = nums.length;
        for (int num : nums) {
            //由于修改了之后的值，所以这里的下标要对 n 取模
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> res  = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= n) {
                res.add(i + 1);
            }
            nums[i] %= n;
        }
        return res;
    }
}
