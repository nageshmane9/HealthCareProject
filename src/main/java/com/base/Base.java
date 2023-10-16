package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base 
{
	FileInputStream fileinputstream;
	public static WebDriver driver;
	
	public static String projectpath= System.getProperty("user.dir"); 
	
	 public void LaunchTheWeb() throws IOException
	 {
		 fileinputstream = new FileInputStream(".\\src\\main\\resources\\Property\\config.properties");
		 
		 driver= new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 
		 Properties prop= new Properties();
		 
		 prop.load(fileinputstream);
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get(prop.getProperty("WebUrl"));
		 
	 }
	 
	 public void WaitForVisibility( String e)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(e)));
		}
	 
	 
	 
	
	
}
