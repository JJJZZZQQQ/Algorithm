package 代码随想录;

import org.junit.Test;

public class 螺旋矩阵Ⅱ {

    @Test
    public void test () {
        generateMatrix(3);
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int step = 1;
        while (step <= n * n) {
            //往右走，走完缩小上边界
            for (int i = left; i <= right && step <= n * n; i++) {
                res[up][i] = step++;
            }
            up++;
            //往下走，走完缩小右边界
            for (int i = up; i <= down && step <= n * n; i++) {
                res[i][right] = step++;
            }
            right--;
            //往左走，走完缩小下边界
            for (int i = right; i >= left && step <= n * n; i--) {
                res[down][i] = step++;
            }
            down++;
            //往上走，走完缩小左边界
            for(int i = down;i >= up && step <= n * n ; i--) {
                res[i][left] = step++;
            }
            left++;
        }
        return res;
    }
}
