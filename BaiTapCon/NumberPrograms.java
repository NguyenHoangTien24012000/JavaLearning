package BaiTapCon;

import java.util.*;

public class NumberPrograms {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        int soLuong = enterNumber();
//        printFibonacci(1, 0, soLuong);
//        LinkedList<Integer> integerList = new LinkedList<>(List.of(11,9,10,1,2,3,4,5,6,7,8));
//        Comparator<Integer> testSort = Comparator.comparing(Integer::intValue);
//        integerList.sort(testSort);
//        System.out.println(integerList);
//        System.out.println(integerList.get(3));
//        integerList.forEach(System.out::println);
//        System.out.println(integerList.peekFirst() + " " +  integerList.peekLast() + " " + integerList.peek());
//        integerList.addFirst(100);
//        integerList.addLast(200);
//        integerList.pollFirst();
//        integerList.pollLast();
//        System.out.println(integerList);

//        checkPalindrome(123210);
//        int test = factorial(5);
//        System.out.println(" = " + test);
        armstrong(123);
    }
    public static int enterNumber(){
        System.out.println("Nhap number: ");
        int total = scanner.nextInt();
        scanner.close();
        return total;
    }
    public static void printFibonacci(int numberCurrent,int numberPrev, int total){
        if(total == 0){
            return;
        }
        System.out.print(numberPrev + " ");
        total -= 1;
        printFibonacci((numberCurrent + numberPrev), numberCurrent, total);
    }
    public static void checkPalindrome(int number){
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (number > 0){
            int du = number % 10;
            linkedList.add(du);
            number /= 10;
        }
        System.out.println(linkedList);
        int step = linkedList.size() / 2;
        for (int i = 0; i < step; i++ ){
            if (linkedList.pollFirst() != linkedList.pollLast()){
                System.out.println("khong phai");
                return;
            }
        }
        System.out.println("Co phai");
    }
    public static int factorial(int number){
        if(number == 1){
            System.out.print("1");
            return 1;
        }
        System.out.print(number + " * ");
        return number * factorial(number - 1);
    }
    public static void armstrong(int number){
        int soMu = 0, tong = 0;
        List<Integer> list = new ArrayList<>();
        while (number > 0){
            soMu += 1;
            list.add(number % 10);
            number /= 10;
        }
        for (Integer e : list) {
            System.out.print(e + "^" + soMu + " + ");
            tong += Math.pow(e, soMu);
        }
        System.out.println();
        System.out.println("gia tri = " + tong);

    }
}
