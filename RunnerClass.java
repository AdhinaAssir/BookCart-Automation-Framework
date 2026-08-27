package com.RunnerClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.POMclass.*;
public class RunnerClass extends BaseClass{
	
	@Test
	@Parameters({"mail","password","FirstName","LastName","Email","PhoneNO","Address1","Address2","City","ZipCode","ordercmnts"})
	public void RunTest(String mail,String password,String FirstName,String LastName,String Email,String PhoneNO,String Address1,String Address2,String City,String ZipCode,String ordercmnts) {
		
		BrowserLaunch("Chrome");
		urlPassing("https://practice.automationtesting.in/");
		assertEqualsText(driver.getCurrentUrl(),"https://practice.automationtesting.in/");
		ScreenShotss("Homepage");
		HomePage HP = new HomePage(driver);
		clickElements(HP.getMyAccount());
		ScreenShotss("MyAccPage");
		RegisterAcc RegAcc = new RegisterAcc(driver);
		Sendingkeys(RegAcc.getegMail(),mail);
		Sendingkeys(RegAcc.getRegPwd(),password);
		ScreenShotss("LoginAccPage");
		clickElements(RegAcc.getRegBtn());
		clickElements(HP.getShop());
		ScreenShotss("ShopPage");
		Shop productAQS = new Shop(driver);
		clickElements(productAQS.getProduct());
		ShoppingCart SC = new ShoppingCart(driver);
		clickElements(SC.getCartBTN());
		ScreenShotss("CartPage");
		clickElements(SC.getProceesToCheckout());
		Sendingkeys(SC.getbilling_first_name(),FirstName);
		Sendingkeys(SC.getbilling_last_name(),LastName);
		Sendingkeys(SC.getbilling_email(),Email);
		Sendingkeys(SC.getbilling_phone(),PhoneNO);
		clickElements(SC.getCountrySel());
		Sendingkeys(SC.getbillingaddress1(),Address1);
		Sendingkeys(SC.getbillingaddress2(),Address2);
		Sendingkeys(SC.getbillingcity(),City);
		clickElements(SC.getStateSel());
		Sendingkeys(SC.getbilling_postcode(),ZipCode);
		clickElements(SC.getpayment_method_cod());
		clickElements(SC.getplaceorderBTN());
		ScreenShotss("OrderPlaced");
		Sendingkeys(SC.getordercomments(),ordercmnts);
		
			
		
	}
}
