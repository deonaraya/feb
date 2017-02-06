package com.deo.feb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by chandrad on 2/3/17.
 */
public class AddToCartPopUp extends BasePage {

    public AddToCartPopUp(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

        @FindBy(xpath = "//i[@class='icon-ok']/parent::h2")
        private WebElement cartSuccessMessage ;

        @FindBy(xpath = "//a[@title='Proceed to checkout']")
        private WebElement checkoutStep1Button ;

        @FindBy(id = "layer_cart_product_title")
        private static WebElement addedprocutName ;

    public AddToCartPopUp waitUntilPageLoads(){
        waitForElement(cartSuccessMessage);
        return this ;
    }

    public AddToCartPopUp assertSuccessMessage(){
        Assert.assertEquals(cartSuccessMessage.getText(),"should fail");
        return this;
    }

}
