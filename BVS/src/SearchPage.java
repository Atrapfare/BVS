public class SearchPage extends Page {
    public SearchPage(UI ui, PageName pageName, String pageUI) {
        super(ui, pageName, pageUI);
    }

    @Override
    protected void pageJob() {

        ui.setCurrentPage(ui.getHomePage());
    }
}
