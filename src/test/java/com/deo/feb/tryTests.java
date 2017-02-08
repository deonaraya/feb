package com.deo.feb;

import com.deo.feb.Common.DriverManager;
import com.deo.feb.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



/**
 * Created by chandrad on 2/3/17.
 */
public class tryTests {

    WebDriver driver = null;
    static final Logger LOGGER = LogManager.getLogger(tryTests.class.getName());
    String baseURL = "http://automationpractice.com/index.php";



    @Test
    public void printProductNames(){
        driver = DriverManager.getDriver();
        driver.get(baseURL);
        HomePage page = new HomePage(driver);
        page.getProductNames();
    }

    @Test
    public void printProductPrices(){
        driver = DriverManager.getDriver();
        driver.get(baseURL);
        HomePage page = new HomePage(driver);
        page.getProductPrices();
    }

    @Test
    public void addProductToCart(){
        driver = DriverManager.getDriver();
        driver.get(baseURL);
        HomePage page = new HomePage(driver);
        page.addToCart().waitUntilPageLoads().assertSuccessMessage();
    }

}