package 剑指offer;

import java.io.PipedWriter;

public class 数值的整数次方 {
    public double myPow(double x, int n) {
        long n1 = n;
        if(n == 0) {
            return 1.0;
        }
        //n为正数
        else if(n > 0) {
            return quickPow(x,n1);
        }
        //n为负数
        else {
            return 1/quickPow(x,-n1);
        }
    }
    /** 迭代快速幂算法*/
    public double quickPow(double base , long power) {
        double res = 1;
        while (power > 0) {
            //如果指数是奇数,就把指数变成偶数
            if(power % 2 == 1) {
                power -= 1;
                res *= base;
            }
            power /= 2;
            base *= base;
        }
        return res;
    }
    /**递归快速幂*/
    public double quickPow2(double base, long power) {
        //递归出来的条件
        if(power == 0)return 1;
        if(power == 1)return base;
        if(power == -1)return 1 / base;
        double half =  quickPow2(base, power/2);
        double mod = quickPow2(base,power % 2) ;
        return half * half * mod;
    }
}
