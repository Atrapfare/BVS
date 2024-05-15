package pages.navigation;

import pages.NavigationPage;
import pages.PageName;

public class HomePage extends NavigationPage {
    public HomePage(PageName pageName) {
        super(pageName);
    }

    @Override
    public void writeMessage() {
        String message = "1 - Search\n2 - Lend a book\n3 - Return a book\n4 - Management\n\n";
        System.out.println(message);
    }
}