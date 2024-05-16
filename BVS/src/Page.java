import java.util.Scanner;
public abstract class Page {
    protected UI ui;
    protected PageName pageName;
    protected String pageUI;
    protected Scanner sc;

    public Page(UI ui, PageName pageName, String pageUI, Scanner sc) {
        this.ui = ui;
        this.pageName = pageName;
        this.pageUI = pageUI;
        this.sc = sc;
    }

    protected void activatePage(String pageUI){
        ui.setMessage(pageUI);
        this.pageJob();
    }

    protected abstract void pageJob();
}
