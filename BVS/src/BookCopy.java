import java.util.Date;

/**
 * BookCopy
 */
public class BookCopy {

    long id;
    Book book;
    String shelfLocation;
    Date addedToLibrary;
    boolean lent;
    Date lentDate;

    public long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public Date getAddedToLibrary() {
        return addedToLibrary;
    }

    public boolean getLent() {
        return lent;
    }

    public Date getLentDate() {
        return lentDate;
    }

}