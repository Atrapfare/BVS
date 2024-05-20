package bvs.pages.impl;

import bvs.pages.Page;
import bvs.pages.PageName;
import bvs.ui.UI;

public class SearchPage extends Page {
    public SearchPage(UI ui, PageName pageName, String pageUI) {
        super(ui, pageName, pageUI);
    }

    @Override
    protected void pageJob() {

        ui.setCurrentPage(ui.getHomePage());
    }
}
