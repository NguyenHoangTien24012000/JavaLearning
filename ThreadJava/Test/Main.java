package ThreadJava.Test;

public class Main {
    public static void main(String[] args) {
        Share share = new Share();
        Thread1 thread1 = new Thread1(share);
        Thread2 thread2 = new Thread2(share);
        thread1.start();
        thread2.start();
    }
}
