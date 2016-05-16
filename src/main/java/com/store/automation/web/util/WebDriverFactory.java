package com.store.automation.web.util;

import com.store.automation.web.enums.EnumSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WebDriverFactory {
    /**
     *
     * @param browser
     *     Valid values(both lower case or upper case): chrome, firefox, ie, htmlunit
     * @return
     *     WebDriver
     * @throws Exception
     */
    public static WebDriver getWebDriver(String browser) throws Exception{
        WebDriver driver = null;
        String browserUpperCase = browser.toUpperCase();
        EnumSystem system = Utils.getSystem();
        boolean is64Bit = Utils.is64Bit();
        System.out.println(String.format("*** Current system is %s ***", system.toString()));

        if(browserUpperCase.equals("CHROME")){
            if(system == EnumSystem.WINDOWS){
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win.exe");
                driver = new ChromeDriver();
                System.out.println("Using Windows 32 chrome driver");
            }else if(system == EnumSystem.MAC){
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_mac32.exe");
                driver = new ChromeDriver();
                System.out.println("Using MAC 32 chrome driver");
            }else if(system == EnumSystem.LINUX){
                if(is64Bit) {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_linux64.exe");
                    driver = new ChromeDriver();
                    System.out.println("Using 64 Linux chrome driver");
                }else {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_linux32.exe");
                    driver = new ChromeDriver();
                    System.out.println("Using 32 Linux chrome driver");
                }
            }
        } else if(browserUpperCase.equals("FIREFOX")){
            driver = new FirefoxDriver();
            System.out.println("Using Firefox driver");
        } else if(browserUpperCase.equals("IE")){
            if(system == EnumSystem.WINDOWS) {
                if(is64Bit) {
                    System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer64.exe");
                    driver = new InternetExplorerDriver();
                    System.out.println("Using 64 IE driver");
                }else {
                    System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer32.exe");
                    driver = new InternetExplorerDriver();
                    System.out.println("Using 32 IE driver");
                }
            }else {
                throw new Exception("Current system is not windows which doesn't support IE browser");
            }
        } else if(browserUpperCase.equals("HTMLUNIT")){
            driver = new HtmlUnitDriver();
        }
        else {
            throw new Exception("Please give a valid browser: firefox, chrome, ie, htmlunit");
        }

        return driver;
    }
}
