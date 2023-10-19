package com.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pom.LoginPage;

public class LoginTests extends Base
{
	
	LoginPage login;
	
	@BeforeMethod
	public void SetUp() throws IOException 
	{
		
		LaunchTheWeb();
		login= new LoginPage();
		
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
	
	@Test
	public void LoginWithValidCredential() throws InterruptedException
	{
		
		login.setInputusername(login.getUsername());
		Thread.sleep(2000);
		System.out.println(login.getPassword());
		login.setInputpassword(login.getPassword());
		Thread.sleep(2000);
		login.ClickOnLoginButton();
		Thread.sleep(2000);
		
		String actual = driver.getTitle();
		String expected=prop.getProperty("Logintitle");
		
		Assert.assertEquals(actual,expected);
	}
	
	
	@Test (groups="Sanity")
	public void ValidateTitle()
	{
		String actual = driver.getTitle();
		String expected=prop.getProperty("Logintitle");
		
		Assert.assertEquals(actual,expected);
	}
	
	
	@Test (groups="Sanity")
	public void validateLogo()
	{
		boolean Actual =login.Logo();
		
		Assert.assertTrue(Actual);      //Validation
	}
	
	
	@Test
	public void ValidateURL()
	{
		String actual =driver.getCurrentUrl();
		String expected= prop.getProperty("WebUrl");
		
		Assert.assertEquals(actual, expected);   //Validation
		
	}
	@Test
	public void validateForgotpasswordLink()
	{
		
		login.ClickOnforgotpasswordLink();
		String Actual=driver.getCurrentUrl();
		System.out.println(Actual);
		String expected=prop.getProperty("ForgotPasswordLink");
		
		Assert.assertEquals(Actual, expected);
		
		
	}
	
   
}
