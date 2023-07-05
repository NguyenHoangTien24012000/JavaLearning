package LuyenTapJava.Encryption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class EncryptionProgram {
    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;
    private char[] secretLetters;

    public EncryptionProgram() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.list = new ArrayList<>();
        this.shuffledList = new ArrayList<>();
        this.character = ' ';
//        this.line = line;
//        this.letters = letters;
//        this.secretLetters = secretLetters;
        newKey();
        askQuestion();
    }
    private void askQuestion(){
        while (true){
            System.out.println("*".repeat(50));
            System.out.println("What do you want to do?");
            System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().trim().charAt(0));
            switch (response){
                case 'N' -> newKey();
                case 'G' -> getKey();
                case 'E' -> encrypt();
                case 'D' -> decrypt();
                case 'Q' -> quit();
                default -> System.out.println("Choice invalid!!!");
            }
        }
    }
    private void newKey(){
        character = ' ';
        list.clear();
        shuffledList.clear();
        for (int i = 32; i < 127; i++) {
            list.add(Character.valueOf(character));
            character++;
        }
        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        System.out.println("Create a new key success!!");
    }
    private void getKey(){
        System.out.print("Key: ");
        for (Character x : list){
            System.out.print(x);
        }
        System.out.println("");
//        System.out.println(": ");
        for(Character x : shuffledList){
            System.out.print(x);
        }
        System.out.println("");
    }
    private void encrypt(){

    }
    private void decrypt(){

    }
    private void quit(){

    }
}
