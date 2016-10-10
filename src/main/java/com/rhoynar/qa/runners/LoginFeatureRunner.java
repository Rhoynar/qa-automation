package com.rhoynar.qa.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Harsh on 9/14/16.
 */
@CucumberOptions(features = "src/main/resources/features/Login.feature",
        glue = "com.rhoynar.qa.steps",
        monochrome = true)
public class LoginFeatureRunner extends AbstractTestNGCucumberTests {
}
