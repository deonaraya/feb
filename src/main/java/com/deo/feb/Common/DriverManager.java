package com.deo.feb.Common;

import org.openqa.selenium.WebDriver;

/**
 * Created by chandrad on 2/7/17.
 */
public class DriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() { return webDriver.get(); }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static void cleanup() {
        webDriver.remove();
    }

}
