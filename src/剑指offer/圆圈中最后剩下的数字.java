package 剑指offer;

import org.junit.Test;

import java.util.ArrayList;


/** 约瑟夫环问题*/
public class 圆圈中最后剩下的数字 {

    @Test
    public  void  test() {
        System.out.println(lastRemaining(5, 1));
    }


    /** 可以直接用ArrayList偷懒实现 */
    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }


    /** 用数组实现循环链表*/
    public int lastRemaining(int n, int m) {
        int [] array = new int[n];
        //初始化
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        //剩余数字个数
        int res = n;
        //目前指针位置
        int now = 0;
        while(res > 1) {
            int t = m - 1;
            while(t > 0) {
                //now往下遍历
                now++;
                if(now >= n)now %= n;
                //now的下一个位置有值，没被删除，这时候才走了一步，否则不算走了一步
                if(array[now] != -1) {
                    t--;
                }
            }
            //表示删除
            array[now] = -1;
            res--;
            //删除后需要把当前指针往前走1，
            while(res > 1 && array[now] == -1){
                now++;
                now %= n;
            }
        }
        for (int i : array) {
            if(i != -1 )return i;
        }
        return -1;
    }
    /** 动态规划实现
     * 初始状态 ： n = 1 ，x  =0
     * dp公式  dp[n,m] = (dp[n-1,m] + m)  % n  */
    public int lastRemaining2(int n, int m) {
        //初始状态x,代表的是dp[n - 1, m]的值 , n = 1
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }


}
