package 剑指offer;

import org.junit.Test;

public class 数字序列中某一位的数字 {

    /**
     1.确定 n 所在 数字 的 位数 ，记为 digit；
     2.确定 n 所在的 数字 ，记为 num ；
     3.确定 n 是 num 中的哪一数位，并返回结果。
     */
    @Test
    public void test(){
        findNthDigit(10000);
    }
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            System.out.println(count);
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
    public int findNthDigit2(int n) {
        //1.确定 n 所在 数字 的 位数 ，记为 shuwei
        //2.确定 n 所在的 数字 ，记为 num ；
        //3.确定 n 是 num 中的哪一数位，并返回结果。
        int shuwei = 1;
        long count = 9;
        long start = 1;
        while (n > count) {
            //说明到了下一个区间
            System.out.println(count);
            //n -= count;
            shuwei ++;
            start *= 10;
            //count不能这么算，count是这个区间要减的数,因为中间还有数位
            //count = count * 10 + 9;
            count = shuwei * start * 9;
        }
        //循环出来的n应该是在这个区间的第n个数
        Long num = start + (n - 1) / shuwei;
        return Long.toString(num).charAt((n -1) % shuwei) - '0';
    }

}
