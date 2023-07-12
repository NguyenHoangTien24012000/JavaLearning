package ThreadJava.ChallengeThread;

public class Main {
    public static void main(String[] args) {



        ShareData shareData = new ShareData();
        Thread1 thread1 = new Thread1(shareData);
        Thread2 thread2 = new Thread2(shareData);
        Thread3 thread3 = new Thread3(shareData);
        thread1.start();
        thread2.start();
        thread3.start();

    }

}
