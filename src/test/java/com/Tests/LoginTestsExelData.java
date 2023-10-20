package com.Tests;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pom.LoginPage;
import com.utilities.Utility;

public class LoginTestsExelData   extends Base
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
	public void LoginWithSingleExelCredential() throws InterruptedException, IOException
	{
		Sheet sh=Utility.getsheet("Login");
		
		String ab=(String) Utility.getSingleData(1, 0, sh);
		String ac =(String) Utility.getSingleData(1, 1, sh);
		
		Thread.sleep(2000);
		login.setInputusername(ab);
		Thread.sleep(2000);
		login.setInputpassword(ac);
		Thread.sleep(2000);
		login.ClickOnLoginButton();
		
		boolean actual=login.InvalidMessage();
		System.out.println(actual);
		
		Assert.assertTrue(actual);
		
	
	}
	
    
	@Test
	public void LoginWithAllExelData() throws InterruptedException, IOException
	{
		Sheet sh=	Utility.getsheet("Login");
		
		Utility.getAllData(sh);
	
	   
	
		
	}
}
