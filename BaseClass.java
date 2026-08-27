package com.BaseClass;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.dataloader.Try;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.netty.handler.timeout.TimeoutException;




public class BaseClass{
	public static WebDriver driver;
	public static int wait = 15;
	public static WebDriverWait dynamicWait;
	public static JavascriptExecutor js;
	
	public static WebDriver BrowserLaunch(String browser) {
		try {
		
		if (browser.equalsIgnoreCase("Chrome")) {
			driver= new ChromeDriver();
		}else if((browser.equalsIgnoreCase("edge"))){
			driver= new EdgeDriver();
		}else {
			System.out.println("enter a valid brower name such as Chrome of Edge");
		}
		driver.manage().window().maximize();	  
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	    return driver;

  }
	
	

	
	public static void urlPassing(String Url) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
		driver.get(Url);
	}
	
	public static void Sendingkeys(WebElement element, String inputs) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	    try {
	        element.sendKeys(inputs);
	    } catch (Exception e1) {
	        System.out.println("Normal sendKeys failed, trying JS fallback...");

	        try {
	            if (driver == null) throw new IllegalStateException("WebDriver is null");
	            JavascriptExecutor js = (JavascriptExecutor) driver;   // local cast
	            js.executeScript(
	                "arguments[0].value = arguments[1];" +
	                "arguments[0].dispatchEvent(new Event('input'));" +
	                "arguments[0].dispatchEvent(new Event('change'));",
	                element, inputs
	            );
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	}

	
	public static void dropdownsSel(String input, String attr, WebElement element) {
	    try {
	        Select sel = new Select(element);

	        switch (input.toLowerCase()) {
	            case "text":
	                sel.selectByVisibleText(attr);
	                break;

	            case "value":
	                sel.selectByValue(attr);
	                break;

	            case "index":
	                sel.selectByIndex(Integer.parseInt(attr));
	                break;

	            default:
	                throw new IllegalArgumentException("Invalid dropdown select type: " + input);
	        }

	    } catch (Exception e) {
	        System.out.println("Dropdown selection failed → " + e.getMessage());
	    }
	}

	public static void ScreenShotss(String fileName)  {
		TakesScreenshot screen = (TakesScreenshot) driver;
		try {
		FileHandler.copy(screen.getScreenshotAs(OutputType.FILE), new File("./ScreenShots/"+fileName+".png"));
	    }catch(IOException e){
		e.printStackTrace();
	    }
		
   }
	public static void clickElements(WebElement element) {
		for(int i=0; i<3;i++) {
		try{
			dynamicWait = new WebDriverWait(driver,Duration.ofSeconds(wait));
			dynamicWait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
		catch(ElementClickInterceptedException | TimeoutException e) {
			js.executeScript("aguments[0].click();",element);
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
	}
}

	
	public static void clearSpace(WebElement element) {
		try {
			dynamicWait = new WebDriverWait(driver,Duration.ofSeconds(wait));
			dynamicWait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void assertEqualsText(String actual, String expected) {
	    try {
	        Assert.assertEquals(actual, expected);
	        System.out.println("✔ Assertion Passed: " + actual + " == " + expected);
	    } catch (AssertionError e) {
	        System.out.println("❌ Assertion Failed: Expected = " + expected + " | Actual = " + actual);
	        throw e;
	    }
	}


	
	public static void scrollScreen(WebDriver driver) {
		
		js.executeScript("window.scrollBy(0, 300);");

		
		
	}
	
	public static void dropdown(WebElement element, String selectionType, String value) {
		
		dynamicWait = new WebDriverWait(driver,Duration.ofSeconds(wait));
		dynamicWait.until(ExpectedConditions.elementToBeClickable(element));
		
		Select select = new Select(element);
		
		switch (selectionType.toLowerCase()) {
	
		case "text":
		case "visibleText":
		           select.selectByVisibleText(value);
		           break;
		
		case "value":
			  select.selectByValue(value);
			  break;
			  
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		default:
			throw new IllegalArgumentException("Unexpected value");
		}
	}
	
	


}
	

   

