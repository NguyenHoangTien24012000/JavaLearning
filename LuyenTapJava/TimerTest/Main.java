package LuyenTapJava.TimerTest;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task is complete: !!");
            }
        };
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2023);
        date.set(Calendar.MONTH, Calendar.JUNE);
        date.set(Calendar.DAY_OF_MONTH, 27);
        date.set(Calendar.HOUR, 11);
        date.set(Calendar.MINUTE, 10);
        date.set(Calendar.SECOND, 0);
//        date.set(Calendar)
//        timer.schedule(timerTask, date.getTime());

        TimerTask newTask = new TimerTask() {
            int count = 10;
            @Override
            public void run() {

                if (count > 0) {
                    System.out.println(count + " seconds");
                    count --;
                }else{
                    System.out.println("Ending!!!");
                    timer.cancel();
                }
            }
        };
        timer.schedule(newTask, 3000, 1000);
    }
}
