package 剑指offer;

import utils.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * 可以考虑使用先序中序构建 字符串，然后套进先序中序重建二叉树即可
 * 序列化不难，但是反序列化的时候一定要考虑到只能反序列化成唯一的一颗树，所以对于空的地方我们也要添加一个null进去
 */
public class 序列化与反序列化二叉树 {
    // Encodes a tree to a single string.
    //使用层序遍历序列化
    //有负值，最好用一个字符隔开
    String NULL = "#";
    String SEP = ",";
    public String serialize(TreeNode root) {
        if(root == null)return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }
                sb.append(poll.val).append(SEP);
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    //一开始直接循环写的，发现处理完左边就不能处理右边了，层序遍历肯定要用队列来写
    public TreeNode deserialize(String data) {
        if(data.isEmpty())return new TreeNode();
        String [] nodes = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        //队列中保存父节点的值，只有父节点（非null）才放进去
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < nodes.length;) {
            TreeNode parent = queue.poll();
            //如果父节点的左节点为空就跳过，不为空就处理
            String left = nodes[i++];
            if(!left.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.add(parent.left);
            }
            //处理右子树
            String right = nodes[i++];
            if(!right.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.add(parent.right);
            }
        }
        return root;
    }

}
