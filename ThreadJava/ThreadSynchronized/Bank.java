package ThreadJava.ThreadSynchronized;

public class Bank {
    private int money;
    public Bank(){
    }
    public Bank(int money){
        this.money = money;
    }
//    public void setMoney(int money) {
//        this.money = money;
//    }
    public synchronized void withMoney(String nameThread){
        for (int i = 0; i < 10; i ++){
            System.out.println(nameThread + " " + i);
        }
    }

}
