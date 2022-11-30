// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import org.junit.Test;

import java.util.*;

public class Main {
    /*registration complete
illegal length
acount existed
illegal charactor*/


    @Test
    public void amain() {
        foo(new int[]{-1,1,2,3,4,5,6} , 3, 6);
    }

    //打印所有和为n的 m个数之和
    //-1,1,2,3,4,5,6
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    void foo(int[] arr, int m, int n) {
        Arrays.sort(arr);
        dfs(arr, n, m, -1, new ArrayList<>());

        for (ArrayList<Integer> re : res) {
            for (int i = 0; i < re.size(); i++) {
                System.out.print(re.get(i));
                if(i != re.size() - 1) System.out.print(",");
            }
            System.out.println();
        }
    }

    void dfs(int[] arr, int n, int m, int index, ArrayList<Integer> list) {
        //如果选完数了且和为n，添加到结果里面
        if (m == 0 && n == 0) {
            res.add(new ArrayList<>(list));
        }

        for(int i = index + 1; i < arr.length ; i++) {
            list.add(arr[i]);
            //和减n - arr[i],个数-1
            dfs(arr,n - arr[i],m - 1,i, list);
            //回溯
            list.remove(list.size() - 1);
        }
    }
}