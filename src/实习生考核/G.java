package 实习生考核;

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 10;
        String s = "";
        int m = 2;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        if (scanner.hasNext()) {
            s = scanner.next();
        }
        if (scanner.hasNextInt()) {
            m = scanner.nextInt();
        }
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int num = getNum(array[i]);
        }
    }
    public static int getNum(char c) {
        if(c >= '0' && c <= '9') {
            return c - '0';
        } else {
            return c -'7' - '0';
        }
    }
}
