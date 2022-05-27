package codeTop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 复原IP地址 {
    /**
     * 回溯
     * 当插入第三个点时候结束，并且收集结果(不好处理，最后一个数还要考虑前导0的情况)
     * <p>
     * 当列表里插入了四个数的时候结束，并且如果此时字符串刚好遍历完了，就收集结果
     */
    @Test
    public void test() {
        for (String s : restoreIpAddresses("1111")) {
            System.out.println(s);
        }
    }
    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        callback("", 0, 0, s);
        return res;
    }
    public void callback(String str, int count, int index, String s) {
        if (count == 4 || index >= s.length()) {
            if (count == 4 && index == s.length()) {
                res.add(str.substring(0,str.length() - 1));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            //越界
            if (i + index > s.length()) return;
            //考虑前导0
            if(s.charAt(index) == '0' && i != 1)return;
            //考虑 最后的结果不能 大于255，一位数和两位数是啥都行，只要考虑三位数的情况
            String t = s.substring(index, index + i);
            if(i == 3 && Integer.parseInt(t) > 255) return;
            //开始回溯
            str = str + t + ".";
            callback(str,count + 1,index + i , s);
            str = str.substring(0 , str.length() - i -1);
        }
    }
}
