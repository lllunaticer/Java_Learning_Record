package chap4.AbstractFactory;

import chap4.AbstractFactory.Ingredient.Cheese.Cheese;
import chap4.AbstractFactory.Ingredient.Cheese.ReggianoCheese;
import chap4.AbstractFactory.Ingredient.Clams.Clams;
import chap4.AbstractFactory.Ingredient.Clams.FreshClams;
import chap4.AbstractFactory.Ingredient.Dough.Dough;
import chap4.AbstractFactory.Ingredient.Dough.ThinCrustDough;
import chap4.AbstractFactory.Ingredient.Pepperoni.Pepperoni;
import chap4.AbstractFactory.Ingredient.Pepperoni.SlicedPepperoni;
import chap4.AbstractFactory.Ingredient.Sauce.MarinaraSauce;
import chap4.AbstractFactory.Ingredient.Sauce.Sauce;
import chap4.AbstractFactory.Ingredient.Veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic(),new Onion(),new Mushroom(),new RedPepper()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
