package leetcode每日一题;

public class 位一的个数 {
    public static void main(String[] args) {
        //方法总结，对于二进制有关的题目，应优先考虑位运算

        /*//法1，直接判断二进制最低位的数是不是1
        int n = -3;
        int sum =0 ;
        for(int i = 0 ; i < 32 ;i++){
            sum += n&1;
            n>>=1;
        }
        System.out.println(sum);*/
        //法2，用 n&(n-1) 结果为去掉最后一位的1,直接去掉二进制中位置最靠后的1
        int n = -3;
        int sum =0 ;
        while (n!=0){
            n&=(n-1);
            sum++;
        }
        System.out.println(sum);

    }
}
