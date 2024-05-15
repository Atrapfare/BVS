import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Storage {

    private final ArrayList<Book> books = new ArrayList<>();


    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public Book searchBook(String isbn) throws NoSuchElementException {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new NoSuchElementException("Book not found!");
    }

}