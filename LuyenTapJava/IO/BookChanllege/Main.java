package LuyenTapJava.IO.BookChanllege;

import java.io.*;
import java.util.*;

public class Main {
    public static List<Book> bookList;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        bookList = new ArrayList<>();
        int chose;
        do{
            showMenu();
            chose = scanner.nextInt();
            switch (chose){
                case 1->addBook();
                case 2-> System.out.println(bookList.toString());
                case 3-> sortListBook();
                case 4-> storeDataObj();
                case 5-> storeDataText();
                case 6-> readDataObj();
                case 7 -> readDataText();
                case 8-> System.out.println("Bye bye!!!");
                default -> System.out.println("Vui long nhap lai");
            }
        }while (chose != 7);
        scanner.close();
    }
    public static void showMenu(){
        System.out.println("1. Them sach");
        System.out.println("2. Hien thi thong tin");
        System.out.println("3. Sap xep theo ten tac gia");
        System.out.println("4. Luu data data.obj");
        System.out.println("5. Luu data data.txt");
        System.out.println("6. Doc data data.obj");
        System.out.println("7. Doc data data.txt");
        System.out.println("8. Thoat");
    }
    public static void addBook(){
        System.out.println("Nhap so luong sach");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++){
            System.out.println("Thong tin sach thu: " + i);
            Book book = new Book();
            book.enterInfoBook();
            bookList.add(book);
            System.out.println("Them thanh cong");
        }
    }
    public static void sortListBook(){
        Comparator<Book> sort = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthName().compareTo(o2.getAuthName());
            }
        };
        Collections.sort(bookList, sort);
        System.out.println(bookList.toString());
    }
    public static void checkFileText(){
        File file = new File("book.txt");
        if(file.exists()){
            System.out.println("File exist!!");
        }else {
            System.out.println("File not exits!!");
            try {
                file.createNewFile();
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
    public static void checkFileObj(){
        File file = new File("book.ser");
        if(file.exists()){
            System.out.println("File exist!!");
        }else {
            System.out.println("File not exist");
            try {
                file.createNewFile();
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
    public static void storeDataObj(){
        checkFileObj();
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("book.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(bookList);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }finally {
            if(fos!= null){
                try {
                    fos.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
            if(oos != null){
                try {
                    oos.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        }
    }
    public static void storeDataText(){
        checkFileText();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("book.txt");
            for (Book book : bookList){
                String dataBook = book.toString() + "\n";
                byte[] dataStore = dataBook.getBytes();
                fos.write(dataStore);
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }finally {
            if (fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        }

    }
    public static void readDataObj(){
        checkFileObj();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("book.ser");
            ois = new ObjectInputStream(fis);
            List<Book> bookList1 = (List<Book>) ois.readObject();
            System.out.println("Read file obj");
            bookList1.forEach(b -> System.out.println(b.toString()));
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
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
    public static void readDataText(){
        checkFileText();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("book.txt");
            int code;
            while ((code = fis.read()) != -1){
                System.out.print((char) code);
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }finally {
            if(fis != null){
                try{
                    fis.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        }
    }

}
