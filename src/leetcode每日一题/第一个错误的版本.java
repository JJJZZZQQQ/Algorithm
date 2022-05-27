package leetcode每日一题;

public class 第一个错误的版本 {
    public int firstBadVersion(int n) {
        int left = 1 ,right = n ,mid ;
        int res = 0 ;
        while(left <= right){
            mid = left+(right-left)/2 ;
            if(isBadVersion(mid)){
                res = mid ;
                right = mid-1 ;
            }else{
                left = mid + 1 ;
            }
        }
        return res;
    }
    //力扣提供
    private boolean isBadVersion(int mid) {
        return true;
    }
}
