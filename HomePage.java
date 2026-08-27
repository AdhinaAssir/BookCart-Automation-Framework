package com.POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public WebDriver Driver;


public HomePage (WebDriver Driver) {
	this.Driver = Driver;
	PageFactory.initElements(Driver, this);
	
}
       @FindBy(xpath = "//*[@id=\"menu-item-40\"]/a") private WebElement Shop;
       public WebElement getShop() {
    	   return Shop;
       }
       
       @FindBy(linkText = "My Account") private WebElement MyAccount;
       public WebElement getMyAccount() {
    	   return MyAccount;
       }
}
