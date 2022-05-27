package leetcode每日一题;

import org.junit.Test;

public class 汉明距离 {

    @Test
    public void test() {
        System.out.println(hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int sum = 0;
        while (z != 0) {
            sum++;
            z = z & (z - 1);
        }
        return sum;
    }
}
