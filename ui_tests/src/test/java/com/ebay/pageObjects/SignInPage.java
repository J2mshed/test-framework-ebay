package com.ebay.pageObjects;

import com.ebay.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ebay.helpers.ElementsInteraction.getWait;

public class SignInPage extends BasePage {
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleContains("Sign in or Register | eBay"));
    }


}
