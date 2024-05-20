package bvs.objects;

import java.util.ArrayList;

public class Customer {

    long id;
    String name;
    String firstName;
    String address;
    String zipCode;
    String city;
    boolean feesPayed;
    ArrayList<BookCopy> bookCopies;

    public Customer(long id, String name, String firstName, String address, String zipCode, String city, boolean feesPayed, ArrayList<BookCopy> bookCopies) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.feesPayed = feesPayed;
        this.bookCopies = bookCopies;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public boolean getFeesPayed() {
        return feesPayed;
    }

    public ArrayList<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public boolean getNothingLend() {
        return bookCopies.isEmpty();
    }

    public void lendBookCopy(BookCopy bookCopy) {
        bookCopies.add(bookCopy);
    }
}