package ThreadJava.ChallengeThread;

public class Thread3 extends Thread{
    private ShareData shareData;

    public Thread3(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        synchronized (shareData){
            while (shareData.checkTotal()){

                int number = shareData.getNumberRandom();
                if(number % 2 == 0){
                    System.out.println("Thread-3 so chia het cho 2: " + number);
                    if(number % 4 == 0){
                        System.out.println("Thread-3 " + shareData.getTotal() +" so chia het cho ca 4");
                    }
                }
                shareData.notifyAll();
                try {
                    shareData.wait();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
            shareData.notifyAll();
        }
    }
}
