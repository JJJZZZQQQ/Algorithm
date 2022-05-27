package 力扣200题;

public class 比特位计数 {
    public int[] countBits(int n) {
        int [] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //奇数最后一位肯定是1，那么这个奇数的前一个偶数 肯定末尾 为0，所以直接前一个偶数的1的个数 +1即可
            if((i & 1) == 1) {
                res[i] = res[i - 1] + 1;
            } else {
                //如果是偶数，那么最后一位肯定为0
                res[i] = res[i >> 1];
            }
        }
        return res;
    }
    //位 1 的个数
    public int count(int x) {
        int sum = 0;
        while (x != 0){
            sum++;
            x = x & (x - 1);
        }
        return sum;
    }
}
