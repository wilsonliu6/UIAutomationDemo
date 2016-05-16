package com.store.automation.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class IPhonePage {
    private WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    @FindBy(xpath="//*[@id='menu-item-33']/a")
    WebElement productCategory;

    @FindBy(xpath="//*[@id='menu-item-37']/a")
    WebElement iPhones;

    @FindBy(partialLinkText="Apple iPhone 4S 16GB SIM-Free")
    WebElement iPhone4s;

    @FindBy(xpath="//*[@value='Add To Cart']")
    WebElement addToCart;

    @FindBy(linkText="Go to Checkout")
    WebElement checkOut;

    @FindBy(xpath="//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")
    WebElement countIncrement;

    @FindBy(xpath="//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[3]/form/input[4]")
    WebElement update;

    @FindBy(xpath="//*[@id='checkout_page_container']/div[1]/a/span")
    WebElement checkOutCont;

    @FindBy(id="current_country")
    WebElement country;

    @FindBy(xpath="//*[@id='change_country']/input[4]")
    WebElement calculate;

    @FindBy(xpath="//*[@id='wpsc_shopping_cart_container']/form/div[4]/div/div/span/input")
    WebElement purchase;

    @FindBy(xpath="//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[5]/span/span")
    WebElement totalPrice;

    public IPhonePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickProductCategory(){
        Actions actions = new Actions(driver);
        actions.moveToElement(productCategory).build().perform();
    }

    public void clickIPhones(){
        try {
            iPhones.click();
        }catch (Exception e){
            System.out.println("Try again to find the iPhones page");
            iPhones = driver.findElement(By.xpath("//*[@id='menu-item-37']/a"));
            iPhones.click();
        }
    }

    public void clickIphone4s(){
        try {
            iPhone4s.click();
        }catch (Exception e){
            System.out.println("Try again to find the iPhone4s element");
            iPhone4s = driver.findElement(By.partialLinkText("Apple iPhone 4S 16GB SIM-Free"));
            iPhone4s.click();
        }
    }

    public void clickAddToCart(){
        addToCart.click();
    }

    public void clickCheckOut(){
        checkOut.click();
    }

    public WebElement enterCount(){
        return countIncrement;
    }

    public void clickUpdate(){
        update.click();
    }

    public void clickCheckOutCont(){
        checkOutCont.click();
    }

    public void selectCountry(){
        new Select(country).selectByVisibleText("USA");
    }

    public void clickCalculate(){
        calculate.click();
    }

    public void clickPurchase(){
        purchase.click();
    }

    public WebElement getTotalPrice(){
        return totalPrice;
    }
}
