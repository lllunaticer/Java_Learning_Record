package Java并发编程基础;

public class Synchronied {
    public static void main(String[] args) {
        //对Synchronied Class对象进行加锁
        synchronized (Synchronied.class){
        }
        //静态同步方法，对Synchronied Class对象进行加锁
        m();
    }

    public static synchronized void m(){
    }
}
