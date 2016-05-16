package com.store.automation.web;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RemoveFromCartPageTest extends TestBase {
    @Test(priority = 2)
    public void testRemoveFromMyCart(){
        RemoveFromCartPage cartPage = PageFactory.initElements(driver, RemoveFromCartPage.class);
        cartPage.clickCheckOut();
        cartPage.clickRemove();
        String text = cartPage.getCartText().getText();
        System.out.println("Value in text");
        Assert.assertEquals(text, "Oops, there is nothing in your cart.");
    }
}
