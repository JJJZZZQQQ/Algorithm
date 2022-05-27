package 实习生考核;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0, x = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            x = scanner.nextInt();
        }
        System.out.println(fun(n,x));

    }
    public static int fun(int n, int x) {
        if(n == 0)return 1;
        else if(n == 1)return 2 * x;
        else {
            return (2 * x * fun(n - 1, x)) - (2 * (n - 1) * fun( n - 2, x));
        }
    }
}
