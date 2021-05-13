package leetcode每日一题;

public class 整数反转 {
    public static void main(String[] args) {
        int x =-1534236469;
        System.out.println(reverse(x));
    }
    public  static int reverse(int x) {
        int p = weishu(x);
        int sum = 0;
        boolean flag = x>0 ? true :false;
        x = Math.abs(x);
        while(x>0){
            int t = x%10;
            sum += t*Math.pow(10,p-1);
            p--;
            x/=10;
        }
        if(sum==Integer.MAX_VALUE)return  0;
        if(flag) return sum;
        else return -sum;
    }
    public static int weishu(int x){
        int num = 0;
        if (x==0)return 1;
        else if(x>0){
            while(x>0){
                num++;
                x/=10;
            }
        }
        else {
            x = -x;
            while(x>0){
                num++;
                x/=10;
            }
        }
        return num;
    }
}
