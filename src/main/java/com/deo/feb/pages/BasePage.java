package com.deo.feb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by chandrad on 2/3/17.
 */
public abstract class BasePage {

    protected WebDriver driver ;
    protected WebDriverWait wait ;
    protected static final int PAGE_LOAD_TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(WebElement element){
        wait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
