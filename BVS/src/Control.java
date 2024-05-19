import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Control {

    UI ui;
    Storage storage;

    public Control() {
        this.ui = new UI(this);
        this.storage = new Storage(new ArrayList<Book>(), new ArrayList<BookCopy>(), new ArrayList<Customer>());
        generateSamples();
    }

    public void runUI() {
        ui.startUI();
    }

    public void generateSamples() {
        ArrayList<String> authors = new ArrayList<>(); // Sample list for authors

        Book book1 = new Book("123-456-789", "Sample Book 1", 1978, "Stuttgart", "Klett", 1, authors);
        Book book2 = new Book("123-789-456", "Sample Book 2", 1980, "Berlin", "Duden", 2, authors);
        Book book3 = new Book("789-456-123", "Sample Book 3", 2003, "Filderstadt", "Kosmos", 3, authors);

        storage.addBook(book1);
        storage.addBook(book2);
        storage.addBook(book3);

        BookCopy bookCopy1 = new BookCopy(12345, book1, "Shelf 1", new Date(), false, new Date());
        BookCopy bookCopy2 = new BookCopy(54321, book1, "Shelf 1", new Date(), false, new Date());
        BookCopy bookCopy3 = new BookCopy(13243, book2, "Shelf 2", new Date(), false, new Date());
        BookCopy bookCopy4 = new BookCopy(31423, book2, "Shelf 2", new Date(), false, new Date());
        BookCopy bookCopy5 = new BookCopy(15243, book3, "Shelf 3", new Date(), false, new Date());
        BookCopy bookCopy6 = new BookCopy(51423, book3, "Shelf 3", new Date(), false, new Date());

        storage.addBookCopy(bookCopy1);
        storage.addBookCopy(bookCopy2);
        storage.addBookCopy(bookCopy3);
        storage.addBookCopy(bookCopy4);
        storage.addBookCopy(bookCopy5);
        storage.addBookCopy(bookCopy6);

        Customer lena = new Customer(12345, "Schwarz", "Lena", "Vivaldiweg 36", "70195", "Stuttgart", true, new ArrayList<>());
        Customer lana = new Customer(54321, "Möhrke", "Lana", "Böhmisreute 49", "70199", "Reutlingen", false, new ArrayList<>());
        Customer peter = new Customer(13243, "Kohler", "Peter", "Schwarzweg 49", "70199", "Vaihingen", false, new ArrayList<>());
        storage.addCustomer(lena);
        storage.addCustomer(lana);
        storage.addCustomer(peter);

        lena.lendBookCopy(bookCopy1);
        bookCopy1.setLend(true);
        lena.lendBookCopy(bookCopy4);
        bookCopy4.setLend(true); // Fixed typo from bookCopy1 to bookCopy4
    }

    // CUSTOMER MANAGEMENT
    public int deleteCustomer(long id) {
        try {
            Customer customer = storage.searchCustomerById(id);
            if (customer.getNothingLend()) {
                storage.deleteCustomer(customer);
                return 0; // successfully deleted
            }
        } catch (NoSuchElementException exception) {
            return 2; // not found
        }
        return 1; // not deleted due to customer still has lent books
    }

    // BOOK MANAGEMENT
    public int deleteBook(String isbn) {
        try {
            Book book = storage.searchBookByISBN(isbn);
            ArrayList<BookCopy> bookCopies = storage.getBookCopies();
            boolean readyForDeletion = true;
            for (BookCopy bookCopy : bookCopies) {
                if (bookCopy.getBook().getIsbn().equals(book.getIsbn()) && bookCopy.isLent()) {
                    readyForDeletion = false;
                    break;
                }
            }
            if (readyForDeletion) {
                Iterator<BookCopy> iterator = bookCopies.iterator();
                while (iterator.hasNext()) {
                    BookCopy bookCopy = iterator.next();
                    if (bookCopy.getBook().getIsbn().equals(book.getIsbn())) {
                        iterator.remove();
                        storage.deleteBookCopy(bookCopy);
                    }
                }
                storage.deleteBook(book);
                return 0; // successfully deleted
            }
        } catch (NoSuchElementException exception) {
            return 2; // not found
        }
        return 1; // not deleted due to not ready for deletion
    }

    // BOOK COPY MANAGEMENT
    public int deleteBookCopy(long id) {
        try {
            BookCopy bookCopy = storage.searchBookCopyById(id);
            if (!bookCopy.isLent()) {
                storage.deleteBookCopy(bookCopy);
                return 0; // successfully deleted
            }
        } catch (NoSuchElementException exception) {
            return 2; // not found
        }
        return 1; // not deleted due to book copy still lend
    }
}
