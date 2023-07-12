package LuyenTapJava.IO.BookChanllege;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    private String bookName;
    private String authName;
    private String publishDate;
    private String manufactureName;
    private int price;
    public Book(){};
    public Book(String bookName, String authName, String publishDate, String manufactureName, int price) {
        this.bookName = bookName;
        this.authName = authName;
        this.publishDate = publishDate;
        this.manufactureName = manufactureName;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getManufactureName() {
        return manufactureName;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + bookName + " - AuthName: " + authName + " - DatePublish: " + price + " - ManufactureName: " + manufactureName + " - Price: " + price;
    }
    public void enterInfoBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten sach: ");
        bookName = scanner.nextLine();
        System.out.println("Nhap ten tac gia: ");
        authName = scanner.nextLine();
        System.out.println("Ngay xuat ban (dd/MM/yyyy): ");
        publishDate = scanner.nextLine();
        System.out.println("Nhap nha xuat ban: ");
        manufactureName = scanner.nextLine();
        System.out.println("Nhap gia sach: ");
        price = scanner.nextInt();
//        scanner.close();
    }
}
