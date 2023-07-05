package LuyenTapJava.Collection.HashTable;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        String test1 = "abc";
//        String test2 = "abc";
//        String test3 = String.join("b","a", "c");
//        System.out.println(test3);
//        String test4 = "abc";
//        String test5 = "Abc";
//        String test6 = new String("abc");
//        List<String> abc = new ArrayList<>(List.of(test1, test2,test3,test4,test5,test6));
//        abc.forEach(s -> System.out.println(s + ": " + s.hashCode()));
//
//        Set<String> mySet = new HashSet<>(abc);
//        System.out.println(mySet + " " + mySet.size());
//
//        for (String str1 : mySet){
//            for (int i = 0; i < abc.size(); i++){
//                if(str1.equals(abc.get(i))){
//                    System.out.println("set: " + str1 + " str: " + abc.get(i) + " stt: " + i);
//                }
//            }
//        }
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContact = new HashSet<>(emails);
        Set<Contact> phoneContact = new HashSet<>(phones);


        System.out.println("-".repeat(40));
        int index = emails.indexOf(new Contact("Tien"));
//        System.out.println(index);
        Contact tien = emails.get(index);
        System.out.println(tien);
        tien.addEmail("tien123@gmail.com");

        tien.replaceEmail("tien123@gmail.com", "tien@gmail.com");

        printData("Phone contact", phoneContact);
        printData("Email contact", emailContact);

        System.out.println("-".repeat(50));
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContact);
        unionAB.addAll(phoneContact);
        printData("A ∪ B", unionAB );
        Set<Contact> intersectAB = new HashSet<>(phoneContact);
        intersectAB.retainAll(emailContact);
        printData("A ∩ B", intersectAB);
        Set<Contact> intersectBA = new HashSet<>(emailContact);
        intersectBA.retainAll(phoneContact);
        printData("B ∩ A", intersectBA );
        Set<Contact> AMinusB = new HashSet<>(emailContact);
        AMinusB.removeAll(phoneContact);
        printData("A - B", AMinusB);

        //Tree set
        System.out.println("-".repeat(50));
        System.out.println(emails);

    }
    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-".repeat(40));
        System.out.println(header);
        System.out.println("-".repeat(40));
        contacts.forEach(System.out::println);
    }



}
