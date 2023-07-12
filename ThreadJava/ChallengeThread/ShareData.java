package ThreadJava.ChallengeThread;

public class ShareData {
    private int numberRandom;
    private int total;

    public ShareData() {
        this.total = 0;
    }

    public int getNumberRandom() {
        return numberRandom;
    }

    public void setNumberRandom(int numberRandom) {
        this.numberRandom = numberRandom;
    }

    public synchronized void increaseTotal() {
        this.total = this.total + this.numberRandom;
    }
    public synchronized boolean checkTotal(){
        if(total >= 200){
            return false;
        }
        return true;
    }
    public synchronized int getTotal(){
        return total;
    }
}
