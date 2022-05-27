package 京东;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long x = in.nextLong();
        String s = in.next();
        char[] array = s.toCharArray();
        for(int i = 0 ;i < N ; i++) {
            char c = array[i];
            if(c == 'U') {
                x = x >> 1;
            } else if(c == 'R') {
                x = x << 1 + 1;
            } else {
                x = x << 1;
            }
        }
        System.out.println(x);
    }
}
