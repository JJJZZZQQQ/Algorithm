package labuladong的算法小抄;

import org.junit.Test;

import java.util.*;

public class 开密码锁 {

    @Test
    public void test(){
        openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"
        },"8888");
    }
    public int openLock(String[] deadends, String target) {
        //注意，如果是要有判断重复的功能，一定要用hashset或者hashmap，这样才快
        Set<String>deads=new HashSet<>();
        for(String dead:deadends){
            deads.add(dead);
        }
        Queue<String> queue = new LinkedList<>();
        int res = 0;
        queue.add("0000");
        //不能走回头路
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                //包含在死亡里面
                if (deads.contains(poll)) continue;
                //如果相等了就返回res
                if (target.equals(poll)) return res;
                for (int j = 0; j < 4; j++) {
                    String plusOne = plusOne(poll, j);
                    if (!visited.contains(plusOne)) {
                        queue.add(plusOne);
                        //注意，
                        visited.add(plusOne);
                    }
                    String minusOne = minusOne(poll, j);
                    if (!visited.contains(minusOne)) {
                        queue.add(minusOne);
                        visited.add(minusOne);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    /**
     * 把j位置上的密码向上移动一位
     */
    public String plusOne(String s, int j) {
        char[] array = s.toCharArray();
        if (array[j] == '9')
            array[j] = '0';
        else
            array[j] += 1;
        return String.valueOf(array);
    }

    /**
     * 把j位置上的密码向下移动一位
     */
    public String minusOne(String s, int j) {
        char[] array = s.toCharArray();
        if (array[j] == '0')
            array[j] = '9';
        else
            array[j] -= 1;
        return String.valueOf(array);
    }

}
