package com.stepdefInition.stepDef;

import com.stepdefInition.base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.amazonPage;

public class amazonStepDef extends BaseTest {
    amazonPage amazonStepDef;


    public amazonStepDef() {
        amazonStepDef = new amazonPage(driver);
    }

    @Given("I am on the amazon page")
    public void iAmOnTheAmazonPage() {

        amazonStepDef.openLoginPage();


    }

    @When("user click on search field")
    public void userClickOnSearchField() {

        amazonStepDef.searchBox();

    }

    @Then("grab all the items and click on the expected item")
    public void grabAllTheItemsAndClickOnTheExpectedItem() throws InterruptedException {

        amazonStepDef.grabAndClickOnItem();
    }

    @Given("user enter the login credentials")
    public void userEnterTheLoginCredentials() {
        amazonStepDef.login();
    }
}
