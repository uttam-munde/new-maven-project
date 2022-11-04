package com.mycompany.app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert_demo_Test {
		public WebDriver driver;
		public SoftAssert softassert1;
	  @Test(priority = 1)
	  public void launchBrowser() 
	  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vithu\\May-selenium-2022\\Binary\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.facebook.com/");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  }
	  @Test(priority = 2)
	  public void checktitle()
	  {
		  String expectedTitle = "Facebook – log in or sign up";
		  String actualTitle = driver.getTitle();
		  softassert1 = new SoftAssert();
		  softassert1.assertEquals(actualTitle, expectedTitle);
		  System.out.println("check Title test Passed");
		  
		  WebElement logo = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
		  softassert1.assertTrue(logo.isDisplayed());
		  System.out.println("logo is diplayed on facebook login page");
		  softassert1.assertAll();
	  }
	  @Test(priority = 3)
	  public void checkURL()
	  {
		  String expectedURL = "https://www.facebook.com/";
		  String actualURL = driver.getCurrentUrl();
		  softassert1.assertEquals(actualURL, expectedURL);
		  System.out.println("check URL test Passed");
		  softassert1.assertAll();
		  
	  }
  
}
