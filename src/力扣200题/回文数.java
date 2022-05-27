package 力扣200题;

public class 回文数 {

    public boolean isPalindrome(int x) {
        if(x < 0)return false;
        int sum = 0;
        int t = x;
        while (t != 0) {
            sum += t % 10;
            t /= 10;
            if(t != 0)
                sum *= 10;
        }
        if(x == sum)
            return true;
        else
            return false;
    }
}
