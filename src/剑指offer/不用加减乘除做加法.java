package 剑指offer;

import org.junit.Test;

import java.util.Arrays;

public class 不用加减乘除做加法 {

    @Test
    public void test() {
        System.out.println(add(321, 2));
    }

    public int add(int a, int b) {
        //把b加到a上，把b直接看成进位准备相加
        while (b != 0) {
            int c = (a & b) << 1;//所有二进制位上的进位
            a ^= b;//直接让a和b不考虑进位相加
            b = c;//再让b等于进位，进入下一个循环让a和b相加
        }
        return a;
    }

}
