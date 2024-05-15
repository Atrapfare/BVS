import java.util.ArrayList;

/**
 * Customer
 */
public class Customer {

    long id;
    String name;
    String firstName;
    String adress;
    String zipCode;
    String city;
    boolean feesPayed;
    ArrayList<Book> bookCopies = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAdress() {
        return adress;
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

    public ArrayList<Book> getBookCopies() {
        return bookCopies;
    }


}