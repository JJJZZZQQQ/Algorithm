// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Arrays;
import java.util.Scanner;

public class XXX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n = 5;
        while (T-- > 0){
            long [] array = new long[6];
            long sum = 0;
            long g = 0;
            for (int i = 1; i <= n; i++) {
                array[i] = sc.nextInt();
            }
            Arrays.sort(array);
            //第一个可以直接减

            while (true) {
                Arrays.sort(array);
                if(array[2] == 0)break;
                else if(array[1] == 0) {
                    //减第二个
                    for(int i = 2 ; i <= 5 ;i++) {
                        array[i] -= 1;
                    }
                    sum++;
                } else if(array[1] != 0) {
                    //减 1  3  4 5
                    long t = array[2] - array[1] + 1;
                    array[1] -= t ;
                    for(int i = 3 ; i <= 5 ;i++) {
                        array[i] -= t;
                    }
                    sum += t;
                }
            }

            System.out.println(sum);
        }

    }
}