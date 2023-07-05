package LuyenTapJava.Burger1;

public class Item {
    private String name;
    private String type;
    private double price;
    private String size;

    public Item(String name, String type, double price) {
        this.name = name.toUpperCase();
        this.type = type.toUpperCase();
        this.price = price;
        this.size = "M";
    }
    public void setSize(String size){
        this.size = size;
    }
    public double getBasePrice(){
        return this.price;
    }

    public String getName(){
        if(type.toUpperCase().equals("DRINK")){
            return name + " size: " + size;
        }else {
            return name;
        }
    }

    public double getAdjustPrice(){
        return switch (size){
            case "S" -> getBasePrice() - 2;
            case "L" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public static void printItem(String name, double price){
        System.out.printf("%30s :%d $", name, price);
    }
    public void printItem(){
        printItem(getName(), getAdjustPrice());
    }

}
