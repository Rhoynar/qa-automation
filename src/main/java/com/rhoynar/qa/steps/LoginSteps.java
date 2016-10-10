package com.rhoynar.qa.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Harsh on 9/14/16.
 */
public class LoginSteps {
    //Cucumber test step definitions for Login Module.

    //Logging object
    private static final Logger log = LogManager.getLogger(LoginSteps.class);


    @Given("^Main page is loaded$")
    public void main_page_is_loaded() throws Throwable {
        log.info("Given: Main page is loaded");

    }

    @When("^I login into the webpage$")
    public void i_login_into_the_webpage() throws Throwable {
        log.info("When: I login into the webpage");
    }

    @Then("^I am able to go main page$")
    public void i_am_able_to_go_main_page() throws Throwable {
        log.info("Then: I am able to go to main page");
    }

}
