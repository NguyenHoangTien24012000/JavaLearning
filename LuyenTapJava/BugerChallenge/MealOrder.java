package LuyenTapJava.BugerChallenge;

public class MealOrder {
    private Item side;
    private Item drink;
    private Burger burger;

    public MealOrder(String sideType, String drinkType, String burgerType) {
        this.side = new Item(sideType, "Side", 3);
        this.drink = new Item(drinkType, "drink", 2);
        this.burger = new Burger(burgerType, 5);
    }

    public void setDrinkSize(String size){
        drink.setSize(size);
    }

    public void addTopping(String topping1, String topping2, String topping3){
        burger.addToppings(topping1, topping2, topping3);

    }

    public double getTotalPrice(){
        return drink.getAdjustedPrice() + side.getAdjustedPrice() + burger.getAdjustedPrice();
    }

    public void printItemizedList(){
        burger.printItemList();
        drink.printItem();
        side.printItem();
        System.out.println("-".repeat(40));
        Item.printItem("Total price", getTotalPrice());
    }
}
