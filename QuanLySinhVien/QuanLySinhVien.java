package QuanLySinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySinhVien{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Student> sinhVienList = new ArrayList<>();
        sinhVienList.add(new Student("ten", "dia chi", "20/10/2004", 1, "Truong", 2004));
        System.out.println(sinhVienList);
        printMenu();
        startProgram(sinhVienList);
    }
    public static void startProgram(List<Student> studentList){
        boolean flag = true;
        while (flag){
            printMenu();
            byte option;
            try {
                option = scanner.nextByte();
                System.out.println(option);
                switch (option){
                    case 1 -> printStudentList(studentList);
                    case 0 -> {
                        flag = false;
                        System.out.println("Hen gap lai");
                    }
                    default -> System.out.println("Vui long nhap lai");
                }

            } catch (Exception e) {
                scanner.next();
                System.out.println("Vui long nhap lai");
                continue;
            }

        }
    }


    public static void printMenu(){
        System.out.println("""
                Chuong trinh quan ly sinh vien: 
                1. Danh sach sinh vien
                2. Them sinh vien
                3. Sua sinh vien
                4. Xoa sinh vien
                5. Menu chuong trinh
                0. Thoat chuong trinh
                Nhap lua chon cua ban: 
                """);
    }
    public static void printStudentList(List<Student> studentList){
        System.out.println(studentList.toString());
    }

}
