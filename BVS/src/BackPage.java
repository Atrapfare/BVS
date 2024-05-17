public class BackPage extends Page {
    public BackPage(UI ui, PageName pageName, String pageUI) {
        super(ui, pageName, pageUI);
    }

    @Override
    protected void pageJob() {

        ui.setCurrentPage(ui.getHomePage());
    }
}
