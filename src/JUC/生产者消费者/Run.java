package JUC.生产者消费者;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true)
                service.set();
            }).start();

            new Thread(() -> {
                while (true)
                service.get();
            }).start();
        }
    }
}
