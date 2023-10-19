package com.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pom.ForgotPasswordPage;
import com.pom.LoginPage;

public class ForgotPasswordPageTests extends Base
{

	ForgotPasswordPage ob;
	LoginPage login;
	
	@BeforeMethod
	public void SetUp() throws IOException
	{
		LaunchTheWeb();
		login =new LoginPage();
		 ob= new 	ForgotPasswordPage();
		login.ClickOnforgotpasswordLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void enterValidEmail() throws InterruptedException
	{
		login.ClickOnforgotpasswordLink();
		Thread.sleep(2000);
		ob.EnterUsername("Admin1234");
		ob.ClickOnCancelButton();
	}
	
	
}
