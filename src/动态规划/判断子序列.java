package 动态规划;

import org.junit.Test;

public class 判断子序列 {
    @Test
    public void myanswer() {
        String s = "abc";
        String t = "ahbgdc";
        int m = s.length();//小串
        int n = t.length();//大串
        int j = 0, i = 0;
        if (s.equals("")) System.out.println(true);
        boolean flag = false;
        for (i = 0; i < m; i++) {
            flag = false;
            while (j < n) {
                if (s.charAt(i) == t.charAt(j)) {
                    flag = true;
                    j++;
                    break;
                }
                j++;
            }
            if (j == n) break;
        }
        if (!flag) System.out.println(false);
        else if (i == (m - 1)) System.out.println(true);
        else if (i == m) System.out.println(true);
        else System.out.println(false);
        ;
    }

    @Test
    /**两个一起动，就用双指针，一个循环就能解决 */
    public void answer() {
        String s = "abc";
        String t = "ahbgdc";
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        System.out.println(i == n);
    }

    @Test
    /** 大数据量的访问,先预处理一次，预处理的方法可以有多种，穷举，动规等*/
    public void answers() {
        String s = "abc";
        String t = "ahbgdc";
        int n = s.length(), m = t.length();
        int[][] f = new int[m + 1][26];
        //初始化
        // i是列，代表每一个英文字符，m是行代表大字符串的第几个位置
        //此处初始化从最后一行开始，是因为状态转移方程是要用到后面的值
        //为什么让f[m][i]的值都为m，当它的值为m的时候，就说明此时父字符串已经遍历完了
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                //值相等，那么该字母在t字符串中的值就是此时i这个位置
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else//值不相等，就要去t的下一个位置找
                    f[i][j] = f[i + 1][j];
            }
        }
        int indext = 0;
        for (int i = 0; i < n; i++) {
            //当dp中的值已经等于m的时候，则说明到字符串末尾都不相等，
            if (f[indext][s.charAt(i) - 'a'] == m) {
                System.out.println(false);
            }
            //说明indext位置以后还有能和s.charAt(i)相等的字母，这时候直接把中间不一样
            //的全部跳过,直接到了t字符串相等字母的下一个位置
            indext = f[indext][s.charAt(i) - 'a'] + 1;
        }
        System.out.println(true);
    }
}
