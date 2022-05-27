package 网易;

import java.util.Scanner;

public class A {
    static int [][] dp = new int[22][22];
    public static void main(String[] args) {
        int a,b,x,y;
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();
        //单体
        x = scanner.nextInt();
        //每只
        y = scanner.nextInt();
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dfs(a,b,0,x,y);
        System.out.println(dp[0][0]);
    }

    public static void dfs(int a,int b , int c ,int x , int y) {
        if (c >= dp[a][b]) return;
        dp[a][b] = c;
        if(a == 0 && b == 0) return;
        dfs(Math.max(a - x , 0), b , c + 1, x ,y);
        if(b > 0) {
            dfs(a, Math.max(b - x , 0), c + 1, x ,y);
        }

        dfs(Math.max( a - y,0) , Math.max(b - y , 0), c + 1 , x ,y);
    }
}
