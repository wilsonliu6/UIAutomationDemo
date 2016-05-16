package com.store.automation.web.util;

import com.store.automation.web.enums.EnumSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.lang3.SystemUtils;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Utils {
    static final String AB = "abcdefghijklmnopqrstuvwxyz";

    public static void cleanAndType(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public static void initWebDriver(WebDriver driver, String url){
        if(null != driver){
            System.out.println(String.format("Init web driver with url: %s", url));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get(url);
            driver.manage().window().maximize();
        }
    }

    public static void closeWebDriver(WebDriver driver){
        if(null != driver){
            System.out.println("*** Close web driver ***");
            driver.quit();

            try {
                driver.close();
            }catch (Exception e){

            }
        }
    }

    public static String generateNewEmailAddress(){
        int len = 15;
        StringBuilder sb = new StringBuilder(len);
        Random rnd = new Random();

        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );

        return sb.toString() + "@gmail.com";
    }

    public static EnumSystem getSystem() {
        if(SystemUtils.IS_OS_WINDOWS_7) {
            System.out.println("It's a Windows 7 OS");
            return EnumSystem.WINDOWS;
        }
        if(SystemUtils.IS_OS_WINDOWS_8) {
            System.out.println("It's a Windows 8 OS");
            return EnumSystem.WINDOWS;
        }
        if(SystemUtils.IS_OS_LINUX) {
            System.out.println("It's a Linux OS");
            return EnumSystem.LINUX;
        }
        if(SystemUtils.IS_OS_MAC) {
            System.out.println("It's a MAC OS");
            return EnumSystem.MAC;
        }

        return EnumSystem.LINUX.UNKOWN;
    }

    public static boolean is64Bit(){
        String arch = System.getenv("PROCESSOR_ARCHITECTURE");
        String wow64Arch = System.getenv("PROCESSOR_ARCHITEW6432");
        return arch.endsWith("64") || wow64Arch != null && wow64Arch.endsWith("64") ? true: false;
    }

//    private String getFileName(){
//        return getClass().getClassLoader().getResource("chromedriver_linux32").getFile();
//    }
//    public static void main(String[] args){
//        System.out.println(SystemUtils.getUserDir());
//        System.out.println(SystemUtils.getUserHome());
//        System.out.println(Utils.generateNewEmailAddress());
//        Utils u = new Utils();
//        System.out.println(u.getFileName());
//    }
}
