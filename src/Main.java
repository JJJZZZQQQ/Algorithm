// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    /*registration complete
illegal length
acount existed
illegal charactor*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = in.next();
            if(s == null) {
                System.out.println("illegal charactor");
                continue;
            }
            int size = s.length();
            if(size > 12 || size < 6) {
                System.out.println("illegal length");
                continue;
            }
            if(!isZimu(s)) {
                System.out.println("illegal charactor");
                continue;
            }
            if(set.contains(s)) {
                System.out.println("acount existed");
                continue;
            }
            set.add(s);
            System.out.println("registration complete");
        }
    }
    public static boolean isZimu(String s) {
        for (char c : s.toCharArray()) {
            if((c >= 'a' && c <= 'z' )|| (c >= 'A' && c <= 'Z')) {

            } else {
                return false;
            }
        }
        return true;
    }
}