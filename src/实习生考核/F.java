package 实习生考核;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        double x = 0, n = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            x = scanner.nextDouble();
        }
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        while (n-- > 0){
            x = x * 1.001;
        }
        System.out.printf("%.4f",x);
    }
}
