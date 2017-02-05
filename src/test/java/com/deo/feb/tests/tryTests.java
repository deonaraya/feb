package com.deo.feb.tests;

import com.deo.feb.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



/**
 * Created by chandrad on 2/3/17.
 */
public class tryTests {

    private WebDriver driver ;
    static final Logger LOGGER = LogManager.getLogger(tryTests.class.getName());
    String baseURL = "http://automationpractice.com/index.php";


    @BeforeMethod
    public void setUp(){

//        System.setProperty("webdriver.firefox.marionette","/Users/chandrad/Documents/DeoTrainings/feb/src/main/resources/geckodriver");
//        driver = new FirefoxDriver();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void testOne(){

        HomePage page = new HomePage(driver);
        page.getProductNames().getProductPrices().openBestSellerCatalog().openPopularCatalog().addToCart() ;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}