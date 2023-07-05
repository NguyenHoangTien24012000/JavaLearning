package LuyenTapJava.Collection.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {
    private static final String phoneData = """
            Tien, 012345679
            Tien, 012345673
            Thuong, 012345678
            Son, 012345677
            Nam, 012345675
            Khiem, 012345676
            """;
    private static final String emailData = """
            Tien, tien@gmail.com
            Tien, hoangtien@gmail.com
            Thuong, emyeu@gmail.com
            Nam, thanhnamit@gmail.com
            Son, son@gmail.com
            Dao, dao@gmail.com
            """;
    public static List<Contact> getData(String type){
        List<Contact> dataList = new ArrayList<>();
        Scanner scanner = new Scanner(type.equals("phone") ? phoneData : emailData);
        while (scanner.hasNext()){
            String[] data  = scanner.nextLine().split(",");
            Arrays.asList(data).replaceAll(String::trim);
            if(type.equals("phone")){
                dataList.add(new Contact(data[0], Long.parseLong(data[1])));
            }else if(type.equals("email")){
                dataList.add(new Contact(data[0], data[1]));
            }
        }
        return dataList;
    }
}
