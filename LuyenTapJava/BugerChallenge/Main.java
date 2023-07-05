package LuyenTapJava.BugerChallenge;

public class Main {
    public static void main(String[] args) {
        Item coca = new Item("Coca", "drink", 2);
        coca.setSize("L");
        coca.printItem();

        Burger burger = new Burger("Hamburger", 10);
        burger.addToppings("sugar", "cheese", "milk");
        burger.printItem();

        MealOrder mealOrder = new MealOrder("Side", "Pessi", "Hamburger");

        mealOrder.setDrinkSize("L");
        mealOrder.addTopping("sugar", "cheese", "milk");
        mealOrder.printItemizedList();


    }
}
