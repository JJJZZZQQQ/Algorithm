package 力扣200题;

public class 最长公共前缀 {
    //纵向扫描
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs[0].equals(""))return "";
        //最长公共前缀不可能超过任何一个字符串，我们直接用第一个字符串做为边界即可
        int length = strs[0].length();
        int count = strs.length;
        //列数
        for(int i = 0 ;i < length ;i++) {
            char c = strs[0].charAt(i);
            //行数
            for(int j = 1 ; j < count ; j++) {
                //第j个字符串的长度小于第一个字符串，说明第j个字符串才是最短的  ||字符不相等 就代表不相等了，直接返回即可
                if(i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0 , i);
                }
            }
        }
        return strs[0];
    }
}
