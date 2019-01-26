package chap6.Appliance;

public class CeillingFan {
    String name;

    public CeillingFan(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println("The "+name+" Fan is on!");
    }

    public void off(){
        System.out.println("The "+name+" Fan is off!");
    }
}
