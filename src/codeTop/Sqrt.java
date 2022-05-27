package codeTop;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        //在所有数，找到第一个  平方之后 大于x的数
        int left = 1, right = x / 2 + 1;
        //左闭右开
        if(x == 1)return 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid > x / mid) {
                right = mid;
            } else if (mid < x / mid){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }
}
