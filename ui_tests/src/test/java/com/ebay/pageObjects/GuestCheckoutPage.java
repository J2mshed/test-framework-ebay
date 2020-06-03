package com.ebay.pageObjects;

import com.ebay.BasePage;
import com.ebay.CucumberHooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.ebay.helpers.ElementsInteraction.*;

public class GuestCheckoutPage extends BasePage {
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleContains("Checkout | eBay"));
    }

    @Then("^I am on Guest Checkout page$")
    public void iAmOnGuestCheckoutPage() {
        isPageOpened();
    }

    @Then("^Page contains '(.*)' itemName on Checkout page$")
    public void pageContainsItemsOnCheckoutPage(String item) {
        By itemName = (By.xpath(String.format("//div[@class='item-title']//span[.='%s']", item)));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(itemName));
    }

    @Then("^I change the quantity of item to '(.*)' on Checkout page$")
    public void iChangeTheQuantity(String quantity) {
//        By quantityOfItem = (By.xpath("//select[@data-test-id='CART_DETAILS_ITEM_QUANTITY']"));
//           Select select = new Select((WebElement) By.xpath("//select[@data-test-id='CART_DETAILS_ITEM_QUANTITY']"));
//           select.selectByValue(quantity);
        Select select = new Select(CucumberHooks.getDriver()
                .findElement(By.xpath("//select[@data-test-id='CART_DETAILS_ITEM_QUANTITY']")));
        select.selectByVisibleText(quantity);
    }

    //        getWait().until(ExpectedConditions.visibilityOfElementLocated(quantityOfItem));


    @And("^I select '(.*)' as ship country on Checkout page$")
    public void iSelectCountryToShip(String country) {
        Select select = new Select(CucumberHooks.getDriver()
                .findElement(By.id(String.format("country", country))));
        select.selectByVisibleText(country);
    }

    @And("^I set '(.*)' as first name on Checkout page$")
    public void iSetNameAsFirstName(String firstName) {
        sendKeys(By.id("firstName"), firstName);
    }

    @And("^I set '(.*)' as last name on Checkout page$")
    public void iSetNameAsLastName(String lastName) {
        sendKeys(By.id("lastName"), lastName);
    }

    @And("^I set '(.*)' as street address on Checkout page$")
    public void iSetStreetAddress(String streetAddress) {
        sendKeys(By.id("addressLine1"), streetAddress);
    }

    @And("^I set '(.*)' as city on Checkout page$")
    public void iSetCity(String city) {
        sendKeys(By.id("city"), city);
    }

    @And("^I select '(.*)' as states on Checkout page$")
    public void iSelectStates(String state) {
        Select select = new Select(CucumberHooks.getDriver()
                .findElement(By.id(String.format("stateOrProvince", state))));
        select.selectByVisibleText(state);
    }

    @And("^I set '(.*)' as postalcode on Checkout page$")
    public void iSetPostalcode(String postalcode) {
        sendKeys(By.id("postalCode"), postalcode);
    }

    @And("^I set '(.*)' as email on Checkout page$")
    public void iSetEmail(String email) {
        sendKeys(By.id("email"), email);
    }

    @And("^I set '(.*)' as confirm email on Checkout page$")
    public void iSetConfirmEmail(String confirmEmail) {
        sendKeys(By.id("emailConfirm"), confirmEmail);
    }

    @And("^I set '(.*)' as phone number on Checkout page$")
    public void iSetPhoneNumber(String phoneNumber) {
        sendKeys(By.id("phoneNumber"), phoneNumber);
    }

    @And("^I press done button on Checkout page$")
    public GuestCheckoutPage iPressDone() {
        click(By.className("form-action ADD_ADDRESS_SUBMIT"));
        return this;
    }
}
