package com.store.automation.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RemoveFromCartPage {
    private WebDriver driver;

    public RemoveFromCartPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath="//*[@id='header_cart']/a")
    WebElement checkOut;

    @FindBy(xpath="//*[@value='Remove']")
    WebElement remove;

    @FindBy(xpath="//*[@id='post-29']/div")
    WebElement nothingInCart;

    public void clickCheckOut(){
        checkOut.click();
    }

    public void clickRemove(){
        remove.click();
    }

    public WebElement getCartText(){
        return nothingInCart;
    }
}
