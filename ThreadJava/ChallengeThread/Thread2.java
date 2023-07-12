package ThreadJava.ChallengeThread;

public class Thread2 extends Thread{
    private ShareData shareData;
    public Thread2(ShareData shareData) {
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

                if(shareData.getNumberRandom() % 3 == 0){
                    System.out.println("Thread-2 " +shareData.getNumberRandom()+" chia het cho 3");
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
