package com.tutuorialsninja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.special_Date.classes.Util;

public class RegisterTest {

	
	public WebDriver driver;
	
	 @BeforeMethod
	 public void registerSetup() {
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://tutorialsninja.com/demo");
		 driver.findElement(By.linkText("My Account")).click();
		 driver.findElement(By.linkText("Register")).click(); 
			 
		 }

		 @Test(priority =1)
		 public void VerifyingRegisterWithMandatoryFields() {
		 
			 driver.findElement(By.xpath("//fieldset[@id='account']/descendant::input[@name='firstname']")).sendKeys("Ram"); 
			 driver.findElement(By.xpath("//fieldset[@id='account']/descendant::input[@name='lastname']")). sendKeys("Guru");
			 driver.findElement(By.xpath("//fieldset[@id='account']/descendant::input[@name='email']")). sendKeys(Util.emailWithDateTimeStamp());
			 driver.findElement(By.xpath(" //aside[@id='column-right']/preceding::input[@id='input-telephone'] ")).sendKeys("123-568-3265");
			 driver.findElement(By.xpath("//input[@type='tel']/following::input[@name='password'] ")).sendKeys("Ram@2023");
			 driver.findElement(By.xpath(" //input[@id='input-confirm'] ")).sendKeys("Ram@2023");
			// 	 driver.findElement(By.xpath(" //aside[@id='column-right']/preceding::input[@name='newsletter' and @value ='1'] ")).click();
			 driver.findElement(By.xpath(" //div[@class='pull-right']/descendant::input[@name='agree'] ")).click();
			 driver.findElement(By.xpath(" //div[@class='pull-right']/descendant::input[@class='btn btn-primary'] ")).click();
			 Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Congratulations! Your new account has been successfully created!']")).isDisplayed());        
		 }
		 //------------------------------------------
		 @Test(priority =2)
		 public void VerifyingRegisterWithAllFields() {
		 
			 driver.findElement(By.xpath("//fieldset[@id='account']/descendant::input[@name='firstname']")).sendKeys("Selenium"); 
			 driver.findElement(By.xpath("//fieldset[@id='account']/descendant::input[@name='lastname']")). sendKeys("Panda");
			 driver.findElement(By.xpath("//fieldset[@id='account']/descendant::input[@name='email']")). sendKeys(Util.emailWithDateTimeStamp());
			 driver.findElement(By.xpath(" //aside[@id='column-right']/preceding::input[@id='input-telephone'] ")).sendKeys("123-568-3265");
			 driver.findElement(By.xpath("//input[@type='tel']/following::input[@name='password'] ")).sendKeys("Selenium@123");
			 driver.findElement(By.xpath(" //input[@id='input-confirm'] ")).sendKeys("Selenium@123");
			 driver.findElement(By.xpath(" //aside[@id='column-right']/preceding::input[@name='newsletter' and @value ='1'] ")).click();
			 driver.findElement(By.xpath(" //div[@class='pull-right']/descendant::input[@name='agree'] ")).click();
			 driver.findElement(By.xpath(" //div[@class='pull-right']/descendant::input[@class='btn btn-primary'] ")).click();
			 Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")).isDisplayed());
		 }
		 
		 //------------------------------------------
		 
		 @Test(priority =3)
		 public void   VerifyingRegisterWithExistingEmail() {
		 
			 driver.findElement(By.xpath("//fieldset[@id='account']/descendant::input[@name='firstname']")).sendKeys("Selenium"); 
			 driver.findElement(By.xpath("//fieldset[@id='account']/descendant::input[@name='lastname']")). sendKeys("Panda");
			 driver.findElement(By.xpath("//fieldset[@id='account']/descendant::input[@name='email']")). sendKeys("seleniumpanda@gmail.com");
			 driver.findElement(By.xpath(" //aside[@id='column-right']/preceding::input[@id='input-telephone'] ")).sendKeys("9876543210");
			 driver.findElement(By.xpath("//input[@type='tel']/following::input[@name='password']")).sendKeys("Selenium@123");
			 driver.findElement(By.xpath(" //input[@id='input-confirm'] ")).sendKeys("Selenium@123");
			 driver.findElement(By.xpath(" //aside[@id='column-right']/preceding::input[@name='newsletter' and @value ='1']")).click();
			 driver.findElement(By.xpath(" //div[@class='pull-right']/descendant::input[@name='agree']")).click();
			 driver.findElement(By.xpath(" //div[@class='pull-right']/descendant::input[@class='btn btn-primary']")).click();
			String acutualDuplicateWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
			String expectedlDuplicateWarningMessage = "Warning: E-Mail Address is already registered!";
			Assert.assertTrue(acutualDuplicateWarningMessage.contains(expectedlDuplicateWarningMessage));
		 }
		 
		 
		 //---------------------------------------------------------
		 @Test(priority =4)
		 public void   VerifyingRegisterWithNoFields() {
		 
			
		   driver.findElement(By.xpath(" //div[@class='pull-right']/descendant::input[@class='btn btn-primary'] ")).click();
		    String acutualPrivacyPloicyWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
			String expectedPrivacyWarningMessage = "Warning: You must agree to the Privacy Policy!";
			Assert.assertTrue( acutualPrivacyPloicyWarningMessage.contains(expectedPrivacyWarningMessage));  
			
			
			String actualFirstNameWarningMessage = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
			String expectedFirstNameWarningMessage ="First Name must be between 1 and 32 characters!" ;
		    Assert.assertTrue(actualFirstNameWarningMessage.contains(expectedFirstNameWarningMessage)) ;    
		    
		   
		    String actualLastNameWarningMessage = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
			String expectedLastNameWarningMessage ="Last Name must be between 1 and 32 characters!" ;
		    Assert.assertTrue(actualLastNameWarningMessage.contains(expectedLastNameWarningMessage)) ;
		    
		    
		    String actualEmailWarningMessage = driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
			String expectedEmailWarningMessage ="E-Mail Address does not appear to be valid!" ;
		    Assert.assertTrue(actualEmailWarningMessage.contains(expectedEmailWarningMessage)) ;
		    
		    
		    String actualTelephoneWarningMessage = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
			String expectedTelephoneWarningMessage ="Telephone must be between 3 and 32 characters!" ;
		    Assert.assertTrue(actualTelephoneWarningMessage.contains(expectedTelephoneWarningMessage)) ;
		    
		    
		    
		    String actualPasswordWarningMessage = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
			String expectedPasswordWarningMessage ="Password must be between 4 and 20 characters!" ;
		    Assert.assertTrue(actualPasswordWarningMessage.contains(expectedPasswordWarningMessage)) ;    
		    
		 }
		
		 @AfterMethod
		 public void tearDown(){
		 driver.quit();
		 }	 
		 
		}

		




	
	
	
	

