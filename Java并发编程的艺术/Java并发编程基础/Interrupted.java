package Java并发编程基础;

import java.util.concurrent.TimeUnit;
/*
* 两种情况下线程收到中断, 查看其中断标志位时为false：
* 1. 查看标志位时线程已经终止
* 2. 线程收到中断后抛出InterruptedException之前，会对中断标志位复位*/
public class Interrupted {
    public static void main(String[] args) throws Exception{
        //sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(),"SleepRunner");
        sleepThread.setDaemon(true);
        //busyThread 不停的运行
        Thread busyThread = new Thread(new BusyRunner(),"BusyRunner");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();

        //休眠5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        //防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){
            }
        }
    }
}
