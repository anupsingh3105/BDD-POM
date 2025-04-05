package com.stepdefInition.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// @RunWith(Cucumber.class)
    @CucumberOptions(
           features = {"src/test/resources/feature/MMTlogin.feature"}, // Path to your feature files
            glue = {"com.stepdefInition.stepDef"}, // Package where step definitions are located
            dryRun = false
    )
    public class Runner extends AbstractTestNGCucumberTests {

        // This class is empty and serves as a placeholder for the Cucumber options.
    }

