package 玩耍threadlocal;
import java.util.*;
/*这段程序的本意是，启动15个线程，线程向map中写入20个整型值，然后输出map。运行该程序，观察结果，我们会发现，
map中压根就不止20个元素，这说明程序产生了线程安全问题。我们都知道HashMap是非线程安全的，程序启动了15个线程，
他们共享了同一个map，15个线程都往map写对象，这势必引起线程安全问题。*/

public  class T1 implements Runnable {
    private final static Map<Integer, Integer> map = new HashMap<>();
    int id;

    T1(int id) {
        this.id = id;
    }

    public void run() {
// Map map = threadLocal.get();
        for (int i = 0; i < 20; i++) {
            map.put(i, i + id * 100);
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
            }
        }

        System.out.println(Thread.currentThread().getName()
                + "# map.size()=" + map.size() + " # " + map);
    }

    public static void main(String[] args) {
        Thread[] runs = new Thread[15];
        T1 t = new T1(1);
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(t);
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }
}