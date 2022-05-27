package 剑指offer;

import org.junit.Test;

/** 动规递推关系式
 * dp[x][x]的值代表走到这里要花多少步
 * 有可能是这里的多，也有可能是这里之前的多，取最短能到这里附近的值，和到这里的值的最大值即可
 * dp[n][m] = max ( min(dp[n-1][m],dp[n+1][m],dp[n][m-1],dp[n][m+1]),sum(n,m) )
 * 初始值：
 * dp[0][0] = 0;
 * dp[0][K] = sum;
 * dp[k][0] = sum;
 * 这道题还有一个隐藏的优化：我们在搜索的过程中搜索方向可以缩减为向右和向下，而不必再向上和向左进行搜索
 *
 * */
public class 机器人的运动范围 {

    @Test
    public  void  test() {
        System.out.println(DPmovingCount(16,8,4));
    }

    private int dp[][];

    private int res = 0;

    public int DPmovingCount(int m, int n, int k) {
        dp = new int[m+1][n+1];
        for(int i = 1 ; i < m ; i++){
            dp[i][0] = Math.max(dp[i-1][0],sum(i,0));
        }
        for(int i = 1 ; i < n ; i++){
            dp[0][i] = Math.max(dp[0][i-1],sum(i,0));
        }
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ;j++){
                dp[i][j] = Math.max ( Math.min(dp[i-1][j],dp[i][j-1]),sum(i,j) );
            }
        }
        for (int i = 0; i < m; i++) {
            for(int j = 0 ; j < n ;j++){
                System.out.print(dp[i][j]+" ");
                if(dp[i][j] <= k){
                    res++;
                }
            }
            System.out.println("");
        }
        return res;
    }

    //pass能确定这次走到的格子以前没走到过
    private boolean[][] pass;
    public int movingCount(int m, int n, int k) {
        // 不需要这个，允许重复走
        // used = new boolean[m][n];
        pass = new boolean[m][n];
        dfs(0,0,m,n,k);
        return res;
    }
    //i j代表当前位置
    public void dfs(int i, int j ,int m , int n , int k){

        //能走到 && 以前没走过
        if(sum(i,j) <= k && !pass[i][j]){
            res += 1;
            pass[i][j] = true;
        }
        //不能走到，直接return
        else {
            return;
        }
        //上
        if(i - 1 >= 0 ){

            dfs(i-1,j,m,n,k);

        }
        //下
        if(i + 1 < m  ){

            dfs(i+1,j,m,n,k);

        }
        //左
        if(j - 1 >= 0 ){

            dfs(i,j-1,m,n,k);

        }
        //右
        if(j + 1 < n ){

            dfs(i,j+1,m,n,k);

        }
    }
    //求位数和
    public int sum(int i , int j ){
        int sum = 0;
        while(i != 0 ){
            sum += i % 10;
            i /= 10;
        }
        while(j != 0 ){
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }


}
