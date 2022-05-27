package 力扣200题;

import java.util.ArrayList;
import java.util.List;

public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> keCheng = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            keCheng.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        //把节点之间的关系存到 一个List里面
        for (int[] num : prerequisites) {
            keCheng.get(num[0]).add(num[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(keCheng,flags,i))return false;
        }
        return true;
    }
    // kecheng ：每一节课需要哪些课在 它前面选的课
    //flags 代表 第i节课有没有被访问过，如果又被访问了，就说明死锁了
    public boolean dfs(List<List<Integer>> keCheng , int[] flags , int i) {
        if(flags[i] == -1) return true;
        if(flags[i] == 1)return false;
        flags[i] = 1;//代表被这节课访问过了,如果再访问到，说明死锁了
        for (Integer j : keCheng.get(i)) {
            if(!dfs(keCheng,flags,j))return false;
        }
        flags[i] = -1;//代表该节课没有问题
        return true;
    }
}
