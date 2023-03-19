package day1;

public class RunnableTest {
    //    第二种方式，我们使用实现runnable接口的方式
    public static void main(String[] args) {
        new Thread(new Runnable1()).start();
        for (int i = 0; i < 10000; i++) {
            System.out.println("这是主线程，主线程正在工作！");
        }
    }
}


class Runnable1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("这是一个时钟，现在是第 " + i
                    + " 秒");
        }
    }
}
