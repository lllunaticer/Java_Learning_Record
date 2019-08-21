package Java并发编程基础;
//JAVA虚拟机推出时Daemon线程中的finally块并不一定会被执行
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }
/*
* 运行本程序会发现控制台没有任何输出。main线程(非Daemon线程)，在启动了线程DaemonRunner之后随着main方法执行完毕
* 而终止，而此时JAVA虚拟机中已经没有非Daemon线程，虚拟机需要退出。JAVA虚拟机中的所有Daemon线程都需要立即终止，因此
* DaemonRunner立即终止, 导致DaemonRunner中的finally块并没有执行
*
* 因此，在构建Daemon线程时, 不能依靠finally块中的内容来确保执行关闭或清理资源的逻辑*/
    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
