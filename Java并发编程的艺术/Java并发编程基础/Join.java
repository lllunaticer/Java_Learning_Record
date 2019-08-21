package Java并发编程基础;

import java.util.concurrent.TimeUnit;
/*
* 每个线程终止的前提是前驱线程的终止，每个线程等待前驱线程终止后，才从join方法返回，这里涉及了等待/通知机制（等待前驱
* 线程结束，接收前驱线程结束通知）*/

/*
* join方法会首先加锁当前线程对象，当线程终止时，会调用线程自身的notifyAll方法，会通知所有等待在该线程对象上的线程。
* join方法的逻辑结构与等待/通知机制经典范式一致，即加锁、循环、和逻辑处理3个步骤*/

/*在线程A里面调用B线程的join方法：B.join():
* 首先，join方法时synchronied的，需要获取锁才能执行，先确保B线程已经占用了这个锁，此时A线程调用也需要这个锁的join方法
* 会被阻塞在原地，只有等待B线程终止时，B线程才会调用notifyAll方法并释放这个锁给A线程，A线程才能继续执行。从而达到了“在A线程
* 中调用B线程的join方法，会使得A线程等待B线程执行完毕才能继续执行下去”的效果*/
public class Join {
    public static void main(String[] args) throws Exception {
        Profiler.begin();
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            //每个线程拥有一个对前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Thread.currentThread().getName() + " terminate.");
        MultiThread multiThread = new MultiThread();
        multiThread.findThread();
        System.out.println(Profiler.end());
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
