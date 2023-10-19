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
	HomePage home;
	
	@BeforeMethod
	public void SetUp() throws IOException
	{
		LaunchTheWeb();
		login = new LoginPage();
		object = new PIM();
		 home = new HomePage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void test1() throws InterruptedException
	{
		login.setInputusername(login.getUsername());
		Thread.sleep(2000);
		login.setInputpassword(login.getPassword());
		login.ClickOnLoginButton();
		Thread.sleep(2000);
		home.ClickOnPIM_Module();
		
		
		
	}
	

}
