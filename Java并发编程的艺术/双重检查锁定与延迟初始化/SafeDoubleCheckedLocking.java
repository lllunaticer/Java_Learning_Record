package 双重检查锁定与延迟初始化;
//基于前面的双重检查锁定来实现延迟初始化的方案，只需要做一点小的修改（将instance声明为volatile类型），就可以实现线程安全的
//延迟初始化
public class SafeDoubleCheckedLocking {
    private volatile static SafeDoubleCheckedLocking instance;

    public static SafeDoubleCheckedLocking getInstance(){
        if(instance==null){
            synchronized (SafeDoubleCheckedLocking.class){
                if(instance == null)
                    instance = new SafeDoubleCheckedLocking();//instance为volatile,禁止了volatile变量的指令重排序，现在没有问题了。
            }
        }
        return instance;
    }
}
