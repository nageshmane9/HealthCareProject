package com.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base;
import com.pom.HomePage;
import com.pom.LoginPage;

public class HomePageTests extends Base
{
    
	HomePage home;
	SoftAssert soft;
	LoginPage login;
	
	@BeforeMethod
	public void SetUp() throws IOException
	{
		LaunchTheWeb();
		home = new HomePage();
		login = new LoginPage();
		login.setInputusername(login.getUsername());
		login.setInputpassword(login.getPassword());
		login.ClickOnLoginButton();
		
		soft= new SoftAssert();        // softAssert 
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void ValidateLogo()
	{
		boolean actual =home.ValidateHomeLogo();
		
		Assert.assertTrue(actual);       // Hard Assert
	}
	
	@Test
	public void ValidatePIM_Module()
	{
	    boolean a=home.ClickOnPIM_Module();
	    soft.assertTrue(a);
	    String actual1=driver.getCurrentUrl();
	    System.out.println(actual1);
	    String expected=prop.getProperty("PIM_Module_URL");
	    
	    soft.assertEquals(actual1, expected);
	    soft.assertAll();
	    
	}
	
	@Test
	public void ValidateLeftArrow() throws InterruptedException
	{
	      home.ClickOnLeftArrow();
		
	      boolean actual=home.PIM_Module();
	      System.out.println(actual);
	      
	      Assert.assertFalse(actual);
	
	}
	
}
