package 中级考核;

import java.util.Arrays;
import java.util.Scanner;

public class B密林的大树 {
    public static void main(String[] args) {
        int n, k, i;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[] nums = new int[n];
        for (i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int sum = 0;
        i = n - 1;
        int index = 0;
        while (index < n && nums[index] > 0) {
            sum += nums[i];
            nums[i--] = 0;
            for (int j = index; j <= i; j++) {
                nums[j] -= k;
            }
            while (index < n && nums[index] <= 0) {
                index++;
            }
        }
        System.out.println(sum);
    }
}
