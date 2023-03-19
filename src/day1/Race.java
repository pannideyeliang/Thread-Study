package day1;

//模拟龟兔赛跑
//下面是共同进行的一场比赛，所以可以在这里直接实现runnable接口
public class Race implements Runnable {

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }

    //    比赛的胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

//            现在我们要模拟兔子睡觉
//            如果你对下面这个部分理解感到有些奇怪，那一定是没有理解到下面
//            的Thread.currentThread()
//            这个函数是跳脱了两个正在运行的线程之外进行判断的
//            如果现在CPU正在运行的是兔子线程，那么就让兔子线程睡个10毫秒
//            如果正在运行的是乌龟线程，那么正常运行
            if (Thread.currentThread().getName().equals("兔子")) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            在每个线程同时在跑步的时候就要进行判断比赛是否结束
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(
                    Thread.currentThread().getName() +
                            "-->跑了" + i + "步"
            );
        }
    }

    //    判断是否完成比赛
    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        }
        {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

}
