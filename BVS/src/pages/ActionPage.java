package pages;

public abstract class ActionPage extends Page {


    public ActionPage(PageName pageName) {
        super(pageName);
    }

    public abstract void actionWithOneInput(String input);

    public abstract void actionWithTwoInput(String input1, String input2);
}
