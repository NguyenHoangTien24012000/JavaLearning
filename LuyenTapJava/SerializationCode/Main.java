package LuyenTapJava.SerializationCode;

import LuyenTapJava.SerializationTest.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = null;
        FileInputStream fileInputStream = new FileInputStream("test.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        user = (User) objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();
        System.out.println("Success read!");
        user.sayHello();
    }
}
