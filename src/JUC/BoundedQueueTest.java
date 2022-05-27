package JUC;

import org.junit.Test;

public class BoundedQueueTest {
    @Test
    public void putTest() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(1);
        queue.put(1);
        System.out.println("1 put success");
        queue.put(2);
        System.out.println("2 put success");
    }

    @Test
    public void takeTest() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(1);
        queue.put(1);
        System.out.println("1 put success");

        queue.take();
        System.out.println("1 take success");

        queue.take();
        System.out.println("take success");
    }
}
