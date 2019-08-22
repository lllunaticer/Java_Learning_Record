package 线程应用实例;

public class 等待超时模式 {
    /*使用场景：
    * 调用一个方法时等待一段时间，如果方法能够在给定的时间段之内得到结果，那么将结果立即返回，反之，超时返回默认结果
    * 等待/通知的经典范式 加锁-条件循环-逻辑处理 无法做到超时等待。
    * 可对经典范式做如下改动做到超时等待：
    * 假设超时时间段是T，那么可以推断出在当前时间now+T之后就会超时
    * 定义：
    * 等待持续时间： REMAINING = T
    * 超时时间： FUTURE = now + T
    * 这时仅需要wait(REMAINING)即可，在wait(REMAINING)返回后将执行：
    * REMAINING = FUTURE - now。如果REMAING小于等于0，表示已经超时，直接退出
    * 否则继续wait(REMAINING)*/
    //以下时伪代码
    //对当前对象加锁
    public synchronized Object get(long millis) throws InterruptedException{
        long future = System.currentTimeMillis() + millis;
        long remaining = millis;
        Object result;
        result = new Object();
        //当超时大于0并且result返回至不满足要求
        while((result == null) &&remaining >0){
            waittime(remaining);
            remaining = future - System.currentTimeMillis();
        }
        return result;
    }

    public void waittime(long time){
    }
}
