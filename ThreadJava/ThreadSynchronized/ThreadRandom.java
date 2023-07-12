package ThreadJava.ThreadSynchronized;

import java.util.Random;

public class ThreadRandom extends Thread {
    ShareData shareData;

    public ThreadRandom(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        Random random = new Random();
        synchronized (shareData) {
            for (int i = 0; i < 10; i++) {
                int rad = random.nextInt(100) + 1;
                shareData.setRad(rad);
                System.out.println("RanDom: " + i + " " + rad);
                shareData.notifyAll();
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
