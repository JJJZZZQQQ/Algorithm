package 百度;

// 本题为考试单行A多行输入输出规范示例，无需提交，不计分。
import java.util.Arrays;
import java.util.Scanner;
public class  A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int [] array = new int[k];

        for (int i = 1 ; i <= k; i++) {
            int t = n * i;
            StringBuilder s = new StringBuilder(t+"");
            array[i - 1] = Integer.parseInt(s.reverse().toString());
        }
        Arrays.sort(array);
        System.out.println(array[k - 1]);
    }
}