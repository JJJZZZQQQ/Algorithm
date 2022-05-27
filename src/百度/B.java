package 百度;


import sun.misc.GC;

import java.util.Scanner;
public class  B {

    /**
     * N的所有最小公约数的对子，GCD(A,B) = 1
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T-- > 0) {
            int N = in.nextInt();
            int sum = 0;
            //求出所有的 A,B
            for (int i = 1; i * i <= N; i++) {
                if(N % i == 0) {
                    if(GCD(i,N / i) == 1) {
                        sum++;
                    }
                }

            }
            System.out.println(sum);
        }

    }

    public static int GCD(int a,int b) {
        /*if(b == 0) {
            return a;
        } else {
            return GCD(b,a % b);
        }*/
        //保证 a > b
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }

        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

}