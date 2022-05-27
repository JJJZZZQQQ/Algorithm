package leetcode每日一题;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class 相对名次 {

    @Test
    public void test() {
        findRelativeRanks(new int[] {5,4,3,2,1});
    }
    public String[] findRelativeRanks(int[] score) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>( (a,b) -> b - a );
        for (int i = 0; i < score.length; i++) {
            treeMap.put(score[i], i);
        }
        String[] res = new String[score.length];
        Set<Integer> keySet = treeMap.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            int key = iterator.next();
            if (i == 0) {
                res[treeMap.get(key)] = "Gold Medal";
            } else if (i == 1) {
                res[treeMap.get(key)] = "Silver Medal";
            } else if (i == 2) {
                res[treeMap.get(key)] = "Bronze Medal";
            } else {
                res[treeMap.get(key)] = i + 1 + "";
            }
            i++;
        }
        return res;
    }
}
