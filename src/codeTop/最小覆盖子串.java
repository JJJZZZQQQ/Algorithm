package codeTop;

public class 最小覆盖子串 {
    /**
     * need 数组代表需要的t字符串中的字母数量
     */
    public String minWindow(String s, String t) {
        int [] need = new int[128];
        //大于 0 代表需要 ，小于 0 代表多余
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int n = s.length();
        int count = t.length();
        int left = 0 , right = 0;
        int start = 0 , end = Integer.MAX_VALUE;
        //右窗口一直扩大，直到 count 为 0 ，说明都有了
        while (right < n) {
            char c = s.charAt(right);
            if(need[c] > 0) {
                count--;
            }
            need[c]--;
            //然后缩小左窗口
            if(count == 0) {
                while (left <= right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)]++;
                    left++;
                }
                //更新最小值
                if(right - left < end - start) {
                    start = left;
                    end = right;
                }
            }
            right++;
        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start,end + 1);
    }
}
