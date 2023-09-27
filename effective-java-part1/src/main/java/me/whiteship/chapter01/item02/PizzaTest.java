package me.whiteship.chapter01.item02;

import static me.whiteship.chapter01.item02.NyPizza.Size.SMALL;
import static me.whiteship.chapter01.item02.Pizza.Topping.*;

public class PizzaTest {
    public static void main(String[] args) {
//        NyPizza pizza = new NyPizza.Builder(SMALL)
//                .addTopping(SAUSAGE)
//                .addTopping(ONION).build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

//        System.out.println(pizza);
        System.out.println(calzone);
    }
}
