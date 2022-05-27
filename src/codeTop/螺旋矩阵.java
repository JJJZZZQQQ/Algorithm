package codeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        //维护上下左右边界，每次上下左右遍历完一轮，就缩小边界，直到上边界 > 下边界 或者是 左边界 > 右边界
        List<Integer> res = new LinkedList<>();
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[up][i]);
            if (++up > down) break;
            for (int i = up; i <= down; i++) res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) res.add(matrix[down][i]);
            if (--down < up) break;
            for (int i = down; i >= up; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}
