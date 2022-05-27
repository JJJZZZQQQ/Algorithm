package 剑指offer;

import org.junit.Test;

public class 把字符串转换成整数 {

    @Test
    public void test(){
        System.out.println(strToInt("   -123"));
    }
    public int strToInt(String str) {
        if(str.isEmpty())return 0;
        char[] array = str.toCharArray();
        //先去掉开头的空格
        int now = 0;
        while(array[now] == ' ') {
            if(++now == array.length)return 0;
        }
        if(array[now] != '+' && array[now] != '-' && array[now] != ' ' && (array[now] < '0' || array[now] > '9')) {
            return 0;
        }
        //符号，默认是true
        boolean flag = true;
        if(array[now] == '+')now++;
        else if(array[now] == '-'){
            flag = false;
            now++;
        }
        //开始找数字
        int res = 0;
        while(now < array.length && array[now] >= '0' && array[now] <= '9') {
            //判断越界
            if(res > Integer.MAX_VALUE/10 ){
                if(flag)return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            } else if(res == Integer.MAX_VALUE/10) {
                if(array[now] > '7' && flag){
                    return Integer.MAX_VALUE;
                } else if(array[now]  > '8' && !flag) {
                    return Integer.MIN_VALUE;
                }
            }
            res = res * 10 + (array[now] - '0');
            now++;
        }
        if(flag)return res;
        else return -res;
    }
    public int strToIntK(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if(length == 0) return 0;
        while(str.charAt(i) == ' ')
            if(++i == length) return 0;
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for(int j = i; j < length; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }
}
