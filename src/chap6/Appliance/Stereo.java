package chap6.Appliance;

public class Stereo {
    String name;

    public Stereo(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("The "+name+" stereo is on！");
    }

    public void setCD() {
        System.out.println("Set CD for the "+name+" stereo! ");
    }

    public void setVolume(int volume) {
        System.out.println("The volume of "+name+" stereo is set with " + volume);
    }

    public void off(){
        System.out.println("The "+name+" stereo is off！");
    }
}
