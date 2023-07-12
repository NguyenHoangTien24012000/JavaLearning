package LuyenTapJava.TimerTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateTest {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        Date date = new Date();
        String dateFormat = simpleDateFormat.format(date);
        System.out.println(dateFormat);

    }
}
