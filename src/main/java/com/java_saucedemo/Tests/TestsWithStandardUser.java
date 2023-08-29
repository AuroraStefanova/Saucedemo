package com.java_saucedemo.Tests;

import com.java_saucedemo.BrowserFactory.BrowserFactory;
import com.java_saucedemo.Pages.Login.Login;
import com.java_saucedemo.Pages.BurgerMenu.BurgerMenu;
import com.java_saucedemo.Pages.Products.Inventory;
import com.java_saucedemo.Pages.ShopingCard.Cart;
import com.java_saucedemo.Pages.ShopingCard.CheckoutComplete;
import com.java_saucedemo.Pages.ShopingCard.CheckoutStepOne;
import com.java_saucedemo.Pages.ShopingCard.CheckoutStepTwo;
import com.java_saucedemo.Helpers.Waits;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestsWithStandardUser {
    private static String typeOfTheBrowser = "Firefox";
    static WebDriver driver = BrowserFactory.getBrowser(typeOfTheBrowser);;
    private static String customerLoginUrl = "https://www.saucedemo.com/";
    static Login loginPage = new Login(driver);
    static Inventory inventoryPage = new Inventory(driver);
    static Cart cartPage = new Cart(driver);
    static CheckoutStepOne checkoutStepOnePage = new CheckoutStepOne(driver);
    static CheckoutStepTwo checkoutStepTwo = new CheckoutStepTwo(driver);
    static CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
    static BurgerMenu burgerMenu = new BurgerMenu(driver);
    static Waits customWait = new Waits();
    static String currentURL;

    @BeforeEach
    public void OpenWebsite(){
        driver.get(customerLoginUrl);

        currentURL = driver.getCurrentUrl();

        customWait.customWait(driver, Duration.ofSeconds(15), "visibilityOfElementLocated", loginPage.login);

        Assertions.assertEquals(currentURL, "https://www.saucedemo.com/");
    }
    @Test
    @Order(1)
    public void wrongPasswordOfStandardUser(){
        loginPage.validateUrl();
        loginPage.LoginUser("standard_user", "secret_sauce1");
        loginPage.validateErrorMessage();
    }
    @Test
    @Order(2)
    public void completeShoppingWithNormalUser(){
        loginPage.validateUrl();
        loginPage.LoginUser("standard_user", "secret_sauce");

        inventoryPage.validateUrl();
        inventoryPage.addOneProductToCart();

        cartPage.clickCartLink();
        cartPage.validateUrl();
        cartPage.clickCheckoutButton();

        checkoutStepOnePage.validateUrl();
        checkoutStepOnePage.pressContinueButton();
        checkoutStepOnePage.validateErrorMessage();
        checkoutStepOnePage.addInformationToFields("Petar", "Petrov", "1123");
        checkoutStepOnePage.pressContinueButton();

        checkoutStepTwo.validateUrl();
        checkoutStepTwo.checkTitle();
        checkoutStepTwo.checkCartList();
        checkoutStepTwo.finishOrder();

        checkoutComplete.validateURL();
        checkoutComplete.backToProductPage();

        inventoryPage.validateUrl();

        burgerMenu.openBurgerMenu();
        burgerMenu.logoutUser();

        loginPage.validateUrl();
    }
    @Test
    @Order(3)
    public void removeItemsWitNormalUser(){
        loginPage.validateUrl();
        loginPage.LoginUser("standard_user", "secret_sauce");

        inventoryPage.validateUrl();
        inventoryPage.validateTitle();
        inventoryPage.addOneProductToCart();
        inventoryPage.validateTitle();
        inventoryPage.clickAddToCartLink();

        cartPage.validateRemoveButtonVisibility();
        cartPage.removeProductFromCart();
        cartPage.validateNotExistingOfCartBadge();

        burgerMenu.openBurgerMenu();
        burgerMenu.logoutUser();

        loginPage.validateUrl();
    }
    @Test
    @Order(4)
    public void normalUserAddItems(){
        loginPage.LoginUser("standard_user", "secret_sauce");

        inventoryPage.validateUrl();
        inventoryPage.addTwoProductsToCart();
        inventoryPage.validateTitle();
        inventoryPage.verifiedShoppingCartBadge();

        cartPage.clickCartLink();
        cartPage.validateUrl();
        cartPage.validateCartList();

        burgerMenu.openBurgerMenu();
        burgerMenu.logoutUser();

        loginPage.validateUrl();
        driver.close();
    }
}
