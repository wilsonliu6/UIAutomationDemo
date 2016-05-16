package com.store.automation.web;

import com.store.automation.web.enums.EnumUrls;
import com.store.automation.web.util.Utils;
import com.store.automation.web.util.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;


public class TestBase extends BrowserBase {
    protected static WebDriver driver;

    @BeforeSuite
    public void SetUp(){
        try {
            System.out.println(String.format("*** Create web driver for browser: %s ***", browser));
            driver = WebDriverFactory.getWebDriver(browser);
            driver.get(EnumUrls.STORE_BASE_URL.getValue());
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @AfterSuite
    public void TearDown(){
        Utils.closeWebDriver(driver);
    }

    public IPhonePage LogIn(){
        Utils.initWebDriver(driver, EnumUrls.STORE_MY_ACCOUNT_URL.toString());
        LogInPage myAccountPage = PageFactory.initElements(driver, LogInPage.class);
        myAccountPage.inputUserName("wilson");
        myAccountPage.inputPassword("WdDEMOQA123$%^");
        IPhonePage IPhonePage = myAccountPage.clickLogInButton();

        Assert.assertTrue(driver.getCurrentUrl().startsWith(EnumUrls.STORE_MY_ACCOUNT_PRODUCT_PAGE_URL.getValue()), "Wrong sign up page url");

        return IPhonePage;
    }
}
