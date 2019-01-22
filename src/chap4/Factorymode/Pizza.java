package chap4.Factorymode;

import java.util.ArrayList;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    void prepare(){
        System.out.println("Preparing "+name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");
        for(int i = 0; i < toppings.size();i++){
            System.out.println(" " + toppings.get(i));
        }
    }

    void bake(){
        System.out.println("Bake for 25 minutes @ 350");
    }

    void cut(){
        System.out.println("cutting the pizza into diagonal slices");
    }

    void box(){
        System.out.println("place pizza in official Pizza box");
    }

    public String getName(){
        return name;
    }
}
