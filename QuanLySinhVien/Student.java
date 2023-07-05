package QuanLySinhVien;

import java.text.SimpleDateFormat;

public class Student extends Person{
    private int idStudent;
    private String nameSchool;

    private int yearStart;
    public Student(String name, String address, String yearOfBirth, int idStudent, String nameSchool, int yearStart) {
        super(name, address, yearOfBirth);
        this.idStudent = idStudent;
        this.nameSchool = nameSchool;
        this.yearStart = yearStart;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public int getYearStart() {
        return yearStart;
    }

    @Override
    public String toString() {
        String pattern = "dd/mm/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(dateOfBirth);
        return "id: %d, name: %s, address: %s, Date of birth: %s, idStudent: %s, School: %s, Year start: %s".formatted(id, nameSchool, address, date, idStudent, nameSchool, yearStart);
    }

}
