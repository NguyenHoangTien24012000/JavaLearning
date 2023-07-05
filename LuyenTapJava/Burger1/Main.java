package LuyenTapJava.Burger1;

import LuyenTapJava.BugerChallenge.Burger;
import LuyenTapJava.BugerChallenge.MealOrder;

public class Main {
    public static void main(String[] args) {
        Burger burger = new Burger("Hamburger", 10);
        burger.addToppings("cream", "sugar", "milk");
//        burger.printItem();

        MealOrder mealOrder =new MealOrder("Cake", "Pessi", "Hamburger");
        mealOrder.addTopping("cream", "sugar", "milk");
        mealOrder.printItemizedList();
    }
}
