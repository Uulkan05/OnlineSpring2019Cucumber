package com.vytrack.pages.login_navigation;

import com.vytrack.utilities.Pages;
import cucumber.api.java.en.Then;

public class TopMenuStepDefinitions {
    Pages pages = new Pages();

    @Then("user navigates to {string} and {string}")
    public void user_navigates_to_and(String tab, String module) {
        pages.dashboardPage().navigateToModule(tab, module);
    }

}
