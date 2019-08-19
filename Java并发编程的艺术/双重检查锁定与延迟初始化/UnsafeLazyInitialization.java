package 双重检查锁定与延迟初始化;
//非线程安全的延迟初始化对象
public class UnsafeLazyInitialization {
    private static UnsafeLazyInitialization instance;

    public static UnsafeLazyInitialization getInstance(){
        if(instance == null)
            instance = new UnsafeLazyInitialization();
        return instance;
    }
}
