import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Storage {

    private final ArrayList<Book> books;
    private final ArrayList<BookCopy> bookCopies;
    private final ArrayList<Customer> customers;

    public Storage(ArrayList<Book> books, ArrayList<BookCopy> bookCopies, ArrayList<Customer> customers) {
        this.books = books;
        this.bookCopies = bookCopies;
        this.customers = customers;
    }

    /*--------BOOK--------*/
    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public Book searchBookByISBN(String isbn) throws NoSuchElementException {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new NoSuchElementException("Book not found!");
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    /*--------BOOK COPY--------*/
    public void addBookCopy(BookCopy bookCopy) {
        bookCopies.add(bookCopy);
    }

    public void deleteBookCopy(BookCopy bookCopy) {
        bookCopies.remove(bookCopy);
    }

    public BookCopy searchBookCopyById(long id) throws NoSuchElementException {
        for (BookCopy bookCopy : bookCopies) {
            if (bookCopy.getId() == id) {
                return bookCopy;
            }
        }
        throw new NoSuchElementException("BookCopy not found!");
    }

    public ArrayList<BookCopy> getBookCopies() {
        return bookCopies;
    }

    /*--------CUSTOMER--------*/
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }

    public Customer searchCustomerById(long id) throws NoSuchElementException {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        throw new NoSuchElementException("Customer not found!");
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

}