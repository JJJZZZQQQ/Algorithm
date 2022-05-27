package 拓展题;

import java.util.LinkedList;
import java.util.List;

public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> res = new LinkedList<>();
        int i = 0;
        while( i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        int [] t = newInterval;
        while( i < intervals.length && intervals[i][0] <= newInterval[1]){
            t[0] = Math.min(intervals[i][0],t[0]);
            t[1] = Math.max(t[1],intervals[i][1]);
            i++;
        }
        res.add(t);
        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int [0][0]);
    }
}
