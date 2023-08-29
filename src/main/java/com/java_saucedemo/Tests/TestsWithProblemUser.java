package com.java_saucedemo.Tests;

import com.java_saucedemo.BrowserFactory.BrowserFactory;
import com.java_saucedemo.Pages.BurgerMenu.BurgerMenu;
import com.java_saucedemo.Pages.Login.Login;
import com.java_saucedemo.Pages.Products.Inventory;
import com.java_saucedemo.Helpers.Waits;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class TestsWithProblemUser {
    private static String typeOfTheBrowser = "Firefox";
    static WebDriver driver = BrowserFactory.getBrowser(typeOfTheBrowser);;
    private static String customerLoginUrl = "https://www.saucedemo.com/";
    static Login loginPage = new Login(driver);
    static Inventory inventoryPage = new Inventory(driver);
    static BurgerMenu burgerMenu = new BurgerMenu(driver);
    static Waits customWait = new Waits();
    static String currentURL;

    @BeforeEach
    public void OpenWebsite(){
        driver.get(customerLoginUrl);

        currentURL = driver.getCurrentUrl();

        customWait.customWait(driver, Duration.ofSeconds(20), "visibilityOfElementLocated",loginPage.login);

        Assertions.assertEquals(currentURL, "https://www.saucedemo.com/", "The Url is different");
    }
    @Test
    @Order(1)
    public void testPictureEqualsOfProductsWithProblemUser(){
        loginPage.LoginUser("problem_user", "secret_sauce");

        inventoryPage.validateUrl();
        inventoryPage.verifiedDifferenceOfTheImages();
    }
    @Test
    @Order(2)
    public void addingProductWithProblemUser(){
        loginPage.LoginUser("problem_user", "secret_sauce");

        inventoryPage.validateUrl();
        inventoryPage.addOneProductToCart();
        inventoryPage.clickAddToCartLink();
        inventoryPage.verifiedShoppingCartBadge();

        driver.close();
    }
}
