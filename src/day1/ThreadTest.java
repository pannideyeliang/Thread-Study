package day1;

public class ThreadTest {
    //    目前实现多线程有三个方法
//    首先是继承thread类
//    实现方法如下所示
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println("我是一个主程序，我现在正在工作");
        }
    }
}


class Thread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("我是一个计时器，现在是第 " + i + " 秒");
        }
    }
}