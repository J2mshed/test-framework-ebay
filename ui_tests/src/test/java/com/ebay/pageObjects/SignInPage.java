package com.ebay.pageObjects;

import com.ebay.BasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ebay.helpers.ElementsInteraction.getWait;
import static com.ebay.helpers.ElementsInteraction.sendKeys;
import static com.ebay.helpers.ElementsInteraction.click;

public class SignInPage extends BasePage {
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleContains("Sign in or Register | eBay"));
       // getWait().until(ExpectedConditions.textMatches(By.id("signin-reg-msg"), "Sign in to eBay or "));
    }

    @And("^I am on SignIn page$")
    public void iAmOnSignInPage() {
        isPageOpened();
    }

    @And("^I set '(.*)' as 'email or username' on SignIn page$")
    public void iSetEmailOrUsername(String emailOrUsername) {
        sendKeys(By.id("userid"), emailOrUsername);
    }

    @And("^I press Continue button on SignIn page$")
    public void iPressContinueButton() {
        click(By.id("signin-continue-btn"));
    }

    @And("^I set '(.*)' as password on SignIn page$")
    public void iSetPassword(String password) {
        sendKeys(By.id("pass"), password);
    }

    @And("^I press SignIn button on SignIn page$")
    public CheckOutPage iPressSignInButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.id("sgnBt")));
        click(By.id("sgnBt"));
        return new CheckOutPage();
    }
}
