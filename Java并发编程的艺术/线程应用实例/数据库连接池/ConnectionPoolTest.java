package 线程应用实例.数据库连接池;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/*下面通过一个示例来测试简易数据库连接池的工作情况，模拟客户端ConnectionRunner获取、使用、最后释放连接的过程，当它使用时
 * 连接将会增加获取到连接的数量，反之，将会增加未获取到连接的数量。*/
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    //保证所有ConnectionRunner能够同时开始
    static CountDownLatch start = new CountDownLatch(1);
    //main线程将会等待所有ConnenctionRunner结束后才能执行
    static CountDownLatch end;

    public static void main(String[] args) throws Exception {
        //线程数量，可以修改线程数量进行观察
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot),
                    "ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);
    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (Exception ex) {
            }
            while (count > 0) {
                try {
                    //从线程池获取连接，如果1000ms内无法获取到，将会返回null
                    //分别统计连接获取的数量 got 和未获取到的数量notGot
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else{
                        notGot.incrementAndGet();
                    }
                } catch (Exception ex) {
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
