package com.PracticePackage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice_No_1 {
	
	/* The highlightElement method uses JavaScript to apply a visual effect to the specified WebElement by adding a red border with a width of 5 pixels. 
	   The highlighted border makes it clear which elements are being referenced and manipulated.Highlighting elements can serve as a form of verification 
	   during test development to ensure that the script is interacting with the intended UI elements.             */
   
	
	public WebDriver driver;
    public WebDriverWait wait ;
    
    
    @BeforeMethod
    public void loginSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo");
    }

    @Test
    public void highlightAndInteractWithElements() {  	  	     	
    	

     
        WebElement link = driver.findElement(By.linkText("My Account"));
        
        // Highlight the elements before interacting with them
        highlightElement(link);link.click();     
        
        WebElement Login = driver.findElement(By.linkText("Login"));
        highlightElement(Login);Login.click();     
        
        WebElement Id = driver.findElement(By.id("input-email"));
        highlightElement(Id);Id.sendKeys("Automationlama16@myyahoo.com");  
        
        
        WebElement Pass =     driver.findElement(By.id("input-password"));
        highlightElement(Pass);Pass.sendKeys("Selenium");
        
        WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        highlightElement(loginButton); loginButton.click();
        
        WebElement logoutLink = driver.findElement(By.linkText("Logout"));
        highlightElement(logoutLink);  logoutLink.click();
        
        WebElement ContinueButton = driver.findElement(By.linkText("Continue"));
        highlightElement( ContinueButton);  ContinueButton.click();
   
        
    }

    // Method to highlight a WebElement using JavaScript Executor
     public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='8px solid red'", element);
    }

    @AfterMethod
    public void tearDown() {
       driver.quit();
    }
}

