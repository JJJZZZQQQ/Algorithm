package 实习生考核;

import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            System.out.println(change(s));
        }
    }

    public static String change(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    sb.append(s.charAt(i));
                } else {
                    sb.append((char) (s.charAt(i) + 33));
                }
            } else {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    sb.append((char)(s.charAt(i) - 31));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
