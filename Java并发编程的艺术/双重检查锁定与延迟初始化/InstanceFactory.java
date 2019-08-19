package 双重检查锁定与延迟初始化;
/*JVM在类的初始化阶段（即在class被加载后，且被线程使用之前），会执行类的初始化。
* 在执行类的初始化期间，JVM会取获取一个锁。这个锁可以同步多个线程对同一个类的初始化。*/
public class InstanceFactory {
    private static class InstanceHolder{
        public static InstanceFactory instance = new InstanceFactory();
    }

    public static InstanceFactory getInstance(){
        return InstanceHolder.instance;
    }
}
