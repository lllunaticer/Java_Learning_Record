package chp3;

public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDiscription() {
        return beverage.description+", Whip";
    }
    public double cost(){
        return .10+beverage.cost();
    }
}
