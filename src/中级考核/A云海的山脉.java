package 中级考核;

import java.util.Scanner;

public class A云海的山脉 {
    public static void main(String[] args) {
        int n , k ,i;
        int [] nums  = new int[105];
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        for(i = 0 ; i< n ; i ++){
            nums[i] = scanner.nextInt();
        }
        int res = 0 ;
        int resk = k ;
        for(i =  0 ; i < n ; i++){
            if(nums[i]>k)break;
            if(resk-nums[i]<0){
                res += 1;
                resk = k;
            }
            resk -= nums[i];
        }
        if(i<n) System.out.println(-1);
        else System.out.println(res);
    }
}
