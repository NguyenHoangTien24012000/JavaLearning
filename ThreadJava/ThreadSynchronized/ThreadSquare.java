package ThreadJava.ThreadSynchronized;

import java.util.Random;

public class ThreadSquare extends Thread {
    ShareData shareData;

    public ThreadSquare(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        Random random = new Random();
        synchronized (shareData) {
            for (int i = 0; i < 10; i++) {
                shareData.notifyAll();
                int rad = shareData.getRad();
                rad *= rad;
                System.out.println("Binh phuong: " + i + " " + rad);
                try {
                    shareData.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            shareData.notifyAll();
        }
    }
}
