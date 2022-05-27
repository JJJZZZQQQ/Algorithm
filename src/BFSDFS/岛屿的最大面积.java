package BFSDFS;

public class 岛屿的最大面积 {



    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int a = dfs(grid, i, j);
                    if(a > max)max = a;
                }
            }
        }
        return max;
    }

    //不能返回void ， 要返回int ， 因为要让两次搜索的结果和并在一起
    public int dfs(int[][] grid, int row, int col) {
        //边界
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) {
            return 0;
        }
        //可能是海或者是陆地已经被遍历
        if (grid[row][col] != 1) {
            return 0;
        }
        //设置为已遍历
        grid[row][col] = 2;

        return 1
                + dfs(grid, row + 1, col)
                + dfs(grid, row - 1, col)
                + dfs(grid, row, col + 1)
                + dfs(grid, row, col - 1);
    }

}
