package com.store.automation.web;

import com.store.automation.web.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogInPage {
    private final WebDriver driver;

    @FindBy(id = "login")
    private WebElement logInButton;

    @FindBy(id = "log")
    private WebElement inputUserName;

    @FindBy(id = "pwd")
    private WebElement inputPassword;

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputUserName(String userName){
        Utils.cleanAndType(inputUserName, userName);
    }

    public void inputPassword(String password){
        Utils.cleanAndType(inputPassword, password);
    }

    public IPhonePage clickLogInButton(){
        logInButton.click();
        return PageFactory.initElements(driver, IPhonePage.class);
    }
}
