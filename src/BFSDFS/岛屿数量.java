package BFSDFS;

public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        //把所有陆地都走完
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid , i , j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char [][] grid, int row, int column) {
        //边界
        if (row == grid.length || column == grid[0].length || row < 0 || column < 0)
            return;
        //可能已经走过了或者是海
        if (grid[row][column] != '1') {
            return;
        }
        //标记为已遍历
        grid[row][column] = '2';
        //搜索

        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }
}
