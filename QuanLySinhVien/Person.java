package QuanLySinhVien;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    static int currentId;
    protected int id;
    protected String name;
    protected String address;
    protected Date dateOfBirth;

    public Person(String name, String address, String dateOfBirth){
        this.id = currentId ++;
        this.name = name;
        this.address = address;
        setDateOfBirth(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        try {
            Date date = dateFormat.parse(dateOfBirth); // Chuyển đổi chuỗi thành đối tượng Date
            this.dateOfBirth = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

}
