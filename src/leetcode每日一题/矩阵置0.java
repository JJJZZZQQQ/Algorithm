package leetcode每日一题;

import java.util.Arrays;

public class 矩阵置0 {
    /*空间复杂度常量级的算法
    * 为了不开辟多的空间，应该使用本来就有的空间进行处理，达到最小的空间消耗*/
    public static void main(String[] args) {
        int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
/*  空间复杂度O(m+n)
    public static void  main(String [] args){
            int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
            int n = matrix.length;
            int m = matrix[0].length;
            int [] row = new int [n];
            int [] list = new int [m];
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ;j < m ;j++){
                    if(matrix[i][j] == 0){
                        row[i] = 1;
                        list[j] = 1;
                    }
                }
            }
            for(int i = 0 ;i < n ;i++){
                if(row[i] == 1){
                    for(int j = 0 ;j < m;j++)matrix[i][j] = 0;//赋0
                }
            }
            for(int j = 0 ;j < m ;j++){
                if(list[j] == 1){
                    for(int i = 0 ;i < n ; i++ )matrix[i][j] = 0;
                }
            }
    }
*/
}

