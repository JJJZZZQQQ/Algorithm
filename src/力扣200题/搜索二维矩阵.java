package 力扣200题;

public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //先找在第几行，找第一个大于等于target的行数
        //再在行里找在第几列
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = n - 1;
        //左闭右开
        while (i <= j) {
            int mid = (i + j) / 2;
            if(matrix[mid][m - 1] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        //在第i行找
        if(i >= n)return false;
        int left = 0 , right = m - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(matrix[i][mid] > target) {
                right = mid - 1;
            } else if(matrix[i][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;

    }
}
