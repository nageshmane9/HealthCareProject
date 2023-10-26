package com.Tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base;
import com.pom.ForgotPasswordPage;
import com.pom.LoginPage;

public class ForgotPasswordPageTests extends Base
{
    SoftAssert soft;
	ForgotPasswordPage FPP;
	LoginPage login;
	
	@BeforeMethod
	public void SetUp(Method m) throws IOException
	{
		LaunchTheWeb();
		login =new LoginPage();
		soft = new SoftAssert();
	    System.out.println("***TestName--"+m.getName());
	 FPP=login.ClickOnforgotpasswordLink();             // Linking page // here return the ForgotPassowordpage when it clicked on forgot passoword link
		
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test
	public void ValidateForgotPasswordURL()
	{
		String actual=driver.getCurrentUrl();
		                     System.out.println("ForgotpasscurrentURL-"+actual);
		String expected =prop.getProperty("ForgotpasswordPageURL");
		
		Assert.assertEquals(actual, expected);
	}
	
	 @Test
	 public void ValidateCancelButton()
	 {
	    boolean actual=	FPP.ClickOnCancelButton();     
	       soft.assertTrue(actual);	                 // soft assert                 
		
	       
		String actual1=driver.getCurrentUrl();
		String expected1=prop.getProperty("WebUrl");
     	soft.assertEquals(actual1, expected1);               // soft assert
		
		soft.assertAll();
	 }
	 
	 @Test
	 public void ValidateResetPasswordButton()
	 {
		boolean actual=FPP.ClickonResetPasswordButton();
		
		Assert.assertTrue(actual);
		
	 }
	
	@Test
	public void ValidateResetPasswordWithValidEmail() 
	{
	
		FPP.EnterUsername("Admin1234");
		FPP.ClickonResetPasswordButton();
		
		String actual=FPP.ResetSuccessfulMessage();
		System.out.println(actual);
		String expected=prop.getProperty("ResetSuccefulMessage");
		
		Assert.assertEquals(actual, expected);
	}
	
	 @Test
	 public void ValidateResetPasswordWithBlankCredential()
	 {
		 FPP.EnterUsername("");
		 FPP.ClickonResetPasswordButton();
		 
		 String actual=FPP.RequiredMessageForUsername();
		 String expected =prop.getProperty("RequiredErrorMessageforUsername");
		 
		 Assert.assertEquals(actual, expected);
		 
	 }
	 
	 
	 @Test
	 public void ValidateResetPasswordWithInvalidCredential()
	 {
		 FPP.EnterUsername("ad");
		 FPP.ClickonResetPasswordButton();
		 
		 String actual=FPP.ResetSuccessfulMessage();
		 String expected =prop.getProperty("ResetSuccefulMessage");
		 
		 Assert.assertEquals(actual, expected);
		 
	 }
	 
	 
	 @Test
	 public void ValidateResetPasswordWithInvalidCharacterCredential()
	 {
		 FPP.EnterUsername("@@#$$$@!%%^$#@!");
		 FPP.ClickonResetPasswordButton();
		 
		 String actual=FPP.ResetSuccessfulMessage();
		 String expected =prop.getProperty("ResetSuccefulMessage");
		 
		 Assert.assertEquals(actual, expected);
		 
	 }
	 
	
	
	
	
	
}
