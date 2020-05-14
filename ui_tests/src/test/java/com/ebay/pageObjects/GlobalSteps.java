package com.ebay.pageObjects;

import com.ebay.TestsConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.ebay.CucumberHooks.getDriver;
import static com.ebay.TestsConfig.getConfig;


public class GlobalSteps {
    @Given("^I open start page$")
    public StartPage openStartPage() {
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        return new StartPage();
    }
    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }
}
