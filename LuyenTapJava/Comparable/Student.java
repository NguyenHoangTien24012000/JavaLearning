package LuyenTapJava.Comparable;

public class Student implements Comparable, Person{
    @Override
    public void dayHoc(String monHoc) {

    }

    private Integer score;
    private String name;

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        return score.compareTo(other.score);
    }
}
