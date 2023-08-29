package com.java_saucedemo.Pages.ShopingCard;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOne {
    WebDriver driver;
    @FindBy(css = "#first-name")
    WebElement firstName;
    @FindBy(css = "#last-name")
    WebElement lastName;
    @FindBy(css = "#postal-code")
    WebElement zipPostCode;
    @FindBy(css = "#continue")
    WebElement continueButton;
    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")
    WebElement errorMessage;
     static String actualUrl;
     static String message;

    public CheckoutStepOne(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void pressContinueButton(){
        this.continueButton.click();
    }
    public void addInformationToFields(String firstName, String lastName, String zipCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipPostCode.sendKeys(zipCode);
    }
    public void validateUrl(){
        actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl,"https://www.saucedemo.com/checkout-step-one.html", "The URL is not equal!");
    }
    public void validateErrorMessage(){
        message = this.errorMessage.getText();
        Assertions.assertEquals(message, "Error: First Name is required", "The messages is not equal!");
    }
}
