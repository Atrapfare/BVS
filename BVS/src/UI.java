import pages.ActionPage;
import pages.NavigationPage;
import pages.Page;
import pages.PageName;
import pages.action.LendPage;
import pages.action.RestitutionPage;
import pages.navigation.HomePage;
import pages.action.ManagementPage;
import pages.action.SearchPage;

import java.util.Scanner;

public class UI {

    private final Control control;
    private final NavigationPage home;
    private final ActionPage lend;
    private final ActionPage management;
    private final ActionPage restitution;
    private final ActionPage search;
    private final Scanner sc;
    private Page currentPage;

    public UI(Control control) {
        this.control = control;

        this.home = new HomePage(PageName.HOME);
        this.lend = new LendPage(PageName.LEND);
        this.management = new ManagementPage(PageName.MANAGEMENT);
        this.restitution = new RestitutionPage(PageName.RESTITUTION);
        this.search = new SearchPage(PageName.SEARCH);

        this.sc = new Scanner(System.in);
        this.currentPage = home;
    }

    private void setCurrentPage(Page page) {
        this.currentPage = page;
    }

    public void startUI() {
        while (true) {
            currentPage.writeMessage();
            input();
        }
    }

    private void input() {

        if (this.currentPage instanceof NavigationPage) {
            String input = sc.next();
            if (input == null || input.isEmpty()) {
                errorMessage("Invalid Input!");
            } else {
                ((NavigationPage) currentPage).setPage(input);
                /*TODO*/
            }
        } else if (this.currentPage instanceof ActionPage) {
            ActionPage actionPage = (ActionPage) currentPage;
            if (currentPage.getPageName().equals(PageName.LEND)) {
                String input1 = sc.next();
                String input2 = sc.next();
                if (input1 == null || input2 == null || input1.isEmpty() || input2.isEmpty()) {
                    errorMessage("Invalid Input!");
                } else {
                    actionPage.actionWithTwoInput(input1, input2);
                }
            } else {
                String input = sc.next();
                if (input == null || input.isEmpty()) {
                    errorMessage("Invalid Input!");
                }
                actionPage.actionWithOneInput(input);
            }
        } else {
            errorMessage("System Error!");
            System.exit(1);
        }
    }

    public void errorMessage(String message) {
        System.out.println(message);
    }
}