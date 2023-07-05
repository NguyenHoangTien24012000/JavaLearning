package ThreadJava;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread run " + this.getName());
    }
}
