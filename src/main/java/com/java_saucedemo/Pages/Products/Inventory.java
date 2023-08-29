package com.java_saucedemo.Pages.Products;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory {
    WebDriver driver;
    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    WebElement thirdProduct;
    @FindBy(css = "#add-to-cart-sauce-labs-bike-light")
    WebElement firstProduct;
    @FindBy(css = "#add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement secondProduct;
    @FindBy(css = ".shopping_cart_link")
    WebElement ShoppingCartLink;
    @FindBy(xpath = "//*[@id=\"item_4_img_link\"]/img")
    WebElement firstImage;
    @FindBy(xpath = "//*[@id=\"item_0_img_link\"]/img")
    WebElement secondImage;
    String srcOfFirstImage;
    String srcOfSecondImage;
    static String actualUrl;

    public Inventory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void clickAddToCartLink() {
        this.ShoppingCartLink.click();
    }
    public void addTwoProductsToCart(){
        this.firstProduct.click();
        this.thirdProduct.click();
    }
    public void addOneProductToCart(){
        this.secondProduct.click();
    }
    public void validateUrl(){
        actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html", "The URL are not equals!");
    }
    public void validateTitle(){
        String actualTitle = driver.findElement(By.className("title")).getText();
        Assertions.assertEquals(actualTitle,"Products", "Title is not equal");
    }
    public void verifiedDifferenceOfTheImages(){
        srcOfFirstImage = this.firstImage.getAttribute("src");
        srcOfSecondImage = this.secondImage.getAttribute("src");
        Assertions.assertNotEquals(srcOfFirstImage,srcOfSecondImage, "The images are equals");
    }
    public void verifiedShoppingCartBadge(){
        int sizeOfElement = driver.findElements(By.cssSelector(".shopping_cart_badge")).size();
        Assertions.assertEquals(1, sizeOfElement,"There is a problem with shopping cart");
    }
}
