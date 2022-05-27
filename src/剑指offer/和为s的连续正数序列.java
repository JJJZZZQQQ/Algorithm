package 剑指offer;

import java.util.ArrayList;

public class 和为s的连续正数序列 {
    /**
     输入：target = 15
     输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     滑动窗口yyds*/
    public int[][] findContinuousSequence(int target) {
        ArrayList<int []> res = new ArrayList<>();
        int i = 1, j = 1 ,sum = 1;
        while (i <= target / 2) {
            if (sum == target) {
                int [] temp = new int[j - i + 1];
                for(int i1 = i ; i1 <= j ; i1++) {
                    temp[i1 - i] = i1;
                }
                res.add(temp);
                sum-=i;
                i++;
            } else if (sum > target) {
                sum-=i;
                i++;
            } else {
                j++;
                sum+=j;

            }
        }
        return res.toArray(new int[0][]);
    }
}
