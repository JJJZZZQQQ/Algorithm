package 实习生考核;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int [] array = new int[3];

        if (scanner.hasNextInt()) {
            array[0] = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            array[1] = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            array[2] = scanner.nextInt();
        }
        Arrays.sort(array);
        if(array[0] + array[1] <= array[2]) System.out.println(0);
        else if(array[2] - array[0] >= array[1]) System.out.println(0);
        else System.out.println(1);
    }
}
