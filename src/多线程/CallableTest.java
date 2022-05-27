package 多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) {

        FutureTask<String> task = new FutureTask<String>(new MyCallable(10));
        new Thread(task).start();
        try {
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class MyCallable implements Callable<String> {

    private int id;
    MyCallable(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(50000);
        return "result of TaskWithResult "+id;
    }
}
