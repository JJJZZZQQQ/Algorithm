package 剑指offer;

import org.junit.Test;

//矩阵的长和宽相等
public class 顺时针打印矩阵 {


    @Test
    public void spiralOrder() {
        int[][] matrix =  {{1,2,3},{4,5,6},{7,8,9}};

        boolean [][] used = new boolean[matrix.length+1][matrix[0].length+1];
        int i = 0 ;
        int j = -1 ;
        int index = 0;
        int flag = 0;
        int num = matrix.length * matrix[0].length ;
        int [ ] res = new int[num];
        while(num > 0){
            //右走 flag = 0
            if(flag == 0 ){
                //如果没到边界，就遍历
                if(j + 1< matrix[0].length && !used[i][j+1]) {
                    j++;
                    res[index++] = matrix[i][j];
                    used[i][j] = true;
                    num--;
                }
                else
                    flag = 2;
            }

            //左走 flag = 1
            else if(flag == 1) {
                if(j - 1 >= 0 && !used[i][j-1]){
                    j--;
                    res[index++] = matrix[i][j];
                    used[i][j] = true;
                    num--;
                }
                else
                    flag = 3;
            }
            //下走 flag = 2
            else if(flag == 2) {
                if(i + 1 < matrix.length && !used[i+1][j]) {
                    i++;
                    res[index++] = matrix[i][j];
                    used[i][j] = true;
                    num--;
                }
                else
                    flag = 1;
            }
            //上走 flag = 3
            else if(flag == 3) {
                if(i - 1 >= 0 && !used[i-1][j]) {
                    i--;
                    res[index++] = matrix[i][j];
                    used[i][j] = true;
                    num--;
                }
                else
                    flag = 0;
            }
        }
    }
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        //上下左右4个边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
}
