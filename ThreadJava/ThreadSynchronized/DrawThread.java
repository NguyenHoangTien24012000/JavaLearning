package ThreadJava.ThreadSynchronized;

public class DrawThread extends Thread{
    Bank bank;
    String name;

    public DrawThread(Bank bank, String name) {
        this.bank = bank;
        this.name = name;
    }

    @Override
    public void run() {
        bank.withMoney(name);
    }
}
