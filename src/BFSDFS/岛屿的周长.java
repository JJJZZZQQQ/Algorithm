package BFSDFS;

public class 岛屿的周长 {
    int sum = 0;
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //把所有陆地都走完
        end:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    dfs(grid , i , j);
                    break end;
                }
            }
        }
        return sum;
    }
    public void dfs(int [][] grid, int row, int column) {
        if (row == grid.length || column == grid[0].length || row < 0 || column < 0){
            sum++;
            return;
        }

        //可能已经走过了或者是海
        if (grid[row][column] == 0) {
            sum++;
            return;
        }
        if (grid[row][column] == 2) {
            return;
        }
        //标记为已遍历
        grid[row][column] = 2;
        //搜索
        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }
}
