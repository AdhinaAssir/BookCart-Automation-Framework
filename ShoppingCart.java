package com.POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {

public WebDriver Driver;
	
	public ShoppingCart (WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);		
}
	@FindBy(xpath = "//*[@id=\"wpmenucartli\"]/a") private WebElement CartBTN;
    public WebElement getCartBTN() {
 	   return CartBTN;  
    }
	@FindBy(xpath ="//*[@id=\"page-34\"]/div/div[1]/div/div/div/a") private WebElement ProceesToCheckout;
    public WebElement getProceesToCheckout() {
 	   return ProceesToCheckout;  
}
    @FindBy(id = "billing_first_name") private WebElement billing_first_name;
    public WebElement getbilling_first_name() {
 	   return billing_first_name; 
    }
    @FindBy(id = "billing_last_name") private WebElement billing_last_name;
    public WebElement getbilling_last_name() {
 	   return billing_last_name;
    }
    @FindBy(id = "billing_company") private WebElement billing_company;
    public WebElement getbilling_company() {
 	   return billing_company;
    }
    @FindBy(id = "billing_email") private WebElement billing_email;
    public WebElement getbilling_email() {
 	   return billing_email;
    }
    @FindBy(id = "billing_phone") private WebElement billing_phone;
    public WebElement getbilling_phone() {
 	   return billing_phone;
    }
    @FindBy(id = "s2id_autogen1_search") private WebElement CountrySel;
    public WebElement getCountrySel() {
 	   return CountrySel;
    }
    @FindBy(id = "billing_address_1") private WebElement billingaddress1;
    public WebElement getbillingaddress1() {
 	   return billingaddress1;
    }
    @FindBy(id = "billing_address_2") private WebElement billingaddress2;
    public WebElement getbillingaddress2() {
 	   return billingaddress2;
    }
    @FindBy(id = "billing_city") private WebElement billingcity;
    public WebElement getbillingcity() {
 	   return billingcity;
    }
    @FindBy(id = "s2id_autogen2_search") private WebElement StateSel;
    public WebElement getStateSel() {
 	   return StateSel;
    }
    @FindBy(id = "billing_postcode") private WebElement billing_postcode;
    public WebElement getbilling_postcode() {
 	   return billing_postcode;
    }
    @FindBy(id = "payment_method_cod") private WebElement payment_method_cod;
    public WebElement getpayment_method_cod() {
 	   return payment_method_cod;
    }
    @FindBy(id = "place_order") private WebElement placeorderBTN;
    public WebElement getplaceorderBTN() {
 	   return placeorderBTN;
    }
    @FindBy(id = "order_comments") private WebElement ordercomments;
    public WebElement getordercomments() {
 	   return ordercomments;
    }
}










































