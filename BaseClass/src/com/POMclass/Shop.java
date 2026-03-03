package com.POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shop {
	public WebDriver Driver;
	
	public Shop (WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
}
	
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[1]/a[2]") private WebElement Product;
    public WebElement getProduct() {
 	   return Product;  
}
}