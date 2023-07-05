package LuyenTapJava.Collection.HashTable;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails =ContactData.getData("email");

        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(contact -> justNames.add(contact.getName()));
        justNames.forEach(System.out::println);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        System.out.println("full set --------------------");
        fullSet.forEach(System.out::println);

        System.out.println("-".repeat(30));
        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        System.out.println("full list");
        fullList.forEach(System.out::println);

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println("-".repeat(30));
        System.out.printf("min = %s, max = %s%n", min.getName(), max.getName());
        System.out.printf("first = %s, last = %s%n", first.getName(), last.getName());

        NavigableSet<Contact> copied = new TreeSet<>(fullSet);
//        System.out.println("First ele: " + copied.pollFirst());
//        System.out.println("Last ele: " + copied.pollLast());
        copied.forEach(System.out::println);
//        copied.subSet();

        System.out.println("-".repeat(50));
        System.out.println(fullSet);
        Contact yen = new Contact("Tien");
        Contact anh = new Contact("Anh");
        Contact hai = new Contact("Hai");
        System.out.println("yen " + fullSet.ceiling(yen)); // lon hon hoac bang
        System.out.println("yen " + fullSet.higher(yen));  // lon hon

        System.out.println("Anh " + fullSet.ceiling(anh));
        System.out.println("Anh " + fullSet.higher(anh));

        System.out.println("hai " + fullSet.ceiling(hai));
        System.out.println("hai " + fullSet.higher(hai));

        System.out.println("yen " + fullSet.floor(yen)); // nho hon hoac bang
        System.out.println("yen " + fullSet.lower(yen));  // nho hon

        System.out.println("Anh " + fullSet.floor(anh));
        System.out.println("Anh " + fullSet.lower(anh));

        System.out.println("hai " + fullSet.floor(hai));
        System.out.println("hai " + fullSet.lower(hai));

        System.out.println("Giam dan");
        NavigableSet<Contact> giamDan = fullSet.descendingSet();
        System.out.println(giamDan);

        System.out.println("-".repeat(40));
        Contact nam = new Contact("Nam");
        System.out.println(fullSet);
        var testTail = fullSet.tailSet( nam, true);
        var testTail1 = fullSet.tailSet(nam, false);
        System.out.println(testTail);
        System.out.println(testTail1);

        var testHead = fullSet.headSet( nam, true);
        var testHead1 = fullSet.headSet(nam, false);
        System.out.println(testHead);
        System.out.println(testHead1);




    }
}
