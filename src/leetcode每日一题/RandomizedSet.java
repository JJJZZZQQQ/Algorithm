package leetcode每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RandomizedSet {

    Map<Integer, Integer> indexMap;
    List<Integer> data;
    int size;

    public RandomizedSet() {
        indexMap = new HashMap<>();
        data = new ArrayList<>();
        size = 0;
    }

    public boolean insert(int val) {
        if(indexMap.containsKey(val)) {
            return false;
        }
        int index = size++;
        data.add(val);
        indexMap.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if(!indexMap.containsKey(val)) {
            return false;
        }
        Integer index = indexMap.get(val);
        //不能直接删除，会导致数组不密集，随机出来的索引不一定能完全取到
        indexMap.remove(val);

        int last = data.get(size - 1);
        data.set(index, last);
        indexMap.put(last, index);
        data.remove(size - 1);
        size--;
        return true;
    }

    public int getRandom() {
        int index = (int) (Math.random() * size);
        return data.get(index);
    }

}

