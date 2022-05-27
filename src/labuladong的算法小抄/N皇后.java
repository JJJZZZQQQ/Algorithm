package labuladong的算法小抄;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N皇后 {

    @Test
    public void test() {
        List<List<String>> lists = solveNQueens(2);
        System.out.println(lists.size());
    }

    List<List<String>> res = new LinkedList<>();

    /**
     * 由于一行和一列只能放一个皇后，所以肯定每一行都有一个皇后
     * 所以搜索的决策树的层树对应着第几行，而每层树节点的值就是每行能在第几列放
     */
    public List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        String t = sb.toString();
        for (int i = 0; i < n; i++) {
            board.add(t);
        }
        backtrack(0, board);
        return res;
    }

    public void backtrack(int row, List<String> board) {
        //递归终止的条件
        //最后一行
        int n = board.size();
        if (row == n) {
            for (String s : board) {
                System.out.println(s);
            }
            res.add(new LinkedList<>(board));
        }
        //选择这一行所有的节点，依次往下递归
        for (int i = 0; i < n; i++) {
            //说明可以放
            if (isValid(row, i, board)) {
                //放入棋盘
                String s = board.get(row);
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0,i));
                sb.append("Q");
                sb.append(s.substring(i+1,s.length()));
                board.set(i,sb.toString());
                System.out.println("原来的棋盘为"+s);
                System.out.println("插入一个皇后后的棋盘为"+sb.toString());
                //进入下一层
                backtrack(row + 1,board);
                //回溯
                board.set(i,s);
            }
        }
    }

    /** 判断当前位置是否能放入，只需检查当前位置的横行，竖行，斜行为不为Q，如果为Q，返回false*/
    public boolean isValid(int row, int column, List<String> board) {
        //检查列中
        for(int i = 0 ; i < row ; i++) {
            if(board.get(i).charAt(column) == 'Q')return false;
        }
        //检查右上方
        for(int i = row - 1,j = column + 1 ; i >= 0 && j < board.size() ; i--,j++) {
            System.out.println(board.get(i).charAt(j) == 'Q');
            if(board.get(i).charAt(j) == 'Q')return false;
        }
        //检查左上方
        for(int i = row - 1,j = column - 1;i >= 0 && j >= 0 ;i--,j--){
            if(board.get(i).charAt(j) == 'Q')return false;
        }
        return true;
    }
}
