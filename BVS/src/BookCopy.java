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

    public BookCopy(long id, Book book, String shelfLocation, Date addedToLibrary, boolean lent, Date lentDate) {
        this.id = id;
        this.book = book;
        this.shelfLocation = shelfLocation;
        this.addedToLibrary = addedToLibrary;
        this.lent = lent;
        this.lentDate = lentDate;
    }

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

    public boolean isLent() {
        return lent;
    }

    public Date getLentDate() {
        return lentDate;
    }

    public void setLend(boolean status) {
        this.lent = status;
    }
}