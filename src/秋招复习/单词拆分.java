package 秋招复习;

import java.util.List;

public class 单词拆分 {
    //判断子字符串
    //可以拼接的前提是，子字符串为true，且切割的单词出现过
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+ 1];
        dp[0] = true;
        for(int i = 1 ; i <= s.length() ;i++) {
            for(int j = 0 ; j < i ; j++) {
                //判断dp[j] ? true  && j - i 存在
                if(dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
