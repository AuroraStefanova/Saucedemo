package com.java_saucedemo.Pages.ShopingCard;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
    WebDriver driver;
    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCart;
    @FindBy(css = ".cart_button")
    WebElement removeButton;
    @FindBy(css = "#continue-shopping")
    WebElement continueShoppingButton;
    @FindBy(css = "#checkout")
    WebElement checkout;
    @FindBy(css = "#remove-sauce-labs-bolt-t-shirt")
    WebElement removeThirdProduct;
    @FindBy(css = ".cart_list")
    WebElement cartLis;

    public Cart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
   public void clickCartLink() {
       this.shoppingCart.click();
   }
    public void clickCheckoutButton(){
        this.checkout.click();
    }
    public void continueShopping(){
        this.continueShoppingButton.click();
    }
    public void validateUrl(){
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://www.saucedemo.com/cart.html", "URL is not equal");
    }
    public void validateRemoveButtonVisibility(){
        Assertions.assertEquals(true, this.removeButton.isDisplayed());
    }
    public void removeProductFromCart(){
        this.removeThirdProduct.click();
    }
    public void validateCartList(){
        Assertions.assertEquals(true, cartLis.isDisplayed());
    }
    public void validateNotExistingOfCartBadge(){
        int sizeOfElement = driver.findElements(By.cssSelector(".cart_quantity")).size();
        Assertions.assertEquals(0, sizeOfElement, "There is a element in cart");
    }
}
