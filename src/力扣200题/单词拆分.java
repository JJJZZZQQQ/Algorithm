package 力扣200题;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String s1 : wordDict) {
            set.add(s1);
        }
        char[] array = s.toCharArray();
        int i = 0, j = 0;
        while (j < array.length) {
            if (set.contains(s.substring(i, j + 1))) {
                i = j + 1;
                j = i;
            } else {
                j++;
            }
            if (j >= array.length - 1) {
                if (j == i || set.contains(s.substring(i, j + 1))) return true;
                else return false;
            }
        }
        return false;
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String > set = new HashSet<>(wordDict);
        int length = s.length();
        //从 0 到 i 是否可行
        //递推公式
        //dp[i]  = subString(j,i)  && dp[j]
        //
        boolean [] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0 ; j < i;j++) {
                //j 到 i - 1 是否在字典里面 且 0 到 j在字典里面
                //i 固定， 为当前的子字符串长度
                //那么j 应该是 0 到 i - 1 的为位置
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
