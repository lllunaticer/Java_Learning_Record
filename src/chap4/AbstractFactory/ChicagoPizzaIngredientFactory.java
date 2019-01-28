package chap4.AbstractFactory;

import chap4.AbstractFactory.Ingredient.Cheese.Cheese;
import chap4.AbstractFactory.Ingredient.Cheese.Mozzarella;
import chap4.AbstractFactory.Ingredient.Clams.Clams;
import chap4.AbstractFactory.Ingredient.Clams.FreshClams;
import chap4.AbstractFactory.Ingredient.Dough.Dough;
import chap4.AbstractFactory.Ingredient.Dough.ThinCrustDough;
import chap4.AbstractFactory.Ingredient.Pepperoni.Pepperoni;
import chap4.AbstractFactory.Ingredient.Pepperoni.SlicedPepperoni;
import chap4.AbstractFactory.Ingredient.Sauce.PlumTomatoSauce;
import chap4.AbstractFactory.Ingredient.Sauce.Sauce;
import chap4.AbstractFactory.Ingredient.Veggies.BlackOlives;
import chap4.AbstractFactory.Ingredient.Veggies.EggPlant;
import chap4.AbstractFactory.Ingredient.Veggies.Spinach;
import chap4.AbstractFactory.Ingredient.Veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new BlackOlives(),new Spinach(),new EggPlant()};
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
