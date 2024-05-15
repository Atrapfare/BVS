package pages.action;

import pages.ActionPage;
import pages.PageName;

public class LendPage extends ActionPage {

    public LendPage(PageName pageName) {
        super(pageName);
    }

    @Override
    public void actionWithOneInput(String input) {

    }

    @Override
    public void actionWithTwoInput(String input1, String input2) {

    }

    @Override
    public void writeMessage() {
        String message = "Type in Customor ID\n\n";
        System.out.println(message);
    }
}
