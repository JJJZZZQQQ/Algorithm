package 京东;

import java.util.Arrays;
import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] shengao = new int[n];
        String [] name = new String[n];
        for (int i = 0; i < n; i++) {
            shengao[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            name[i] = in.next();
        }
        Person [] arr = new Person[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Person(shengao[i],name[i]);
        }

        Arrays.sort(arr , (a,b) -> {
            if(a.shengao != b.shengao) {
                return a.shengao - b.shengao;
            }
            return a.name.compareTo(b.name);
        });
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].name);
            if(i != n - 1) {
                System.out.print(" ");
            }
        }

    }
    static class Person {
        int shengao;
        String name;

        public Person(int shengao, String name) {
            this.shengao = shengao;
            this.name = name;
        }
    }
}
