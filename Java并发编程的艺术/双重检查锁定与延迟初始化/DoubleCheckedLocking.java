package 双重检查锁定与延迟初始化;
//使用双重检查锁定来降低同步开销，但是这个做法是一个错误的优化！
/*在A线程位于同步代码块2处，初始化对象（但还未初始化完成的时候），有可能有另外的线程B运行到1处。
* 此时instance检查不为null，但instance返回的却不是一个完整的对象。
*
* 为什么instance没有被A真正初始化的时候，其指向不为null呢。原因在于编译器的指令重排序。
* 创建一个对象的过程可由如下三步伪代码表示
* 1.memory = allocate()  //分配对象的内存空间
* 2.ctorInstance(memory) //初始化对象
* 3.instance = memory //设置instance指向分配的内存地址
*
* 上面的创建对象的过程是在一个单线程中完成的, JMM保证了重排序不会改变单线程内的程序执行结果。换句话说
* ，JAVA允许那些在单线程内，不会改变单线程程序执行结果对的指令重排序。上述三个步骤在一些JIT编译器上被单线程
* 执行的时候，为了提高程序的执行性能，有可能会被重排序且不影响单线程下的执行结果：
 * 1.memory = allocate()  //分配对象的内存空间
 * 2.instance = memory //设置instance指向分配的内存地址
 * 3.ctorInstance(memory) //初始化对象
* 这样，instance 在单线程内会先被指向内存分配地址（此时检查instance不为null），而后这个地址内才真正存放初始化完成的对象数据。
* 这样线程A执行到步骤2，将instance指向内存地址以至于对instance作检查不为null的时候（但实际上该地址内没有初始化完成的对象数据）,
* 线程B运行到了程序的1处，对instance作了不为null的检查后,直接返回了这个“虚有其表”的instance。后续程序如果用到了这个对象，必然
* 导致程序的错误。
* */

public class DoubleCheckedLocking {
    private static DoubleCheckedLocking instance;

    public static DoubleCheckedLocking getInstance(){
        if(instance == null){//1处
            synchronized(DoubleCheckedLocking.class){
                if(instance == null)
                    instance = new DoubleCheckedLocking();//2处
            }
        }
        return instance;
    }
}
