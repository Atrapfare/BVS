package bvs.pages.impl;

import bvs.pages.Page;
import bvs.pages.PageName;
import bvs.ui.UI;

public class HomePage extends Page {

    public HomePage(UI ui, PageName pageName, String pageUI) {
        super(ui, pageName, pageUI);
    }

    @Override
    protected void pageJob() {
        this.selectPage();
    }

    private void selectPage() {
        String input = ui.getSc().next();
        if (input == null || input.isEmpty()) {
            ui.errorMessage("Invalid Input!");
            this.selectPage();
        } else {
            try {
                int pageNumber = Integer.parseInt(input);

                switch (pageNumber) {
                    case 1:
                        ui.clearConsole();
                        ui.setCurrentPage(ui.getSearchPage());
                        break;
                    case 2:
                        ui.clearConsole();
                        ui.setCurrentPage(ui.getLendPage());
                        break;
                    case 3:
                        ui.clearConsole();
                        ui.setCurrentPage(ui.getBackPage());
                        break;
                    case 4:
                        ui.clearConsole();
                        ui.setCurrentPage(ui.getManagementPage());
                        break;
                    default:
                        ui.errorMessage("Invalid Input!");
                        this.selectPage();
                        break;

                }
            } catch (NumberFormatException exception) {
                ui.errorMessage("Invalid Input!");
                this.selectPage();
            }
        }
    }
}