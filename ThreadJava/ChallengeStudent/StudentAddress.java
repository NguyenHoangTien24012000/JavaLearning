package ThreadJava.ChallengeStudent;

public class StudentAddress extends Thread {
    ListStudent<Student> listStudent;

    public StudentAddress(ListStudent<Student> listStudent) {
        this.listStudent = listStudent;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            System.out.println(e);
//        }
        synchronized (listStudent) {
            for (int i = 0; i < 5; i++) {
                try {
                    listStudent.notifyAll();
                    listStudent.wait();
                    Student student = listStudent.getList().get(i);
                    System.out.println(student.getAddress() + " - " + i);

                }catch (InterruptedException e){
                    System.out.println(e);
                }

            }
            listStudent.notifyAll();
        }
    }
}
