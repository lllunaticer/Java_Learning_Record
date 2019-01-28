package chp3;

public class Milk extends CondimentDecorator {
    Beverage beverage;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDiscription() {
        return beverage.getDiscription()+", Milk";
    }
    public double cost(){
        return .10+beverage.cost();
    }
}