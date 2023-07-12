package ThreadJava.ChallengeThread;


import java.util.Random;

public class Thread1 extends Thread{
    private ShareData shareData;

    public Thread1(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        Random random = new Random();
        synchronized (shareData){
            while (shareData.checkTotal()){
                int number = random.nextInt(100) + 1;
                System.out.println("Thread-1 number: " + number);
                shareData.setNumberRandom(number);
                shareData.increaseTotal();
                System.out.println("Total: " + shareData.getTotal());

                shareData.notifyAll();
                try {
                    shareData.wait();
                }catch (InterruptedException e){
                    System.out.println(e);
                }

            }
        }
    }
}
