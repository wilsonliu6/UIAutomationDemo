package com.store.automation.web;

import org.testng.Assert;
import org.testng.annotations.Test;


public class IPhonePageTest extends TestBase {
    @Test(priority = 1)
    public void testAddIPhone4s2MyCart(){
        IPhonePage iPhonePage = this.LogIn();

        iPhonePage.clickProductCategory();
        iPhonePage.clickIPhones();
        iPhonePage.clickIphone4s();
        iPhonePage.clickAddToCart();

        iPhonePage.clickCheckOut();
        iPhonePage.enterCount().clear();
        iPhonePage.enterCount().sendKeys("3");
        iPhonePage.clickUpdate();
        iPhonePage.clickCheckOutCont();
        iPhonePage.selectCountry();
        iPhonePage.clickCalculate();

        iPhonePage.clickPurchase();
        String finalPrice = iPhonePage.getTotalPrice().getText();
        Assert.assertEquals(finalPrice, "$810.00");
    }
}
