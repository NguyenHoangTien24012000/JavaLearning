package LuyenTapJava.IO.ChallengeStudent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        FileWriter fileWriter = null;
//        BufferedWriter fos = null;
//        try {
//            fileWriter = new FileWriter("test.txt");
//
//            fos = new BufferedWriter(fileWriter);
//            for (Student student : studentList){
//                String line = student.getInfo();
////                byte[] bytes = line.getBytes();
//
//                fos.write(line);
//                fos.newLine();
//            }
//
//        }catch (FileNotFoundException e){
//            System.out.println(e);
//        }catch (IOException e){
//            System.out.println(e);
//        } finally {
//            if(fos != null){
//                try {
//                    fos.close();
//                }catch (IOException e){
//                    System.out.println(e);
//                }
//            }
//            if(fileWriter !=null){
//                try {
//                    fileWriter.close();
//                }catch (IOException e){
//                    System.out.println(e);
//                }
//            }
//        }
        saveFile();
        readFile();
    }
    public static void saveFile(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Tien", "Nam Dinh"));
        studentList.add(new Student("Son", "Nam Dinh"));
        studentList.add(new Student("Thuong", "Ha Noi"));
        File file  = new File("student.ser");
        if(file.exists()){
            System.out.println("Ready");
        }else {
            try {
                file.createNewFile();
            }catch (IOException e){
                System.out.println(e);
            }
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("student.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }finally {
            if(fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        }
    }
    public static void readFile(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("student.ser");
            ois = new ObjectInputStream(fis);
            List<Student> studentList = (List<Student>) ois.readObject();
            studentList.forEach(student -> System.out.println(student.getInfo()));
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }finally {
            if(fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
            if(ois != null){
                try {
                    ois.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        }
    }
}
