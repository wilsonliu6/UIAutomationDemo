package com.store.automation.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class MyDetailsPage {
    private WebDriver driver;

    public MyDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    @FindBy(xpath="//*[@id='post-31']/div/div/div/a[2]")
    WebElement yourDetails;

    @FindBy(id="wpsc_checkout_form_2")
    WebElement firstName;

    @FindBy(id="wpsc_checkout_form_3")
    WebElement lastName;

    @FindBy(id="wpsc_checkout_form_4")
    WebElement address;

    @FindBy(id="wpsc_checkout_form_5")
    WebElement city;

    @FindBy(id="wpsc_checkout_form_7")
    WebElement country;

    @FindBy(id="wpsc_checkout_form_8")
    WebElement postalCode;

    @FindBy(id="wpsc_checkout_form_18")
    WebElement phone;

    @FindBy(xpath="//*[@id='shippingSameBilling']")
    WebElement billingCheck;

    @FindBy(xpath="//*[@value='Save Profile']")
    WebElement saveProfile;

    @FindBy(xpath="//*[@id='meta']/ul/li[2]/a")
    WebElement logout;

    public WebElement enterYourDetails(){
        return yourDetails;
    }

    public WebElement getFirstName(){
        return firstName;
    }

    public WebElement getlastName(){
        return lastName;
    }

    public WebElement getAddress(){
        return address;
    }

    public WebElement getCity(){
        return city;
    }

    public void selectCountry(){
        new Select(country).selectByVisibleText("USA");
    }

    public WebElement getCountry(){
        return country;
    }

    public WebElement getPostalCode(){
        return postalCode;
    }

    public WebElement getPhone(){
        return phone;
    }

    public void clickBillingCheck(){
        if(billingCheck.isSelected() != true){
            billingCheck.click();
        }
    }

    public void clickSaveProfile(){
        saveProfile.click();
    }

    public void logout(){
        logout.click();
    }
}
