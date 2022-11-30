package 蔚来;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class A {
    /**
     * 用hashmap模拟池子
     * 2
     * 4 1 : 4,3,2,1
     * 5 2: 5,2,3,1,4
     * 4,2: 4,2
     * 6,1: 6,1,5,4,3,2
     * 5,3:
     * */
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            if(Math.max(x,y) % 2 == 1) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }


}
