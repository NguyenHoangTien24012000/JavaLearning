package ThreadJava.ChallengeStudent;

import java.util.ArrayList;
import java.util.List;

public class ListStudent <E extends Student>{
    private ArrayList<E> list;

    public ListStudent(ArrayList<E> list) {
        this.list = list;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(ArrayList<E> list) {
        this.list = list;
    }
}
