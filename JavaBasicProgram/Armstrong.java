package JavaBasicProgram;

import java.util.ArrayList;

public class Armstrong {
    public static void main(String[] args) {
        Boolean test = numberArmstrong(12345);
    }
    public static Boolean numberArmstrong(int number){
        ArrayList<Integer> myArr = new ArrayList<>();
        while (number > 0){
            Integer myInt = number % 10;
            myArr.add(myInt);
            number = number/10;
        }
        System.out.println(myArr);
        return true;
    }

}
