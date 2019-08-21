package Java并发编程基础;

import java.util.concurrent.TimeUnit;
/*
* main线程通过中断操作和cancel()方法设置标志位均可以使CountThread得以终止。这种通过标志位或者中断操作的方式来
* 终止线程能够使得线程在终止时有机会去清理资源，而不是武断地将线程停止，因此更推荐这样的方法终止线程。
* */
public class ShutDown {
    public static void main(String[] args) throws Exception{
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        //睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        //睡眠1秒，main线程对Runner two进行取消，使countThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            //用一个标志位可以终止线程，或者利用中断位来终止线程
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel(){
            on = false;
        }
    }
}
