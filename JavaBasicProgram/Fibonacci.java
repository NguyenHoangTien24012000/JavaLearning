package JavaBasicProgram;

public class Fibonacci {
    public static void main(String[] args) {
        fibonacci(10, 0, 0, 1);
    }
    public static void fibonacci(int number, int numberStep,int numberPrev, int numberCurrent){
        if(numberStep == number){
            return;
        }
        numberStep += 1;
        System.out.print(numberPrev + " ");
        int numberFlag = numberCurrent;
        numberCurrent = numberPrev + numberCurrent;
        fibonacci(number, numberStep, numberFlag, numberCurrent);
    }
}

