package com.java_saucedemo.Pages.ShopingCard;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwo {
    WebDriver driver;
    @FindBy(css = "#finish")
    WebElement finishButton;
    @FindBy(css = ".cart_list")
    WebElement itemToCart;
    @FindBy(css = ".title")
    WebElement checkoutTitle;
    static String actualUrl;
    static String message;
    public CheckoutStepTwo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void finishOrder(){
        this.finishButton.click();
    }
    public void checkTitle(){
        message = this.checkoutTitle.getText();
        Assertions.assertEquals(message, "Checkout: Overview", "The title is not equal!");
    }
    public void checkCartList(){
        this.itemToCart.isDisplayed();
    }
    public void validateUrl(){
        actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://www.saucedemo.com/checkout-step-two.html", "The URL are not equal!");
    }
}
