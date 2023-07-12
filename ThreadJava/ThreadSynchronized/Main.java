package ThreadJava.ThreadSynchronized;

public class Main {
    public static void main(String[] args) {
        //
//        Bank bank = new Bank(1000);
//        List<DrawThread> list = new ArrayList<>();
//        for (int i = 0; i <= 10; i++){
//            list.add(new DrawThread(bank, "thead" + i));
//        }
//        for (DrawThread drawThread : list){
//            drawThread.start();
//        }
        ShareData shareData = new ShareData();
        ThreadRandom threadRandom = new ThreadRandom(shareData);
        ThreadSquare threadSquare = new ThreadSquare(shareData);
        threadRandom.start();
        threadSquare.start();
    }
}
