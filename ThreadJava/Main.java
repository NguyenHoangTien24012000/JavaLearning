package ThreadJava;

public class Main {
    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Sleep: " + i);
//            try {
//                Thread.sleep(2000);
//            }catch (Exception e){
//                System.out.println(e);
//            }
//        }
//        System.out.println("Success");
        MyThread myThread = new MyThread();
        myThread.run();
        System.out.println(myThread.isAlive());
    }
}
