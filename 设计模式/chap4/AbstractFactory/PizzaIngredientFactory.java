package chap4.AbstractFactory;

import chap4.AbstractFactory.Ingredient.Cheese.*;
import chap4.AbstractFactory.Ingredient.Clams.*;
import chap4.AbstractFactory.Ingredient.Dough.*;
import chap4.AbstractFactory.Ingredient.Pepperoni.*;
import chap4.AbstractFactory.Ingredient.Sauce.*;
import chap4.AbstractFactory.Ingredient.Veggies.*;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClams();
}
