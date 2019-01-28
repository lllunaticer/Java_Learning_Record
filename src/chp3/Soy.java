package chp3;


public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDiscription() {
        return beverage.getDiscription()+", Soy";
    }
    public double cost(){
        return .15+beverage.cost();
    }
}
