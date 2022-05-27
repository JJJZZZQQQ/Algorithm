

import org.junit.Test;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class test {


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (true) {
                System.out.println("111");
            }
        }).start();

        Thread.sleep(3000);
    }
}
