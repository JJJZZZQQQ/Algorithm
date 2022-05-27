package JUC;

import java.util.concurrent.*;

/**
 * 需求：使用Java多线程计算 1+2+3+4的结果
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;//阈值

    private int start;

    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        //如果任务足够小就计算任务 fork 边界
        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute) {
            for(int i = start; i <= end ;i++) {
                sum+=i;
            }
        } else {
            //任务 fork
            int mid = (start + end) / 2;
            CountTask leftTask = new CountTask(start,mid);
            CountTask rightTask = new CountTask(mid + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();

            int leftRes = leftTask.join();
            int rightRes = rightTask.join();

            sum = leftRes + rightRes;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,4);

        Future<Integer> result = forkJoinPool.submit(task);
        Throwable exception = task.getException();
        System.out.println(exception);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }

    }
}
