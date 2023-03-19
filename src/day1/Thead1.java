package day1;

//使用多线程，但是同时操作一个对象
//但是如果不进程线程同步的话这样写是会有问题的
//经典案例，买火车票
public class Thead1 implements Runnable {

    //    票数
    private int ticket = 10;

    @Override
    public void run() {
        while (true) {

            if (ticket <= 0) {
                break;
            }
//            模拟买票的延迟
            try {
//                延迟0.2秒
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    "拿到了第" + ticket-- + "张票"
            );
        }
    }

    public static void main(String[] args) {
//        下面进行买票的模拟
        Thead1 th1 = new Thead1();
        new Thread(th1, "线程1").start();
        new Thread(th1, "线程2").start();
        new Thread(th1, "线程3").start();
    }
}
