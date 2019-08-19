package 双重检查锁定与延迟初始化;
//线程安全的延迟初始化，由于对getInstance方法做了同步处理，sychronized将导致性能开销
public class SafeLazyInitialization {
    private static SafeLazyInitialization instance;

    public synchronized static SafeLazyInitialization getInstance(){
        if(instance == null)
            instance = new SafeLazyInitialization();
        return instance;
    }
}
