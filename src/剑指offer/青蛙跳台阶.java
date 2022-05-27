package 剑指offer;

import org.junit.Test;

/**递推公式 f(n) = f(n-1) + f(n-2)
 * 类似的动规或者递归的题就是找递推公式*/
public class 青蛙跳台阶 {

    final static int MOD = 1000000007;
    /** 迭代*/
    @Test
    public void fib() {
        int n = 10;
        if(n <= 1) System.out.println(1);;
        int a = 1;
        int b = 1;
        int t = 1;
        for(int i = 2; i <= n ;i++){
            t = (a + b) % MOD;
            a = b;
            b = t;
        }
        System.out.println(t);;
    }
    /** 递归,n代表剩余台阶数*/
    @Test
    public void digui() {
        System.out.println(fun(7));
    }
    public int fun(int n){
        //和斐波拉契递归的不同
        if(n <= 1)return 1;
        return fun(n-2)+fun(n-1);
    }
}
