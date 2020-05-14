package com.ebay.pageObjects;

import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ebay.helpers.ElementsInteraction.getWait;

public class SignInPage {
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleContains("Sign in or Register | eBay"));
    }


}
