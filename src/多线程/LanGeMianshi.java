package 多线程;

/** 问题：
 * 某学校有A、B、C、D四间教室，请基于公平性原则设计一套方案，启动四个线程，对四个教室轮流进行教学考勤
 * 共轮询六次。（考勤业务以打印出线程对应的”教室名+次数 “）
 * */
public class LanGeMianshi {
    /** 思路：
     * 一共四个线程，每个线程执行对应的业务方法
     * 但是要让四个线程互相join*/
    public static void main(String[] args) {
        Thread A = new Thread(new MyRunnable("A"));
        Thread B = new Thread(new MyRunnable("B"));
        Thread C = new Thread(new MyRunnable("C"));
        Thread D = new Thread(new MyRunnable("D"));

    }


}

class MyRunnable implements Runnable {
    private String className;
    MyRunnable(String className) {
        this.className = className;
    }
    @Override
    public void run() {
        for (int i = 0  ; i < 6; i++) {
            System.out.println(className+"第"+i+"次考勤");
        }
    }
}
