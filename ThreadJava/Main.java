package ThreadJava;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(1000);
                        System.out.println("Thread1 - " + i);
                    }catch (InterruptedException e){
                        System.out.println(e);
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(1000);
                        System.out.println("Thread2 - " + i);
                    }catch (InterruptedException e){
                        System.out.println(e);
                    }
                }
            }
        });
        MyThread thread3 = new MyThread();
        thread3.start();
        thread1.start();
        thread2.start();
        for (int i = 0; i < 15; i++){
            try {
                Thread.sleep(1000);
                System.out.println("Main thread -- " + i );
                System.out.println("thread1--" + thread1.isAlive());
                System.out.println("thread2--" + thread2.isAlive());
                System.out.println("thread3--" + thread3.isAlive());
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
