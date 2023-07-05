package LuyenTapJava.Collection.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");
        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-".repeat(50));
        Map<String, Contact> contactMap = new HashMap<>();
        for (Contact contact : fullList){
            contactMap.put(contact.getName(), contact);
        }
        contactMap.forEach((k, v) ->{
            System.out.println("key: " + k + " - value: " + v);
        });
        System.out.println("-".repeat(40));
        System.out.println(contactMap.get("Tien"));
        Contact testTien = new Contact("Nguyen Tien", "nguyentien123@gmail.com");
        System.out.println(contactMap.get("Nguyen Tien"));
        System.out.println(contactMap.getOrDefault("Nguyen Tien", testTien));
        System.out.println("-".repeat(40));
        contactMap.clear();
        for (Contact contact : fullList){
            Contact duplicate = contactMap.put(contact.getName(), contact);
            if(duplicate != null){
//                System.out.println("Duplicate: " + duplicate);
//                System.out.println("Current: " + contact);
                contactMap.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contactMap.forEach((k, v) ->{
            System.out.println("key: " + k + " - value: " + v);
        });
        System.out.println("-".repeat(30));
        contactMap.clear();
        for (Contact contact : fullList){
            contactMap.putIfAbsent(contact.getName(), contact);
        }
        contactMap.forEach((k, v) ->{
            System.out.println("key: " + k + " - value: " + v);
        });
        System.out.println("-".repeat(40));
        contactMap.clear();
        fullList.forEach(contact -> contactMap.merge(contact.getName(), contact,
                (previous, current) -> {
                    System.out.println("Previous: " + previous + " Current: " + current);
                    Contact merge = previous.mergeContactData(current);
                    System.out.println("Merge: " +merge);
                    return merge;
                }));
        contactMap.forEach((k, v) ->{
            System.out.println("key: " + k + " - value: " + v);
        });

        System.out.println("-".repeat(50));

        for(String contactName : new String[]{"Tien", "Nam", "Khai"}){
            contactMap.compute(contactName, (k, v) -> new Contact(k) );
        }

        contactMap.forEach((k, v) ->{
            System.out.println("key: " + k + " - value: " + v);
        });
        System.out.println("-".repeat(50));
        for(String contactName : new String[]{"Tien", "Nam", "Khai"}){
            contactMap.computeIfAbsent(contactName, (k) -> new Contact(k) );
        }
        contactMap.forEach((k, v) ->{
            System.out.println("key: " + k + " - value: " + v);
        });

        System.out.println("-".repeat(50));
        for(String contactName : new String[]{"Tien", "Nam", "Khai"}){
            contactMap.computeIfPresent(contactName, (k, v) ->{
                v.addEmail("test@gmail.com"); return  v;
            } );
        }
        contactMap.forEach((k, v) ->{
            System.out.println("key: " + k + " - value: " + v);
        });
        System.out.println("-".repeat(50));
        contactMap.replaceAll((k,v)->{
            String newEmail = k + "fun@gmail.com";
            v.replaceEmail("test@gmail.com", newEmail);
            return v;
        });
        contactMap.forEach((k, v) ->{
            System.out.println("key: " + k + " - value: " + v);
        });
        System.out.println("-".repeat(50));

        Contact newContact = new Contact("Nguyen Tien", "newemail@gmail.com");
        contactMap.replace("Tien", newContact);

        contactMap.put("test", new Contact("Ngu"));
        contactMap.forEach((k, v) ->{
            System.out.println("key: " + k + " - value: " + v);
        });
    }
}
