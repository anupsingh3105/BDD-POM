package com.stepdefInition.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverUtil;

public class BaseTest {

    protected static WebDriver driver;

    public void setUp() {
        driver = WebDriverUtil.getDriver();
        driver.manage().window().maximize();
    }

    public void tearDown() {
        WebDriverUtil.quitDriver();
    }


}