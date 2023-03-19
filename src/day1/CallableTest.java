package day1;

import java.util.concurrent.*;

public class CallableTest {
    //    第三种方式是实现callable接口
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable1 c1 = new Callable1();
        Callable1 c2 = new Callable1();
        Callable1 c3 = new Callable1();

        ExecutorService ser = Executors.newFixedThreadPool(10);
        Future<Boolean> r1 = ser.submit(c1);
        Future<Boolean> r2 = ser.submit(c2);
        Future<Boolean> r3 = ser.submit(c3);

        Boolean res1 = r1.get();
        Boolean res2 = r2.get();
        Boolean res3 = r3.get();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        ser.shutdown();

    }
}


class Callable1 implements Callable<Boolean> {

    //    需要注意的是这个方法是有返回值的
    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(20);
            System.out.println(
                    Thread.currentThread().getName() +
                            "第" +i+"次执行"
            );
        }
        return true;
    }
}