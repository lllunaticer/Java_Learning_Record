package chap4.Factorymode;

public class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza(){
        name = "Chicago Style Deep Dish and Veggie Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Veggie");
        toppings.add("fish");
    }

    void cut(){
        System.out.println("Cutting the pizza into square slices");
    }
}
