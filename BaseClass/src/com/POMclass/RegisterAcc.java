package com.POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAcc {

	public WebDriver Driver;
	
	public RegisterAcc (WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
		
		
	}
	 @FindBy(id = "reg_email") private WebElement RegMail;
     public WebElement getegMail() {
  	   return RegMail;  	   
}
     @FindBy(id = "reg_password") private WebElement RegPwd;
     public WebElement getRegPwd() {
  	   return RegPwd; 
     }
     @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]") private WebElement RegBtn;
     public WebElement getRegBtn() {
  	   return RegBtn; 
     }
}
