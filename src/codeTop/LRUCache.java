package codeTop;

import java.util.Iterator;
import java.util.LinkedHashMap;

/** LRU:即最近最少使用，当新put了一个，会添加在头部，如果使用了一个，会放到第一个来
 * 并且容量满了之后，每次put新的都会把尾部删除*/
public class LRUCache {
    private LinkedHashMap<Integer,Integer> queue ;
    private int capacity ;
    public LRUCache(int capacity) {
        queue = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!queue.containsKey(key))return -1;
        int res = queue.get(key);
        //把该key放到队首
        queue.remove(key);
        queue.put(key,res);
        return res;
    }
    //修改和新增都要在头部
    public void put(int key, int value) {
        queue.remove(key);
        queue.put(key,value);
        int size = queue.size();
        if(size > capacity) {
            //删除第一个结点
            queue.remove(queue.keySet().iterator().next());
        }
    }
}
