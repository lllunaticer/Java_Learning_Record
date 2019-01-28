package chp3;

public class StarBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage1 = new Espresso();
        beverage1 = new Milk(beverage1);
        beverage1 = new Soy(beverage1);
        System.out.println(beverage1.getDiscription()+" $ "+beverage1.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDiscription()+" & "+beverage2.cost());
    }
}
