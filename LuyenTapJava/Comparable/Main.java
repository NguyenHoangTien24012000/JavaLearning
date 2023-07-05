package LuyenTapJava.Comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student(100, "tien");
        Student student2 = new Student(90, "thuong");
        Student student3 = new Student(95, "nam");
        studentList.addAll(List.of(student1, student2, student3));
        System.out.println(studentList);
        List<StudentChildren> studentChildren = new ArrayList<>(List.of(new StudentChildren(100, "Tien"), new StudentChildren(90, "Nha")));
        printStudent(studentList);
        printStudent(studentChildren);
        LinkedList<String> stringList = new LinkedList<>(List.of("ST", "sta"));
//        printStudent(stringList);
//        String test = stringList;
//        Person<Student> studentPerson = new Student(100, "Tien");
        Collection<Student> students = new ArrayList<>();
    }

    public static <T extends Student> void printStudent(List<T> studentList){
        for (var student : studentList){
            student.toString();
        }
    }
}
