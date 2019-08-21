package Java并发编程基础;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/*
* 1.使用wait(),notify(),和notifyAll()时需要先对调用对象加锁。
* 2.调用wait()方法后，主动释放持有的锁，线程状态由RUNNING变为WAITING,并将当前线程放置到对象的等待队列。（注意分清楚等待队列和同步队列两个概念，等待队列中的线程
* 需要被唤醒才能进入同步队列，进而去争夺锁。处在同步队列中的线程，也就是处在争夺锁状态的线程，成为阻塞状态。）
* 3. notify或notifyAll方法调用后，等待线程中的线程依旧不会从wait()返回，需要调用notify或者notifyAll的线程释放锁之后，等待线程才有机会从wait返回。
* 4. 从wait返回的前提是获得了调用对象的锁。
* notify方法是将等待队列中的一个等待线程从等待队列移到同步队列中，而notifyAll方法是将等待队列中的所有线程全部移到同步队列。被移动到同步队列的线程
* 其线程状态由WAITING变为BLOCKED.
* * */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(),"WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            //加锁，拥有lock的Moniter
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ " +
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. wait @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            //加锁，拥有lock的Moniter
            synchronized (lock){
                //获取lock的锁，然后进行通知，通知时不会释放lock的锁
                //直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread()+" hold lock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            SleepUtils.second(1);
            //再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + "hold lock again. sleep @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
}
