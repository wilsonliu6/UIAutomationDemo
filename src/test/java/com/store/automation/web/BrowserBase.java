package com.store.automation.web;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class BrowserBase {
    protected static String browser = null;

    @BeforeSuite
    @Parameters("browser")
    public void setBrowser(String browser){
        BrowserBase.browser = browser;
    }
}
