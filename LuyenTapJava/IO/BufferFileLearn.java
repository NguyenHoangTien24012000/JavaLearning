package LuyenTapJava.IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferFileLearn {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream("test.txt");
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] data = new byte[1024];
            int length = bufferedInputStream.read(data);
            System.out.println("length: " + length);
            String result = new String(data, 0, length);
            System.out.println(result);

        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        }
    }
}
