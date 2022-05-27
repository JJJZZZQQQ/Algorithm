package 剑指offer;

import java.util.HashMap;

public class 数组中数字出现的次数Ⅱ {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean>map = new HashMap<>();
        for (int num : nums) {
            map.put(num, !map.containsKey(num));
        }
        for (Integer integer : map.keySet()) {
            if(map.get(integer))return integer;
        }
        return 0;
    }
}
