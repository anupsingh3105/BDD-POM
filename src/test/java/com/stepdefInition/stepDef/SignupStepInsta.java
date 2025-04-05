package com.stepdefInition.stepDef;

import com.stepdefInition.base.BaseTest;
import io.cucumber.java.en.*;
import pages.SignUpPageInsta;

public class SignupStepInsta extends BaseTest {

  SignUpPageInsta signUpPageMMT;

  public SignupStepInsta() {
    signUpPageMMT = new SignUpPageInsta(driver);
  }

  @Given("I am on the instagram page")
  public void i_am_on_the_instagram_page() {
    signUpPageMMT.openSignupPage();
  }

  @When("user clicks on signup button")
  public void user_clicks_on_signup_button() {
    signUpPageMMT.clickSignUp();
  }

  @When("user fill up the sign up details")
  public void user_fill_up_the_sign_up_details() throws InterruptedException {
    signUpPageMMT.fillSignupDetails();
  }

  //    @When("user fills up birth details")
  //    public void user_fills_up_birth_details() {
  //       signUpPageMMT.fillBirthDetails();
  //
  //    }
  @Then("user navigates to email to get otp")
  public void user_navigates_to_email_to_get_otp() {
      signUpPageMMT.enterOtp();
  }

  @When("user enters otp")
  public void user_enters_otp() {}

  @Then("user lands to instagram home pagr")
  public void user_lands_to_instagram_home_pagr() {}

    @And("user fills up birth details with day {}, month {}, and year {}")
    public void userFillsUpBirthDetailsWithDayMonthAndYear(int day, String month, int year) {
        signUpPageMMT.fillBirthDetails(day, month, year);
    }

    @And("saves username,password creds in file")
    public void savesUsernamePasswordCredsInFile() {
      signUpPageMMT.persistData();
    }


}
