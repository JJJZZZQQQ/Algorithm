package 力扣200题;

import org.junit.Test;

import java.util.*;

public class 合并区间 {
    @Test
    public void test() {
        int[][] nums = {{1, 3}, {2, 6},{8,10},{15,18}};
        merge2(nums);
    }

    /**
     * 错了，区间不止整数，[1,2] [3,4] 这样的区间不能合并，因为2 到 3 之间没有
     */
    public int[][] merge1(int[][] intervals) {
        boolean[] flag = new boolean[10005];
        int n = intervals.length;
        int[][] res = new int[n][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                flag[j] = true;
                if (j > max) max = j;
            }
        }
        int row = 0;
        int line = 0;
        for (int i = 0; i <= max; i++) {
            if (flag[i] && line == 0) {
                res[row][line] = i;
                line = 1;
            } else if (flag[i] && line == 1 && !flag[i + 1]) {
                res[row][line] = i;
                line = 0;
                row++;
            }
        }
        int size = 0;
        for (int[] re : res) {
            if (re[1] != 0) size++;
        }
        int[][] res1 = new int[size][2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                res1[i][j] = res[i][j];
            }
        }
        return res1;
    }

    /**
     * 不排序
     */
    public int[][] merge2(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
//        不排序，直接遍历列表
        for (int[] i : intervals) {
            //因为没有排过序，所以需要把每一个已经放进 res 的区间都跟i区间比较
            for (int j = 0; j < res.size(); j++) {
                int[] re = res.get(j);
                if (i[0] >= re[0] && i[0] <= re[1]  || re[0]>= i[0] && re[0]<=i[1]) { //可合并
                    int left = Math.min(i[0], re[0]);
                    int right = Math.max(i[1], re[1]);
                    i[0] = left;
                    i[1] = right;
                }else {
                    continue;
                }
                res.remove(re);
                j--;
            }
            res.add(i);
        }
        return res.toArray(new int[0][]);
    }
    /** 先排序，再用左右边界进行判断*/
    public int[][] merge3(int[][] intervals) {
        if(intervals.length == 0 )return new int [0][2];
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List <int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for(int i = 1 ; i < intervals.length ; i++){
            int[] t = list.get(list.size()-1);
            if(t[1] < intervals[i][0])list.add(intervals[i]);
            else{// [1,4]   [2,3]  [2,6]
                list.remove(list.size()-1);
                int [] res = new int [2];
                res[0] = t[0];
                res[1] = Math.max(t[1] , intervals[i][1]);
                list.add(res);
            }
        }
        return  list.toArray(new int [0][0]);
    }
}
