package 剑指offer;

public class 二叉搜索树与双向链表 {
    /** 考虑递归，为null时退出
     *  很明显中序遍历就能搞定
     * */
    boolean flag = true;
    Node head ;
    Node tail  = new Node();
    public Node treeToDoublyList(Node root) {
        if(root == null)return head;
        fun(root);
        tail.right = head;
        head.left = tail;
        return head;
    }
    public void fun(Node root) {
        if(root != null) {
            fun(root.left);
            //操作
            //说明是第一个节点
            if(flag) {
                flag = false;
                head = root;
            }
            tail.right = root;
            root.left = tail;
            //更新tail
            tail = root;
            fun( root.right);
        }
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};