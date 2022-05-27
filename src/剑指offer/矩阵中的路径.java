package 剑指offer;

import java.util.HashSet;

public class 矩阵中的路径 {

    private boolean flag = false;

    private boolean [][] used ;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        used = new boolean[n][m];
        //表示当前程序正在找哪一个位置的字母
        int index = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(word.length() == 1)return true;
                    used[i][j] = true;
                    dfs( board , word , i , j , 1 );
                    used[i][j] = false;
                }
            }
        }
        return flag;
    }
    // i j : 代表当前正确字母的位置,从这个位置找周围一圈的位置
    // 废弃 因为不止前一个不能用,只要是用过的都不能用 pri pij : 代表前一个正确字母的位置,用来保证不被重复使用
    //用一个used数组判断是否使用了
    //index : 代表当前在找第几个字母
    public void dfs(char[][] board ,String word ,int i, int j , int index){
        //遍历周围四个单元格(去除边界和上一次的位置)
        //如果相等,就DFS(..,.., i , j , index+1)
        //边界条件,index == word.length() - 1,当到达边界条件并且确认找到了,就设置flag为true


        //if(i >= board.length || i < 0 || j >= board[0].length || j < 0 ) return ;
        if(index == word.length()){
            flag = true;
            return;
        }
        //上格

        if(i - 1 >= 0 && board[i-1][j] == word.charAt(index) && !used[i-1][j]  ){
            //标记这个位置已使用
            used[i-1][j] = true;
            dfs(board , word ,i-1, j , index + 1 );
            //回收空间,有可能这次不成立
            used[i-1][j] = false;
        }
        //下格
        if(i + 1 < board.length &&  board[i+1][j] == word.charAt(index) && !used[i+1][j] ){
            used[i+1][j] = true;
            dfs(board , word ,i+1, j , index + 1 );
            used[i+1][j] = false;
        }
        //左格
        if(j - 1 >= 0 && board[i][j-1] == word.charAt(index) && !used[i][j - 1] ){
            used[i][j - 1] = true;
            dfs(board , word ,i, j - 1 , index + 1 );
            used[i][j - 1] = false;

        }
        //右格
        if(j + 1 < board[0].length && board[i][j + 1] == word.charAt(index) && !used[i][j + 1] ){
            used[i][j + 1] = true;
            dfs(board , word ,i, j + 1 , index + 1 );
            used[i][j + 1] = false;
        }
    }
}
