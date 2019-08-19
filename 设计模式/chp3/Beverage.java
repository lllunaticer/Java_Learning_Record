package chp3;

public abstract class Beverage {
    String description = "unknown beverage";

    public String getDiscription(){
        return description;
    }
    public abstract double cost();
}
