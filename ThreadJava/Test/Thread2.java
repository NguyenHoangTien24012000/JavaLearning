package ThreadJava.Test;

public class Thread2 extends Thread {
    private Share share;

    public Thread2(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        synchronized (share) {
            int i = 0;
            while (share.check()) {
                share.giam();
                System.out.println("thread2 giam: " + share.getNumber());
                share.notifyAll();
                try {
                    share.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                i++;
                if (i >= 10) {
                    break;
                }

            }
            share.notifyAll();
        }
    }
}
