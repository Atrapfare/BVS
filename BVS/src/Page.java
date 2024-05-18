public abstract class Page {
    protected UI ui;
    protected PageName pageName;
    protected String pageUI;

    public Page(UI ui, PageName pageName, String pageUI) {
        this.ui = ui;
        this.pageName = pageName;
        this.pageUI = pageUI;
    }

    protected void activatePage() {
        ui.setMessage(this.getPageUI());
        this.pageJob();
    }

    protected abstract void pageJob();

    public String getPageUI() {
        return pageUI;
    }

    public PageName getPageName() {
        return pageName;
    }

    protected void resetPage() {
        ui.setCurrentPage(this);
    }
}
