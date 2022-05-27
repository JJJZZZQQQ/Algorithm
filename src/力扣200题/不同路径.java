package 力扣200题;

public class 不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePath3(10, 10));
    }
    /** 排列组合*/
    public static int uniquePaths(int m, int n) {
        long  min = Math.min(m,n);
        long a = min -1;
        long b = m + n -2;
        long sum = 1;
        for( long i = b ; i >=b-a+1 ; i--){
            sum *= i;
        }
        for(long i = a ; i>=1 ; i--)
            sum/=i;
        return (int) sum;
    }
    /** 动态规划
     * dp[i][j] = Max(dp[i-1][j],dp[i][j-1])+1*/
    public static int uniquePath(int m , int n ){
        int[][] dp = new int [m+1][n+1] ;
        for(int i = 0 ; i < m ; i++){
            dp[i][0] = 0;
        }
        for(int i = 0 ; i < n ; i++){
            dp[0][i] = 0;
        }
        dp[1][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(i==1&&j==1)continue;
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];

    }
    /** 优化一下空间 */
    public static int uniquePath3(int m , int n ){
        int[] dp = new int [n] ;
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                if(i==0&&j==0)continue;
                if(j!=0)dp[j] = dp[j-1]+ dp[j];
            }
        }
        return dp[n-1];

    }
}
