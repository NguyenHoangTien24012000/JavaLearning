package LuyenTapJava.IO;

import java.io.File;

public class MainIO {
    public static void main(String[] args) {
        File file = new File("test.txt");
        if(file.exists()){
            System.out.println("That file exits!");
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.isFile());
            file.delete();
        }else {
            System.out.println("That file doesn't exits");
        }
    }
}
