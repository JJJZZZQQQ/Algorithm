package 力扣200题;

public class 搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col = 0, row = n - 1;
        while (col < m && row >= 0) {
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] > target){
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
