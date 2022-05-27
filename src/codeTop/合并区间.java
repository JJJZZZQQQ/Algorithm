package codeTop;

import java.util.*;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        //先排序，按左边排序，左边相同再用右边排序
        //然后遍历，合并重复的区间
        //[1,3]  [1,4]
        //取最后一个 左边为 1 的区间
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        Deque<int[]> stack = new LinkedList<>();
        stack.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] peek = stack.getLast();
            //如果当前元素的左边界 大于 栈顶元素的右边界，则直接add即可
            if(peek[1] < intervals[i][0]) {
                stack.addLast(intervals[i]);
            }
            //如果当前元素 左边界 大于等于栈顶元素的左边界(必满足)，小于等于栈顶元素的右边界，就把两个区间合并
            else if(intervals[i][0] <= peek[1]) {
                stack.removeLast();
                stack.addLast(new int[]{peek[0],Math.max(intervals[i][1],peek[1])});
            }
        }
        int [][] res = new int[stack.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.getFirst();
            stack.removeFirst();
        }
        return res;
    }
}
