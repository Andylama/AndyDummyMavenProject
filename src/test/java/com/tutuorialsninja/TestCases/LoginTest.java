package com.tutuorialsninja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	
	public WebDriver driver;
	
	@BeforeMethod
	public void loginSetup()   {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
			
		}
		
		//---------------------------------------------------------------------------------------------	
			@Test(priority =1)
			public void verifyLoginWithValidCredentials() {
				driver.findElement(By.id("input-email")).sendKeys("Automationlama16@myyahoo.com");
				driver.findElement(By.id("input-password")).sendKeys("Selenium");
				driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
				/*  First you need to decide what you need to Assert Second you highlight or objectify that WebElement
				    Third you apply Assertion */
				WebElement editYourAccountInfoLink = driver.findElement(By.linkText("Edit your account information"));
				WebElement LogoutLink = driver.findElement(By.linkText("Logout"));
				Assert.assertTrue(editYourAccountInfoLink.isDisplayed() && LogoutLink.isDisplayed());
		}
			@Test(priority =2)
			public void verifyLoginWithInvalidCredentials() {
				driver.findElement(By.id("input-email")).sendKeys("Wrongemail@gmail.com");
				driver.findElement(By.id("input-password")).sendKeys("Wrongpassword");
				driver.findElement(By.cssSelector("input.btn.btn-primary")).click();	
				String actualWarningMessage =driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();     
				String expectedWarningMessage ="Warning: No match for E-Mail Address and/or Password.";
				Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		}
			@Test(priority =3)
			public void verifyLoginWithValidEmailInvalidPassword() {
				
				driver.findElement(By.id("input-email")).sendKeys("Automationlama16@myyahoo.com");
				driver.findElement(By.id("input-password")).sendKeys("Wrongpassword");
				driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
				String actualWarningMessage =driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();     
				String expectedWarningMessage ="Warning: No match for E-Mail Address and/or Password.";
				Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		}
			@Test(priority =4)
			public void verifyLoginWithInvalidEmailValidPassword() {
				driver.findElement(By.id("input-email")).sendKeys("Wrongemail@gmail.com");
				driver.findElement(By.id("input-password")).sendKeys("Selenium");
				driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
				String actualWarningMessage =driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();     
				String expectedWarningMessage ="Warning: No match for E-Mail Address and/or Password.";
				Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
				
		}
			@Test(priority =5)
			public void verifyLoginWitNoCredentials() {
				driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
				String actualWarningMessage =driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();     
				String expectedWarningMessage ="Warning: No match for E-Mail Address and/or Password.";
				Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
				
		}
			@AfterMethod
			public void tearDown() {
				driver.quit();
		}	
		}	
	
	
	


