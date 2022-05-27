package 京东;

import com.mysql.jdbc.JDBC4Connection;
import com.mysql.jdbc.JDBC4MysqlSQLXML;
import javafx.beans.property.adapter.JavaBeanProperty;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long sum = 0;
        int [] arr = new int[10];
        arr[0] = 1;arr[1] = 0;arr[2] = 0;
        arr[3] = 0;arr[4] = 0;arr[5] = 0;arr[6] = 1;
        arr[7] = 0;arr[8] = 2;arr[9] = 1;

        while (n > 0) {
            int mod = (int) (n % 10);
            sum += arr[mod];
            n /= 10;
        }
        System.out.println(sum);

    }
}
