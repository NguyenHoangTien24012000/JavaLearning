package LuyenTapJava.IO;

import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class NenFileGiaiNenFile {
    public static void main(String[] args) {
        String str = "Phần 5 | Đọc ghi file FileInputStream, FileOutputStream, ObjectInputStream | Khóa học Java nâng cao " +
                "Phần 5 | Đọc ghi file FileInputStream, FileOutputStream, ObjectInputStream | Khóa học Java nâng cao" +
                "Phần 5 | Đọc ghi file FileInputStream, FileOutputStream, ObjectInputStream | Khóa học Java nâng cao" +
                "Phần 5 | Đọc ghi file FileInputStream, FileOutputStream, ObjectInputStream | Khóa học Java nâng cao" +
                "Phần 5 | Đọc ghi file FileInputStream, FileOutputStream, ObjectInputStream | Khóa học Java nâng cao" +
                "Phần 5 | Đọc ghi file FileInputStream, FileOutputStream, ObjectInputStream | Khóa học Java nâng cao";
        try {
            byte[] inputObj = str.getBytes("utf8");
            System.out.println("length: " + inputObj.length);
            byte[] outputObj = new byte[100];
            Deflater deflater = new Deflater();
            deflater.setInput(inputObj);
            deflater.finish();
            int compareDataLength = deflater.deflate(outputObj);
            System.out.println("length da nen: " + compareDataLength);
            System.out.println(new String(outputObj, 0 , compareDataLength));
            System.out.println("Gia nen--------------------");
            Inflater inflater = new Inflater();
            inflater.setInput(outputObj,0, compareDataLength);
            byte[] result = new byte[inputObj.length];
            int resultLength = inflater.inflate(result);
            System.out.println("length giai nen: " + resultLength);
            inflater.end();
            System.out.println(new String(result, 0, resultLength));
        }catch (UnsupportedEncodingException e){
            System.out.println(e);
        }catch (DataFormatException e){
            System.out.println(e);
        }


    }
}
