package com.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(12));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Username : Admin']")));
		WebElement username= driver.findElement(By.xpath("//p[text()='Username : Admin']"));
		
		System.out.println(username.getText());
	}
}
