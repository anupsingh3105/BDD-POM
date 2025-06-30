package com.stepdefInition.stepDef;

import com.stepdefInition.base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPageMMT;

public class loginStep extends BaseTest {

    loginPageMMT loginPage;

    public loginStep() {
        loginPage = new loginPageMMT(driver);
    }

    @Given("I am on the MakeMyTrip page")
    public void iAmOnTheMakeMyTripLoginPage() throws InterruptedException {
        loginPage.openLoginPage();

    }

    @When("user clicks on close popup")
    public void user_clicks_on_close_popup() {
        loginPage.closePopup();
    }

    @Then("user lands to login page")
    public void user_lands_to_login_page() {
        loginPage.clickLogin();
    }

    @Then("select the citys")
    public void selectTheCitys() throws InterruptedException {
        loginPage.selectFromCity();
    }

}
