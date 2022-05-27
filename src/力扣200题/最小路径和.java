package 力扣200题;

/** 根本就不需要回溯，那么就动态规划*/
public class 最小路径和 {

    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0&& j == 0)continue;
                if(i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if(j == 0){
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j] , grid[i][j - 1]);
                }
            }
        }
        return grid[n - 1][m - 1];
    }

    public void dfs(int[][] grid, int i, int j, int sum) {
        //边界
        int min = 0;
        if (i == grid.length) {
            if (j == grid[0].length - 1)
                min = Math.min(min, sum);
            return;
        }
        if (j == grid[0].length) {
            if (i == grid.length - 1)
                min = Math.min(min, sum);
            return;
        }
        if(sum > min)return;
        dfs(grid, i + 1, j, sum + grid[i][j]);

        dfs(grid, i, j + 1, sum + grid[i][j]);
    }
}
