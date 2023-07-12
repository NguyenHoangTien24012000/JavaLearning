package ThreadJava;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
                System.out.println("Thread3 - " + i);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
