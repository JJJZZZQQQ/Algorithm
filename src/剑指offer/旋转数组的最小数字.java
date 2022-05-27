package 剑指offer;

public class 旋转数组的最小数字 {
    public static void main(String[] args) {

    }
    /** 时间复杂度为O(N),有时间复杂度为O(logN)的解法*/
    public int fun(){
        int [] numbers = new int[2];
        int n = numbers.length;
        for(int i = n - 1 ; i > 0; i--){
            if(numbers[i-1] > numbers[i]){
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
