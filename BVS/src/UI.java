import java.util.Scanner;

public class UI {

    private final Control control;
    private final Scanner sc;
    private final Page homePage;
    private final Page searchPage;
    private final Page lendPage;
    private final Page backPage;
    private final Page managementPage;
    private Page currentPage;

    public UI(Control control) {
        this.control = control;
        this.sc = new Scanner(System.in);

        this.homePage = new HomePage(this, PageName.HOME, "Select your page:\n\n1 - Search\n2 - Lend a book\n3 - Return a book\n4 - Management\n\n");
        this.searchPage = new SearchPage(this, PageName.SEARCH, "What do you want to search?\n\n1 - Book\n2 - Book Copy\n3 - Customer\n\n");
        this.lendPage = new LendPage(this, PageName.LEND, "Please type in the customer ID and the book copy ID:\n\n");
        this.backPage = new BackPage(this, PageName.BACK, "Please type in the book copy ID that should be returned:\n\n");
        this.managementPage = new ManagementPage(this, PageName.MANAGEMENT, "What do you want to manage?\n\n1 - Delete customer\n2 - Delete book\n3 - Delete book copy\n\n");

        this.currentPage = homePage;
    }

    public void startUI() {
        this.currentPage = homePage;
        this.currentPage.activatePage();
    }

    public void errorMessage(String message) {
        System.out.println(message);
    }

    public void setMessage(String message) {
        System.out.println(message);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            errorMessage("Something went wrong!");
        }
    }

    public final void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.print("\n");
        }
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
        this.currentPage.activatePage();
    }

    public Page getSearchPage() {
        return searchPage;
    }

    public Page getLendPage() {
        return lendPage;
    }

    public Page getBackPage() {
        return backPage;
    }

    public Page getManagementPage() {
        return managementPage;
    }

    public Page getHomePage() {
        return homePage;
    }

    public Scanner getSc() {
        return sc;
    }


    // CUSTOMER
    public int deleteCustomer(long id) {
        return control.deleteCustomer(id);
    }

    // BOOK
    public int deleteBook(String isbn) {
        return control.deleteBook(isbn);
    }

    // BOOK COPY
    public int deleteBookCopy(long id) {
        return control.deleteBookCopy(id);
    }
}