package com.ebay.pageObjects;

import com.ebay.BasePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ebay.helpers.ElementsInteraction.getWait;

public class ProtectYourPurchaseWithSQ extends BasePage {

    public void isPageOpened()  {
       getWait().until(ExpectedConditions.titleIs("Protect your purchase with SquareTrade"));
    }
    @Then("^I am on Protect Purchase page$")
    public void iAmOnProtectPurchasePage()  { isPageOpened();}
}
