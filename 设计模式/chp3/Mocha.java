package chp3;

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDiscription() {
        return beverage.getDiscription()+", Mocha";
    }
    public double cost(){
        return .20+beverage.cost();
    }
}
