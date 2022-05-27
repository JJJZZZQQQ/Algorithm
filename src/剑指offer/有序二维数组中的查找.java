package 剑指offer;


public class 有序二维数组中的查找 {

    /** 由于该数组的特性,我们应该利用它有序的特点直接排除掉很多元素,
     * 如果我们从左上角开始排查,它的右边和下面都是大于它的数,无法排除掉任何数,任何数都有可能
     * 理论上最好是一边是大于,一边是小于,这样每次都可以排除掉一行或者一列的数
     * 经观察,如果从右上角开始排查符合这个特点*/
    public static void main(String[] args) {
        int[][] matrix = new int[100][100];
        int target = 1;
        int n = matrix.length;
        if (n == 0) return;
        int m = matrix[0].length;
        int i = 0, j = m - 1;
        while (j >= 0 && i < n) {
            if (target == matrix[i][j]) {
                return;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return;
    }
}
