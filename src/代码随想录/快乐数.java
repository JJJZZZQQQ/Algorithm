package 代码随想录;

import org.junit.Test;

import java.util.HashSet;

public class 快乐数 {

   /**  题目说了非快乐数会陷入无限循环，那么也就是说之前的结果中出现了重复的数字*/
    public boolean isHappy(int n) {
        HashSet <Integer> unHappy = new HashSet<>();;
        while (n != 1) {
            if(unHappy.contains(n)) {
                return false;
            }
            unHappy.add(n);
            n = sum(n);
        }
        return true;
    }

    public int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
