package 线程应用实例.数据库连接池;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/*
* java.sql.Connection是一个接口，最终的实现是由数据库驱动提供方来实现，考虑到只是一个示例，我们通过动态代理构造了一个
* Connection, 该Connection的代理实现仅仅是在commit()方法调用时休眠100毫秒*/
public class ConnectionDriver {
    static class ConnectionHandler implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("commit"))
                TimeUnit.MILLISECONDS.sleep(100);
            return null;
        }
    }

    //创建一个Connection的代理，在commit时休眠100毫秒
    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),new Class<?>[]
                {Connection.class}, new ConnectionHandler());
    }
}
