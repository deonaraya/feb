package com.deo.feb.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by chandrad on 2/3/17.
 */
public class HomePage extends BasePage  {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "home-page-tabs")
    private WebElement catalogTabs ;

    @FindBy(className = "blockbestsellers")
    private WebElement bestSellerCatalog ;

    @FindBy(className = "homefeatured")
    private WebElement popularCatalog ;

    //concept of list of weblements ...
    @FindBy(xpath="//ul[@id='homefeatured']/li//div[@class='right-block']//a[@class='product-name']")
    private List<WebElement> productNames ;

    //concept of list of weblements ...
    @FindBy(xpath="//ul[@id='homefeatured']/li//div[@class='right-block']//span[@itemprop='price']")
    private List<WebElement> productPrices ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]/div")
    private WebElement productContainer1 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[2]/div")
    private WebElement productContainer2 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]/div")
    private WebElement productContainer3 ;

    //concept of index
    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]//div[@class='right-block']//a[@class='product-name']")
    private static WebElement productName1 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[2]//div[@class='right-block']//a[@class='product-name']")
    private WebElement productName2 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]//div[@class='right-block']//a[@class='product-name']")
    private WebElement productName3 ;

    //concept of custom attributes
    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]//div[@class='right-block']//span[@itemprop='price']")
    private WebElement productPrice1 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[2]//div[@class='right-block']//span[@itemprop='price']")
    private WebElement productPrice2 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]//div[@class='right-block']//span[@itemprop='price']")
    private WebElement productPrice3 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]//div[@class='right-block']//a[@title='Add to cart']")
    private WebElement addToCartButton1 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[2]//div[@class='right-block']//a[@title='Add to cart']")
    private WebElement addToCartButton2 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]//div[@class='right-block']//a[@title='Add to cart']")
    private WebElement addToCartButton3 ;

    static final Logger LOGGER = LogManager.getLogger(HomePage.class.getName());

    public HomePage openPopularCatalog(){
        popularCatalog.click();
        LOGGER.info("<<  opening POPULAR catalog >>");
        return new HomePage(driver);
    }

    public HomePage openBestSellerCatalog(){
        bestSellerCatalog.click();
        LOGGER.info("<<  opening BEST SELLER catalog >>");
        return new HomePage(driver);
    }

    public HomePage getProductNames(){
        for (WebElement name: productNames) {
            LOGGER.info("<<  Printing catalog item names  >>" + name.getText());
            System.out.println("<< Below product are listed in catalog : " + name.getText() + " >>");
        }
        return new HomePage(driver);
    }

    public HomePage getProductPrices(){
        for (WebElement price: productPrices) {
            LOGGER.info("<<  Printing catalog item prices  >>" + price.getText());
            System.out.println("<< Below prices are listed in catalog : " + price.getText() + " >>");
        }
        return new HomePage(driver);
    }


    public AddToCartPopUp addToCart(){
        LOGGER.info("<< Using Action driver to simulate mouse hover scenario >>");
        Actions action = new Actions(driver);
        action.moveToElement(productContainer1).build().perform();
        LOGGER.info("<< waiting for add to cart button to appear >>");
        waitForElement(addToCartButton1);
        addToCartButton1.click();
        return new AddToCartPopUp(driver);
    }

}