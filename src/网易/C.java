package 网易;

import java.util.Scanner;

public class C {
    static int N = 101101;
    static int [] dep = new int[N];
    static int [] que = new int[N];
    static int n , m ,tot;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            if(i % 2 == 0)que[++tot] = i;
        }

        for (int i = 1; i <= n; i++) {
            if(i % 2 == 1)que[++tot] = i;
        }

        int nn = n;
        for(int i = 1;;i++) {
            if(nn > (1 << (i - 1))) {
                dep[i] = 1 << (i - 1);
                nn -= dep[i];
            } else {
                 m = i;
                 dep[i] = nn;
                 break;
            }
        }
        int odd = 0 ,even = 0;
        for (int i = 1; i <= m; i++) {
            if((i & 1) == 1)odd = odd + dep[i];
            else even = even + dep[i];
        }
        int head = 1 , tail = n;
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= dep[i] ;j++) {
                if(odd <= even == (i % 2 == 1)) {
                    System.out.print(que[head++]);
                } else {
                    System.out.print(que[tail--]);
                }
                if(i != m || j != dep[i])
                System.out.print(" ");
            }
        }
    }
}
