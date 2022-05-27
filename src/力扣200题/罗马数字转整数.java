package 力扣200题;

import java.util.HashMap;

public class 罗马数字转整数 {
    static HashMap<Character , Integer> map;
    static {
        map = new HashMap<>(16);
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);
    }
    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        char pre  = '0';
        int sum = 0;
        for (char c : array) {
            if(pre == 'I') {
                if(c == 'V') {
                    sum += 3;
                } else if( c == 'X'){
                    sum += 8;
                } else {
                    sum += map.get(c);
                }
            } else if( pre == 'X') {
                if(c == 'L') {
                    sum += 30;
                } else if( c == 'C') {
                    sum += 80;
                } else {
                    sum += map.get(c);
                }
            } else if (pre == 'C') {
                if(c == 'D') {
                    sum += 300;
                } else if(c == 'M') {
                    sum += 800;
                } else {
                    sum += map.get(c);
                }
            }else {
                sum += map.get(c);
            }
            pre = c;
        }
        return sum;
    }
}
