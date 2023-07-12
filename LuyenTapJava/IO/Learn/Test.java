package LuyenTapJava.IO.Learn;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        File file = new File("src/LuyenTapJava/IO/Learn/test.txt");
//        if(file.exists()){
//            System.out.println("co ton tai");
//            file.delete();
//        }else {
//            System.out.println("ko");
//            try {
//                file.createNewFile();
//            }catch (IOException e){
//                System.out.println(e);
//            }
//        }
//        FileOutputStream fos = null;
//        String fileName = "test.txt";
//        try {
//            fos = new FileOutputStream(fileName);
//            String content = "Test noi dung";
//            byte[] data;
//            try {
//                data = content.getBytes("utf8");
//                fos.write(data);
//            }catch (UnsupportedEncodingException e){
//                System.out.println(e);
//            }catch (IOException e){
//                System.out.println(e);
//            }
//        }catch (FileNotFoundException e){
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, e);
//        }finally {
//            if(fos != null){
//                try {
//                    fos.close();
//                }catch (IOException e){
//                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, e);
//                }
//            }
//        }

//        String fileName = "test.txt";
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(fileName);
//            int code;
//            StringBuilder stringBuilder = new StringBuilder();
//            while ((code = fis.read()) != -1){
//                char c = (char) code;
////                System.out.print(c + "(" + code + ")" + " ");
//                stringBuilder.append(c);
//            }
//            System.out.println(stringBuilder.toString());
//        }catch (FileNotFoundException e){
//            System.out.println(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if(fis != null){
//                try {
//                    fis.close();
//                }catch (IOException e){
//                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, e);
//                }
//            }
//        }

        File file = new File("test.txt");
        if(file.exists()){
            System.out.println("Ready");
        }else {
            try {
                file.createNewFile();
            }catch (IOException e){
                System.out.println(e);
            }
            System.out.println("File not found!!");
        }
        //insert data
        Scanner scanner = new Scanner(System.in);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("test.txt");
            while (true){
                System.out.println("Nhap lua chon: \n1: Them text \t2: Dung lai");
                int chose = scanner.nextInt();
                scanner.nextLine();
                if (chose == 1){
                    System.out.println("nhap text: ");
                    String str = scanner.nextLine() + "\n";
                    try {
                        byte[] data = str.getBytes();
                        fos.write(data);
                    }catch (UnsupportedEncodingException e){
                        System.out.println(e);
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }else {
                    System.out.println("Bye bye");
                    break;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }finally {
            if(fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
            scanner.close();
        }

        FileReader fis = null;
        BufferedReader bufferedReader = null;
        try {
            fis = new FileReader("test.txt");
            bufferedReader = new BufferedReader(fis);

            String line;
//            System.out.println(line);
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }finally {
            try {
                fis.close();
            }catch (IOException e){
                System.out.println(e);
            }
            try {
                bufferedReader.close();
            }catch (IOException e){
                System.out.println(e);
            }
        }
        //FileOutputStream FileInPutStream danh cho viec doc ghi du lieu Text/Binary
        //FileReader vs FileWrite chi danh cho viec doc text


    }
}
