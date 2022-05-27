

/** 如果面试官要我手写一个跳表。
 * 我的思路：
 * 1.确定数据结构。
 *      跳表肯定会包括Node节点，并且有跳表相关的信息，其中最重要的应该就是跳表的层高。因为所有操作都会从最高层开始
 *      Node节点需要能满足这几点，存放的值data，指向该节点向右节点的指针，指向该节点向下的指针
 *      Node [] next = new Node[MaxLevel]
 *      其中，next[i]表示这个node节点在第i层向右的指针
 *      next[i-1] 就是 next[i] 向下的指针 */
public class MySkipList {

    private int levelCount = 0;
    private final static int MaxLevel = 16;
    private Node head = new Node();

    public Node find(int num) {
        //从头节点开始找
        //过程，先找当前节点的右节点，一直到最后一个小于等于num的节点，然后往下一层走
        //然后又是重复的往右找
        Node now = head;
        for (int i = levelCount - 1 ; i >= 0; i--) {
            while(now.next[i] != null && num >= now.next[i].data) {
                now = now.next[i];
            }
        }
        if(now.data == num)return now;
        else return null;
    }

    public boolean delete(int num) {
        //也是先查找,但是得变一下，因为要记录前置节点，所以往右遍历的时候等于就不继续往下了
        //找到以后把所有层级的这一节点都删除
        //由于是链表删除，需要记录每一层删除节点位置的前置指针
        //我们就用preNode[i]代表每一层前置节点的位置
        //删除完记得修改层高
        Node now = head;
        Node [] preNode = new Node[MaxLevel];
        for (int i = levelCount - 1 ; i >= 0; i--) {
            while(now.next[i] != null && num > now.next[i].data) {
                now = now.next[i];
            }
            preNode[i] = now;
        }
        //此时的now节点应该是num节点的前一个节点
        if(now.next[0] != null && now.next[0].data == num) {
            //删除
            for(int i = levelCount - 1 ; i >= 0 ;i--) {
                //直接指向下一个的下一个
                preNode[i].next[i] = preNode[i].next[i].next[i];
            }
            //修改层高，判断最上层的是否为null
            while(levelCount > 1 && head.next[levelCount] == null)levelCount--;
            return true;
        } else {
            return false;
        }
    }

    public void insert(int num) {
        //先找到要插入的位置
        //同样也要记录preNode数组
        //随机函数获取层高K
        //把K 到 1层都插入这个数
        Node now = head;
        Node [] preNode = new Node[MaxLevel];
        for (int i = levelCount - 1 ; i >= 0; i--) {
            while(now.next[i] != null && num > now.next[i].data) {
                now = now.next[i];
            }
            preNode[i] = now;
        }
        int level = randomLevel();
        //每层都插入
        for(int i = level - 1 ; i >= 0; i-- ) {
            Node insert = new Node();
            insert.data = num;
            insert.next[i] = preNode[i].next[i];
            preNode[i].next[i] = insert;
        }
        //修改最大层高
        if(levelCount < level)levelCount = level;
    }
    /** 随机函获得当前插入数据层高*/
    public int randomLevel() {
        int level = 1;
        Math.random();
        return level;
    }
    class Node{
        private int data;
        Node [] next = new Node[MaxLevel];
    }
}
