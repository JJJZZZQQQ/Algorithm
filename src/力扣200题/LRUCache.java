package 力扣200题;

import java.util.LinkedList;

public class LRUCache {

    class Node{
        int key;
        int value;
        public Node(){};
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    //最大容量
    private int capacity;
    //当前容量
    private int size = 0;

    private LinkedList <Node> list = new LinkedList<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        for (Node node : list) {
            if(node.key == key){
                //需要把当前结点放到list的头部

                return node.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {

        //先判断里面已经存不存在
        if(get(key) == -1){
            //判断缓存未满，直接加入缓存
            if(size < capacity)list.push(new Node(key,value));
            //已满,需要把最后一个结点删除，再头插进去。
            else {
                list.pollLast();
                list.addFirst(new Node(key,value));
            }
        }
        //如果存在,需要把已经存在的放到队首
        else {
            list.remove(new Node (key,value));
            list.addFirst(new Node (key,value));
        }
    }
}


