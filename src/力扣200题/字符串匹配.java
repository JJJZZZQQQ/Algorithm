package 力扣200题;

public class 字符串匹配 {
    /**
     * 暴力
     * 时间复杂度:O((n - m + 1) * m)
     */
    public int strStr(String ss, String pp) {
        int n = ss.length() , m = pp.length();
        char[] ssArr = ss.toCharArray();
        char[] ppArr = pp.toCharArray();

        for(int i = 0 ; i < n - m ; i++) {
            int indexS = i , indexP = 0;
            while (indexS < n && indexP < m && ssArr[indexS] == ppArr[indexP]) {
                indexS++;
                indexP++;
            }
            if(indexP == m) {
                return i;
            }
        }
        return -1;

    }


}
