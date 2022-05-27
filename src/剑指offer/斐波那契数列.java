package 剑指offer;

import org.junit.Test;

public class 斐波那契数列 {

    /** 迭代*/
    @Test
    public void fib() {
        int n = 10;
        long left = 0 ;
        long right = 1;
        long t = n ;
        for(int i = 2 ; i <= n ; i++){
            t = left + right;
            left = right % 1000000007;
            right = t % 1000000007;
        }
        System.out.println(t%1000000007);
    }
    /** 递归*/
    @Test
    public void digui() {
        System.out.println(fun(10));
    }
    public int fun(int n){
        if(n <= 1)return n;
        return (fun(n-2)+fun(n-1))%1000000007;
    }
}
