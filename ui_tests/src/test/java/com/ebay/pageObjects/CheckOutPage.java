package com.ebay.pageObjects;

import com.ebay.BasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ebay.helpers.ElementsInteraction.*;

public class CheckOutPage extends BasePage {
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleIs("Checkout | eBay"));
       // getWait().until(ExpectedConditions.textMatches(By.id("signin-reg-msg"), "Sign in to eBay or "));
    }

    @And("^I am on Checkout Page$")
    public void checkOutPage(){
        isPageOpened();
    }
}
