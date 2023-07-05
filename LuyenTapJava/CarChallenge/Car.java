package LuyenTapJava.CarChallenge;

public class Car {
    private String description;

    public Car(String description){
        this.description = description;
    }

    public void startEngine(){
        System.out.println("Car -> Start Engine");
    }
    protected void runEngine(){
        System.out.println("Car -> Run Engine");
    }
    public void drive(){
        System.out.println("Car -> driving, type is " + getClass().getSimpleName());
        runEngine();
    }
}
