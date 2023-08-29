package com.java_saucedemo.Tests;

import com.java_saucedemo.BrowserFactory.BrowserFactory;
import com.java_saucedemo.Pages.Login.Login;
import com.java_saucedemo.Helpers.Waits;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class TestsWithLockedUser {
    private static String typeOfTheBrowser = "Firefox";
    static WebDriver driver = BrowserFactory.getBrowser(typeOfTheBrowser);;
    private static String customerLoginUrl = "https://www.saucedemo.com/";
    static Login loginPage = new Login(driver);
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
    public void loginWithLockedUser(){
        loginPage.validateUrl();
        loginPage.LoginUser("locked_out_user", "secret_sauce");

        String actualResult = driver.findElement(loginPage.errorForLockedUser).getText();
        Assertions.assertEquals(actualResult, "Epic sadface: Sorry, this user has been locked out.");

        driver.close();
    }
}
