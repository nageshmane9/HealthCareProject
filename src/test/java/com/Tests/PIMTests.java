package com.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.PIM;

public class PIMTests extends Base
{
	PIM object;
	LoginPage login;
	
	
	@BeforeMethod
	public void SetUp() throws IOException
	{
		
	 	   LaunchTheWeb();
	 	   login = new LoginPage();
	 	 
	 	   login.setInputusername(login.getUsername());
	 	   login.setInputpassword(login.getPassword());
	 	  HomePage  home=login.ClickOnLoginButton();       // linking the page
	 	   home.ClickOnPIM_Module();                
	 	   object = new PIM();
	 	   
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
	
	@Test
	public void test1() throws InterruptedException
	{
		object.ClickOnConfigurationDropDown();
		
   
	}
	

}
