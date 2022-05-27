package 实习生考核;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double xa = 0, ya = 0, xb = 0, yb = 0;
        if (scanner.hasNextDouble()) {
            xa = scanner.nextInt();
        }
        if (scanner.hasNextDouble()) {
            ya = scanner.nextInt();
        }
        if (scanner.hasNextDouble()) {
            xb = scanner.nextInt();
        }
        if (scanner.hasNextDouble()) {
            yb = scanner.nextInt();
        }
        double res =  Math.pow(Math.pow(Math.abs(xb-xa),2) + Math.pow(Math.abs(yb-ya),2),0.5);
        System.out.printf("%.3f",res);

    }
}
