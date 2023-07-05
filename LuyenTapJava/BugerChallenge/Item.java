package LuyenTapJava.BugerChallenge;

public class Item {
    private String name;
    private String type;
    private String size;
    private double price;

    public Item(String name, String type, double price) {
        this.name = name.toUpperCase();
        this.type = type.toUpperCase();
        this.size = "M";
        this.price = price;
    }

    public String getName(){
        if(type.equals("DRINK")){
            return name + " size: " + size;
        }else {
            return name;
        }
    }

    public double getBasePrice(){
        return this.price;
    }

    public double getAdjustedPrice(){
        return switch (size){
            case "S" -> getBasePrice() - 2;
            case "L" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public void setSize(String size){
        this.size = size.toUpperCase();
    }

    public static void printItem(String name, double price){
        System.out.printf("%20s:%6.2f%n", name, price);
    }

    public void printItem(){
        printItem(getName(), getAdjustedPrice());
    }
}
