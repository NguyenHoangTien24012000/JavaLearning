package ThreadJava.ChallengeStudent;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student a = new Student("Name A", "Address A");
        Student b = new Student("Name B", "Address B");
        Student c = new Student("Name C", "Address C");
        Student d = new Student("Name D", "Address D");
        Student e = new Student("Name E", "Address E");
        Student f = new Student("Name F", "Address F");
        ArrayList<Student> students = new ArrayList<>(List.of(a,b,c,d,e,f));
        ListStudent listStudent = new ListStudent<>(students);
        StudentName studentName = new StudentName(listStudent);
        StudentAddress studentAddress = new StudentAddress(listStudent);
        studentAddress.start();
        studentName.start();
    }
}
