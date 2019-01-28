package chap6.Appliance;

public class CeillingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String name;
    int speed;

    public CeillingFan(String name) {
        this.name = name;
        speed = OFF;
    }

    public void on(){
        speed = LOW;
        System.out.println("The "+name+" Fan is on speed @ "+speed);
    }

    public void off(){
        System.out.println("The "+name+" Fan is off!");
    }

    public void high(){
        speed = HIGH;
        System.out.println("The "+name+" Fan is on speed@ "+speed);
    }

    public void medium(){
        speed = MEDIUM;
        System.out.println("The "+name+" Fan is on speed @ "+speed);
    }

    public void low(){
        speed = LOW;
        System.out.println("The "+name+" Fan is on speed@ "+speed);
    }

    public int getSpeed() {
        return speed;
    }
}
