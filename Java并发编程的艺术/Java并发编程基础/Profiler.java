package Java并发编程基础;
/*ThreadLocal, 即线程变量，是一个以ThreadLocal 对象为键、任意对象为值的存储结构。
* 这个结构被附带在线程上，也就是说一个线程可以根据一个ThreadLocal对象查询到绑定在这个线程上的一个值
* 可以通过set(T)方法来设置一个值，在当前线程下再通过get()方法获取原先设置的值
*
* Profile可以被复用在方法调用耗时统计的功能上，在方法的入口执行begin方法，在方法调用后执行end方法，好处是
* 两个方法的调用不必在同一个方法或者类中
* 比如在面向切面编程AOP中，可以在方法调用前的切入点执行begin方法，在方法调用后的切入点执行end方法，这样
* 依旧可以获得方法的执行耗时*/
import java.util.concurrent.TimeUnit;

public class Profiler {
    //第一次get()方法调用时会进行初始化(如果set方法没有调用)，每个线程会调用一次。
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception{
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}
