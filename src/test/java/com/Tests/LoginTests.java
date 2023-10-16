package com.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pom.LoginPage;

public class LoginTests extends Base
{
	
	LoginPage login= new LoginPage();
	
	@BeforeMethod
	public void SetUp() throws IOException 
	{
		LaunchTheWeb();
		
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
	@Test
	public void LoginWithValidCredential()
	{
		
		login.setInputusername(login.getUsername());
		login.setInputpassword(login.getPassword());
		login.ClickOnLoginButton();
		
	}
   
}
