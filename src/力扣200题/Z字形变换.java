package 力扣200题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Z字形变换 {

    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        int n = s.length();
        char[][] res = new char[10000][10000];
        char[] array = s.toCharArray();
        int i = 0;
        int column = 0;
        int j = 0;
        while (i < array.length) {
            //往下走
            if (i != 0) j = 1;
            for (; j < numRows && i < array.length; j++) {
                res[j][column] = array[i++];
            }
            //斜着走
            for (j = j - 2, column = column + 1; j >= 0 && i < array.length; j--, column++) {
                res[j][column] = array[i++];
            }
            column--;
        }
        StringBuilder sb = new StringBuilder();
        for (char[] re : res) {
            for (char c : re) {
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ',' || c == '.') sb.append(c);
            }
            if (sb.length() == s.length()) break;
        }
        return sb.toString();
    }

    public String convertK(String s, int numRows) {
        //这里为什么用StringBuilder ,因为字符在每一行最后输出的结果都是一个接一个的
        //所以我们直接用SB拼接在后面就行了，这样就不用维护在哪一列了
        if (numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int flag = -1;
        int i = 0;
        char[] array = s.toCharArray();
        for (char c : array) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }
}
