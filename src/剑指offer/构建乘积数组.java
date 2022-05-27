package 剑指offer;

import org.junit.Test;

public class 构建乘积数组 {

    @Test
    public void test () {
        constructArr(new int[]{1,2,3,4,5});
    }
    public int[] constructArr(int[] a) {
        int n = a.length;
        //算下半部分
        int [] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++) {
            res[i] = res[i - 1] * a[i - 1];
            //当前位置的乘积  =  上一个位置的乘积(没有乘上一个位置) * 上一个位置的值，此时当前位置的乘积 也没有乘 当前位置的值
        }
        //算上半部分
        int t = 1;
        for(int i = n - 2; i >= 0 ;i--) {
            t = t * a[i + 1];
            res[i] *= t;
        }
        return res;
    }
}
