package chap6.Appliance;

public class Light {
    String name;

    public Light(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println("The "+name+" light is on!");
    }

    public void off(){
        System.out.println("The "+name+" light is off!");
    }
}
