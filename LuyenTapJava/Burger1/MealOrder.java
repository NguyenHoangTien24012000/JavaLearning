package LuyenTapJava.Burger1;

public class MealOrder {
    private Item side;
    private Burger burger;
    private Item drink;

    public MealOrder(String side, String burger, String drink) {
        this.side = new Item(side, "Side", 3);
        this.drink = new Item(drink, "DRINK", 2);
        this.burger = new Burger(burger, 8);
    }

    public void setSize(String size){
        drink.setSize(size);
    }
    public void addExtraBurger(String topping1, String topping2, String topping3){
        burger.addExtraTopping(topping1,topping2,topping3);
    }
    public double getTotalPrice(){
        return side.getAdjustPrice() + drink.getAdjustPrice() + burger.getAdjustPrice();
    }

    public void printListMenu(){
        System.out.println("Meal Bill");
        burger.printListExtra();
        drink.printItem();
        side.printItem();
        System.out.println("-".repeat(30));
        System.out.printf("%30s: %d", "Total", getTotalPrice());
    }

}
