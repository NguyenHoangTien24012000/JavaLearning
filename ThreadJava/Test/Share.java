package ThreadJava.Test;

public class Share {
    int number;
    public Share() {
        this.number = 0;
    }
    public synchronized void tang(){
        this.number = this.number + 1;
    }
    public synchronized void giam(){
        this.number = this.number -1;
    }
    public boolean check(){
        if(number < 0){
            return false;
        }
        return true;
    }
    public int getNumber(){
        return number;
    }
}
