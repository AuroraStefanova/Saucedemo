package com.java_saucedemo.Pages.Login;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;
    static String actualUrl;
    public By errorForLockedUser = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    public By errorWithWrongPassword = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    public By login = By.cssSelector("#login-button");
    static String actualResult;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void LoginUser(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginButton.click();
    }
    public void validateErrorMessage(){
        actualResult = driver.findElement(errorWithWrongPassword).getText();
        Assertions.assertEquals(actualResult, "Epic sadface: Username and password do not match any user in this service","The message is not equal");
    }
    public void validateUrl(){
        actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl,"https://www.saucedemo.com/", "The URL is not equal!");
    }
}
