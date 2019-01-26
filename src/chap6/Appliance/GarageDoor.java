package chap6.Appliance;

public class GarageDoor {
    String name;

    public GarageDoor(String name) {
        this.name = name;
    }

    public void doorOpen() {
        System.out.println("The "+name+" garage door open!");
    }

    public void doorClose() {
        System.out.println("The "+name+" garage door close!");
    }
}
