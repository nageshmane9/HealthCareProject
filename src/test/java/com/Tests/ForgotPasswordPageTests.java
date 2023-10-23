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

	ForgotPasswordPage FPP;
	LoginPage login;
	
	@BeforeMethod
	public void SetUp() throws IOException
	{
		LaunchTheWeb();
		login =new LoginPage();
	 FPP=	login.ClickOnforgotpasswordLink();     // Linking page // here return the ForgotPassowordpage when it clicked on forgot passoword link
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void enterValidEmail() throws InterruptedException
	{
	
		FPP.EnterUsername("Admin1234");
		Thread.sleep(2000);
		FPP.ClickOnCancelButton();
	}
	
	
}
