package pages;

public abstract class Page {
    PageName pageName;

    public Page(PageName pageName) {
        this.pageName = pageName;
    }

    public abstract void writeMessage();

    public PageName getPageName() {
        return pageName;
    }
}