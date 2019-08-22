package 线程应用实例.数据库连接池;

public interface Connection {
    public abstract void createStatement();
    public abstract void commit();
}
