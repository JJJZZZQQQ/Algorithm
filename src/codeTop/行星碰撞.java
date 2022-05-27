package codeTop;

import java.util.*;

public class 行星碰撞 {
    /**
     * 无脑入栈
     * 1栈为空
     * 2栈顶元素为负数(下一个为负数则一起向左，下一个为正数则分向两边)
     * 3当前元素为正数（栈顶为正一起向右，栈顶为负分向两边）
     *
     * 除此之外一定是
     * 栈顶为正,当前为负
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int p = 0;
        while (p < asteroids.length) {
            if (s.empty() || s.peek() < 0 || asteroids[p] > 0) {
                s.push(asteroids[p]);
            }
            //正的被撞毁，如果是当前元素被撞毁，直接移动指针即可
            else if (s.peek() + asteroids[p] <= 0) {
                // < 0 的情况，还要继续循环
                if (s.pop()  + asteroids[p] < 0) {
                    continue;
                }
            }
            p++;
        }
        int[] ret = new int[s.size()];
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[i] = s.pop();
        }
        return ret;
    }
}
