package 剑指offer;

import org.junit.Test;

public class 把数字翻译成字符串 {

    @Test
    public void test() {
        System.out.println(translateNum(12));
    }
    /** 考虑可能是一个有递推公式的题
     * 递推公式，f(n) = f(n去掉第一位) + f(n去掉前两位)(如果前两位 <= 25 )
     *         f(n) = f(n-1) (else)
     * 递推边界：
     * f(0) = 0
     * f(1) = 1
     * */
    public int translateNum(int num) {
        int s = 0;
        int a = 1;//dp[n-2]
        int b = 1;//dp[n-1]
        String src = Integer.toString(num);
        int length = src.length();
        if(length == 1)return 1;
        for (int i = 1; i < length; i++) {
            String pre = src.substring(i - 1, i + 1);
            if(pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0){
                s = a + b ;
            } else {
                s = b;
            }
            a = b;
            b = s;
        }
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }

}
