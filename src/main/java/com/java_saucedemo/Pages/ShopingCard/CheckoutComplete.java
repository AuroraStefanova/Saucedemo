package com.java_saucedemo.Pages.ShopingCard;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {
    WebDriver driver;
    @FindBy(css = "#back-to-products")
    WebElement backHomeButton;
    static String actualUrl;

    public CheckoutComplete(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void backToProductPage(){
        this.backHomeButton.click();
    }
    public void validateURL() {
        actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://www.saucedemo.com/checkout-complete.html", "The URL are not equals!");
    }
}
