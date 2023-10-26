package com.Tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.utilities.Utility;

public class LoginTestsExelData   extends Base
{
     
   LoginPage login;
   SoftAssert soft = new SoftAssert();
   
	@BeforeMethod
	public void SetUp(Method m) throws IOException 
	{
		
		LaunchTheWeb();
		login= new LoginPage();
	System.out.println("***TestName***"+m.getName());
		
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
		
		String actual=login.InvalidCredentialsMessage();
		System.out.println(actual);
		String expected=prop.getProperty("LoginWithInvalidCredMessage");
		
		Assert.assertEquals(actual, expected);
		
	}
	
	
	@Test(dataProvider = "logindata")
	public void LoginCredential(Map<String,String> data)
	{
		login.setInputusername(data.get("Username"));
		login.setInputpassword(data.get("Password"));
		
		HomePage home=login.ClickOnLoginButton();
		
		String actual=driver.getCurrentUrl();
		System.out.println(actual);
		String expected=prop.getProperty("WebUrl");
		
		soft.assertEquals(actual, expected);
	
		soft.assertAll();
		
	}
	
   
	@DataProvider(name="logindata")
	public Object[][] getDataFromExel() throws InterruptedException, IOException
	{
		Sheet sh=	Utility.getsheet("Login");
		
	
		Object[][] data= Utility.getData(sh);
		
		return data;
	}
}
