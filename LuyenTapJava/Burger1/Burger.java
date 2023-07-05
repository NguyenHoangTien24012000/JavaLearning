package LuyenTapJava.Burger1;

public class Burger extends Item{
    private Item extra1;
    private Item extra2;
    private Item extra3;
    public Burger(String name, double price) {
        super(name, "BURGER", price);
    }

    @Override
    public String getName() {
        return super.getName() + " Burger";
    }

    public double getExtraPrice(String topping){
        return switch (topping){
            case "SUGAR" -> 1;
            case "CHEESE" -> 1.5;
            case "MILK" -> 2.0;
            default -> 0;
        };
    }
    public void addExtraTopping(String topping1, String topping2, String topping3){
        this.extra1 = new Item(topping1, "Topping", getExtraPrice(topping1));
        this.extra2 = new Item(topping2, "Topping", getExtraPrice(topping2));
        this.extra3 = new Item(topping3, "Topping", getExtraPrice(topping3));
    }

    @Override
    public double getAdjustPrice() {
        return (extra1 == null ? extra1.getBasePrice() : 0) +
                (extra2 == null ? extra2.getBasePrice() : 0) +
                (extra3 == null ? extra3.getBasePrice() : 0);
    }
    public void printListExtra(){
        if(extra1 != null){
            extra1.printItem();
        }
        if (extra2 != null){
            extra2.printItem();
        }
        if(extra3 != null){
            extra3.printItem();
        }
    }

    @Override
    public void printItem() {
        printListExtra();
        System.out.println("-".repeat(30));
        super.printItem();
    }
}
