package ThreadJava.Test;

public class Thread1 extends Thread{
    private Share share;

    public Thread1(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        synchronized (share){
            int i =0;
            while (share.check()){
                share.tang();
                System.out.println("Thread1 tang: " + share.getNumber());
                share.notifyAll();
                try {
                    share.wait();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
                i++;
                if(i >=10){
                    break;
                }
            }
            share.notifyAll();
        }
    }
}
