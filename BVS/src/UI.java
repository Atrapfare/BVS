import java.util.Scanner;

public class UI {

    private final Control control;
    private final Scanner sc = new Scanner(System.in);;
    private Page currentPage;
    private Page homePage = new HomePage(this, PageName.HOME, "Select your page:\n\n1 - Search\n2 - Lend a book\n3 - Return a book\n4 - Management\n", this.sc);
    private Page searchPage = new SearchPage(this, PageName.SEARCH, "What do you want to search?\n\n1 - Book\n2 - Book Copy\n3 - Customer", this.sc);
    private Page lendPage = new LendPage(this, PageName.LEND, "Please type in the customer ID and the book copy ID:\n\n", this.sc);
    private Page backPage = new BackPage(this, PageName.BACK, "Please type in the book copy ID that should be returned:\n\n", this.sc);
    private Page managementPage = new ManagementPage(this, PageName.MANAGEMENT, "What do you want to manage?\n\n1 - Delete customer\n2 - Delete book\n3 - Delete book copy", this.sc);

    public UI(Control control) {
        this.control = control;
        this.currentPage = homePage;
        this.currentPage.activatePage(currentPage.pageUI);
        this.startUI();
    }

    public void startUI() {
        while (true) {
            selectPage();
            this.currentPage = homePage;
            this.clearConsole();
            currentPage.activatePage(currentPage.pageUI);
        }
    }

    private void selectPage() {
        String input = sc.next();
        if (input == null || input.isEmpty()) {
            this.errorMessage("Invalid Input!");
        } else {
            try {
                int pageNumber = Integer.parseInt(input);

                switch (pageNumber) {
                    case 1:
                        this.currentPage = searchPage;
                        this.clearConsole();
                        currentPage.activatePage(currentPage.pageUI);
                        break;
                    case 2:
                        this.currentPage = lendPage;
                        this.clearConsole();
                        currentPage.activatePage(currentPage.pageUI);
                        break;
                    case 3:
                        this.currentPage = backPage;
                        this.clearConsole();
                        currentPage.activatePage(currentPage.pageUI);
                        break;
                    case 4:
                        this.currentPage = managementPage;
                        this.clearConsole();
                        currentPage.activatePage(currentPage.pageUI);
                        break;
                    default:
                        System.out.println("Invalid Input!");
                        break;

                }
            } catch (NumberFormatException exception) {
                this.errorMessage("Invalid Input!");
            }
        }
    }

    public void errorMessage(String message) {
        System.out.println(message);
    }

    public void setMessage(String message) {
        System.out.println(message);
    }
    public final  void clearConsole()
    {
        for (int i = 0; i < 10; i++) {
            System.out.print("\n");
        }
    }
}