package 面试;

import java.util.*;
public class Main {

    /*
    *   6 2
        hahaha
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int [] ans = new int[1111];
        char [] t = new char[1111];

        int m = 0;
        if( (n & 1) == 1) {
            ans[++m] = n/2 + 1;
            for (int i = 1; i <= n / 2; i++) {
                ans[++m] = n/2 -i + 1;
                ans[++m] = n/2 + i + 1;
            }
        } else {
            for (int i = 1; i <= n / 2; i++) {
                ans[++m] = n/2 -i + 1;
                ans[++m] = n / 2 + i;
            }
        }
        for(int i = 1; i <= n ;i++) {
            if(k == 1) {
                t[i] = s.charAt(ans[i] - 1);
            } else {
                t[ans[i]] = s.charAt(i - 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(t[i]);
        }

    }










    public static String jiami(StringBuilder s ,StringBuilder t) {
        if(s.length() == 0) {
            return t.toString();
        }
        int size = s.length();
        t.append(s.charAt((size + 1) / 2 - 1));
        s.deleteCharAt((size + 1) / 2 - 1);
        return jiami(s,t);
    }

    public static String jiemi(StringBuilder s ,StringBuilder t ) {
        int size = s.length();
        //通过size计算 每次加密的位置
        int [] weizhi = new int[size];
        for (int i = 0; i < size; i++) {
            weizhi[i] = (size - i + 1) / 2 -1;
        }

        char [] arr = new char[size];

        for (int i = size - 1; i >= 0; i--) {
            arr[weizhi[size - i - 1]] = s.charAt(size - 1);
        }
        return new String(arr);
    }


}


