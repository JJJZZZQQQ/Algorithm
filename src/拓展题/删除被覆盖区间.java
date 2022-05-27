package 拓展题;

import java.util.Arrays;

public class 删除被覆盖区间 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        int [] t = intervals[0];
        int sum = intervals.length;
        for(int i = 1 ; i < intervals.length ; i++ ){
            if(intervals[i][1] <= t[1] ){
                sum--;
                continue;
            }
            else if( intervals[i][0] == t[0] && intervals[i][1] > t[1]){
                t = intervals[i];
                sum--;
                continue;
            }
            else t = intervals[i];
        }
        return sum;
    }
}
