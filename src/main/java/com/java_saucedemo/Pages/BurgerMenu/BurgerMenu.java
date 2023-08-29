package com.java_saucedemo.Pages.BurgerMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BurgerMenu {
    WebDriver driver;
    @FindBy(css = "#react-burger-menu-btn")
    WebElement burgerMenu;
    @FindBy(css = "#logout_sidebar_link")
    WebElement logoutLink;
    @FindBy(css = "#inventory_sidebar_link")
    WebElement allItemsLink;
    @FindBy(css = "#about_sidebar_link")
    WebElement aboutLink;
    @FindBy(css = "#reset_sidebar_link")
    WebElement restAppStateLink;

    public BurgerMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void openBurgerMenu(){
        this.burgerMenu.click();
    }
    public void logoutUser(){
        this.logoutLink.click();
    }
    public void openAllItemPage(){
        this.allItemsLink.click();
    }
    public void aboutLinkPageOpen(){
        this.aboutLink.click();
    }
    public void openRestAppState(){
        this.restAppStateLink.click();
    }
}
