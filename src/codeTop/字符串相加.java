package codeTop;

public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = a.length - 1, j = b.length - 1;
        int jinwei = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? a[i] - '0' : 0;
            int n2 = j >= 0 ? b[j] - '0' : 0;
            int sum = n1 + n2 + jinwei;
            sb.append(sum % 10);
            jinwei = sum / 10;
            i--;
            j--;
        }
        if (jinwei != 0) sb.append(jinwei);
        return sb.reverse().toString();
    }
}
