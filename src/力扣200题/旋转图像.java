package 力扣200题;

import org.junit.Test;

public class 旋转图像 {
    @Test
    public void test() {
        rotate(new int[][] {{5,1,9,11} , {2,4,8,10} , {13,3,6,7} , {15,14,12,16}});
    }

    /** 使用了额外数组，不是原地旋转*/
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }
    /**
     * 用一个临时变量t存储当前位置，然后把当前位置的上一个数字放到当前位置，
     * 再找到上上一个位置放到上一个位置
     * 上上上放到上上
     * 上上上上放到上上上
     * 把t放到上上上上
     * 当前组别 旋转完成
     *
     * 为什么不往后放，要从前找??????????
     * t 存储 下一个位置 ,
     * 当前位置存储下一个位置，此时当前位置可以用，但是现在需要下一个位置可用，所以不行。
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                //公式 matrix  [col][n−row−1]=matrix[row][col]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];// n - j - 1  , i 可以放其他的数了
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
