package com.ebay.pageObjects;

import com.ebay.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ebay.helpers.ElementsInteraction.click;
import static com.ebay.helpers.ElementsInteraction.getWait;

public class YouAreAlmostDoneForm extends BasePage{

    public void isPageOpened(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oly old']")));
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ADDON_0']/div/div[2]/div/div[4]/a")));
            //(By.linkText("You're almost done"), "You're almost done"));
    }

    @Then("^I am on AlmostDone page$")
    public void iAmOnAlmostDonePage(){ isPageOpened();}

    @When("^I click on 'Learn more' link on AlmostDone page$")
    public ProtectYourPurchaseWithSQ iClickOnLearnMoreLinkOnAlmostDonePage(){
        click(By.xpath("//*[@id='ADDON_0']/div/div[2]/div/div[4]/a"));
        return new ProtectYourPurchaseWithSQ();
    }
    @When("^I click on 'No thanks' button on AlmostDone page$")
    public CartPayments iClickOnNoThanksButtonOnAlmostDonePage(){
        click(By.xpath("//button[.='No thanks']"));
        return new CartPayments();
    }
    @When("^I click on 'Add plan' button on AlmostDone page$")
    public CartPayments iClickOnAddPlanButtonOnAlmostDonePage() {
        click(By.xpath("//button[.='Add plan']"));
        return new CartPayments();
    }
}
