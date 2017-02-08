package com.deo.feb.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;

/**
 * Created by chandrad on 2/6/17.
 */
public class DriverFactory {

    public static WebDriver getBrowserInstance(String browserName) {

        WebDriver driver = null;
        if (browserName.toLowerCase().contains("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        if (browserName.toLowerCase().contains("chrome")) {
          //  System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int Width = (int) toolkit.getScreenSize().getWidth();
            int Height = (int) toolkit.getScreenSize().getHeight();
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(Width, Height));
        }
        return driver;
    }
}
