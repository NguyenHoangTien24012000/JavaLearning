package ThreadJava.ChallengeStudent;

public class StudentName extends Thread{
    private ListStudent<Student> listStudent;

    public StudentName(ListStudent<Student> listStudent) {
        this.listStudent = listStudent;
    }

    @Override
    public void run() {
        synchronized (listStudent){
            for (int i = 0; i< 5; i++){
                try {
                    Thread.sleep(1000);
                    Student student = listStudent.getList().get(i);
                    System.out.println(student.getName() + " - " + i);
                    listStudent.notifyAll();
                    listStudent.wait();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
            listStudent.notifyAll();
        }
    }
}
