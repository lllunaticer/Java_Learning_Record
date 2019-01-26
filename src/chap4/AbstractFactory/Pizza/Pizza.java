package chap4.AbstractFactory.Pizza;

import chap4.AbstractFactory.Ingredient.Cheese.Cheese;
import chap4.AbstractFactory.Ingredient.Clams.Clams;
import chap4.AbstractFactory.Ingredient.Dough.Dough;
import chap4.AbstractFactory.Ingredient.Pepperoni.Pepperoni;
import chap4.AbstractFactory.Ingredient.Sauce.Sauce;
import chap4.AbstractFactory.Ingredient.Veggies.Veggies;

import java.util.Arrays;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes @ 350");
    }

    public void cut() {
        System.out.println("cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("place pizza in official Pizza box");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clams=" + clams +
                '}';
    }

    public String getName() {
        return name;
    }
}
