package 实习生考核;

import java.util.HashSet;

public class E {
    public static void main(String[] args) {
        System.out.println("192 384 576");
        System.out.println("219 438 657");
        System.out.println("267 534 801");
        System.out.println("273 546 819");
        System.out.println("327 654 981");
    }

    public static boolean fun(int a, int b, int c) {
        HashSet<Integer> set = new HashSet<>(16);
        int q = a % 10;
        int w = a /10 % 10;
        int e = a /100 % 10;
        int r = b % 10;
        int t = b /10 % 10;
        int y = b /100 % 10;
        int u = c % 10;
        int i = c /10 % 10;
        int o = c /100 % 10;
        if(set.contains(q))return false;
        else set.add(q);

        if(set.contains(w))return false;
        else set.add(w);

        if(set.contains(e))return false;
        else set.add(e);

        if(set.contains(r))return false;
        else set.add(r);

        if(set.contains(t))return false;
        else set.add(t);

        if(set.contains(y))return false;
        else set.add(y);

        if(set.contains(u))return false;
        else set.add(u);

        if(set.contains(i))return false;
        else set.add(i);
        if(set.contains(o))return false;
        else set.add(o);
        return true;
    }
}
