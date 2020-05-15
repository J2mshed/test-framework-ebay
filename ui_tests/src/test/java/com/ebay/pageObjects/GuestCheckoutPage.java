package com.ebay.pageObjects;

import com.ebay.BasePage;
import com.ebay.CucumberHooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.ebay.helpers.ElementsInteraction.getWait;
import static com.ebay.helpers.ElementsInteraction.sendKeys;

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

    @And("^I set '(.*)' as Street address on Checkout page$")
    public void iSetStreetAddress(String streetAddress) {
        sendKeys(By.id("addressLine1"), streetAddress);
    }

}
