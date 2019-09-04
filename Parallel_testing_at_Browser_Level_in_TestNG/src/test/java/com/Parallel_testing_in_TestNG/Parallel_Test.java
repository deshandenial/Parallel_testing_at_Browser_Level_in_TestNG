package com.Parallel_testing_in_TestNG;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class Parallel_Test 
{
	WebDriver driver;
	
	
	 @BeforeTest
	 @Parameters("browser")

	 public void beforeTest(@Optional("firefox") String browser) throws Exception
		{
		 if(browser.equalsIgnoreCase("chrome"))
		 {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.addArguments("----disable-notification----");
			driver=new ChromeDriver(option);
			driver.manage().window().maximize();
		  }	
		 else if(browser.equalsIgnoreCase("firefox"))
	     {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			FirefoxOptions option=new FirefoxOptions();
			option.addArguments("----disable-notification----");
			driver=new FirefoxDriver(option);
			driver.manage().window().maximize(); 	
		 }
		 else if(browser.equalsIgnoreCase("ie"))
		 {
			 
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			InternetExplorerOptions option=new InternetExplorerOptions();
			driver=new InternetExplorerDriver(option);
			driver.manage().window().maximize(); 
		 }
		 else
		 {
			 throw new Exception("Browser is not correct");
		 }
		 
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		 
		}
		
		
		
		
	  @Test
	  public void Test1() 
	  {
		  
		  driver.get("https://www.linkedin.com/");
		  driver.findElement(By.xpath("//a[contains(text(),'Join now')]")).click();
		  driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("desone");
		  driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("deshan");
		  driver.findElement(By.xpath("//input[@id='join-email']")).sendKeys("deshan@123");  
	  }
	 

	  @AfterTest
	  public void afterTest()
	  {
		  driver.close();
	  }

}
