package LuyenTapJava.Overrinding;

public class Parent {
    protected void hat(String hat){
        System.out.println("Hat" + hat);
    };
    protected String hat(String hat, String ca){
        System.out.println("ca " + hat + ca);
        return "";
    }

}

class Children extends Parent{
    @Override
    public void hat(String hat) {
        super.hat(hat);
    }

}
