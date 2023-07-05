package LuyenTapJava.SerializationTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.name = "thuong";
        user.password = "20/10/2004";
        FileOutputStream fileOutputStream = new FileOutputStream("test.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Save success!");
    }
}
