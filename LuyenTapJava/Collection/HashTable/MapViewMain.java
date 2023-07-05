package LuyenTapJava.Collection.HashTable;

import java.util.*;

public class MapViewMain {
    public static void main(String[] args) {
        Map<String, Contact> contactMap = new HashMap<>();
        ContactData.getData("phone").forEach(contact -> contactMap.put(contact.getName(), contact));
        ContactData.getData("email").forEach(contact -> contactMap.put(contact.getName(), contact));
        Set<String> keysView =contactMap.keySet();
        System.out.println(keysView);
        Set<String> copyKeys = new TreeSet<>(keysView);
        System.out.println(copyKeys);
        keysView.remove("Tien");
//        contactMap.forEach(((s, contact) -> System.out.println(s)));
        System.out.println(contactMap.keySet());
//        Set<V>
        if (contactMap.containsKey("Tien")){
            System.out.println("Tien exits");
        }else{
            System.out.println("Tien ---");
        }

        keysView.retainAll(List.of("Nam", "Son"));
        System.out.println(keysView);
        System.out.println(contactMap.keySet());
        keysView.clear();
        System.out.println("-".repeat(50));

        ContactData.getData("phone").forEach(contact -> contactMap.put(contact.getName(), contact));
        ContactData.getData("email").forEach(contact -> contactMap.put(contact.getName(), contact));

        System.out.println(keysView);
        var values = contactMap.values();
        values.forEach(System.out::println);
        values.retainAll(ContactData.getData("email"));
        System.out.println("----");
        values.forEach(System.out::println);
        System.out.println("-".repeat(50));

        HashSet<Contact> contactsSet = new HashSet<>(values);
        contactsSet.forEach(System.out::println);



    }
}
