package 力扣200题;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    //目测是栈+回溯
    //确实过了
    //但是看了题解后发现根本不需要要栈

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    /*List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0)return res;
        dfs(n, n, 0,new LinkedList<Character>(), new StringBuilder());
        return res;
    }

    public void dfs(int nLeft, int nRight,int step , Deque<Character> stack, StringBuilder now) {
        if(nLeft < nRight)return;
        if (nLeft == 0 && nRight == 0) {
            res.add(now.toString());
            return;
        }
        if (stack.isEmpty()) {
            stack.push('(');
            now.append('(');
            dfs(nLeft - 1,nRight,step + 1 ,stack,now);
            //回溯
            now.deleteCharAt(step);
            stack.pop();
        } else {
            //栈里面有左括号时，可以放左括号和右括号进去
            if(nLeft > 0 && nRight > 0) {
                stack.push('(');
                now.append('(');
                dfs(nLeft - 1,nRight,step + 1 ,stack,now);
                //回溯
                now.deleteCharAt(step);
                stack.pop();

                stack.pop();
                now.append(')');
                dfs(nLeft,nRight - 1,step + 1 ,stack,now);
                //回溯
                now.deleteCharAt(step);
                stack.push('(');

            } else if(nLeft > 0) {
                stack.push('(');
                now.append('(');
                dfs(nLeft - 1,nRight,step + 1 ,stack,now);
                //回溯
                now.deleteCharAt(step);
                stack.pop();
            } else {
                stack.pop();
                now.append(')');
                dfs(nLeft,nRight - 1,step + 1 ,stack,now);
                //回溯
                now.deleteCharAt(step);
                stack.push('(');
            }
        }

    }*/
}
