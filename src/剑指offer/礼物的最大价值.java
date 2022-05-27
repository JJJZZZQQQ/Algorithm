package 剑指offer;

public class 礼物的最大价值 {


    /** 递推公式 ：f(n,m) = max (f(n - 1 , m) , f(n , m - 1))*/
    public int maxValue(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        //初始化
        int [][]dp = new int[n + 1][m + 1];
        dp[1][1] = grid[0][0];
        for(int i = 1 ; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i-1][j-1];
                if(dp[i][j] > max)max = dp[i][j];
            }
        }
        return max;
    }
    /**
     * 递推公式 ：f(n,m) = max (f(n - 1 , m) , f(n , m - 1))
     * 可以优化空间
     * 因为递推公式的f(n)只跟左边的和上面的有关，grid数组是往右和往下遍历，完全可以利用左边和上边的空间当成dp数组
     * 类似于背包问题优化空间的方法
     * 优化空间后要注意边界情况
     * i = 0,j = 0
     * i = 0,j != 0
     * i != 0,j = 0
     * */
    public int maxValue2(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        //初始化
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0)continue;
                if(i != 0 && j != 0){
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }
            }
        }

        return grid[n - 1][m - 1];
    }

}
