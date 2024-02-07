package com.Tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base;
import com.pom.LoginPage;

import ListenerPKG.MyListener;

@Listeners(MyListener.class)
public class LoginTests extends Base
{
	
	LoginPage login;
	SoftAssert soft = new SoftAssert();    // soft assert
	
	@BeforeMethod(groups = {"Sanity"})
	public void SetUp(Method m) throws IOException 
	{
		LaunchTheWeb();
		login= new LoginPage();
	System.out.println("*****TestName****"+m.getName());
	
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
	
	@Test (groups = {"Sanity"})
	public void ValidateTitle()
	{
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected=prop.getProperty("Logintitle");
		
		Assert.assertEquals(actual,expected);
	}
	
	@Test (groups = {"Sanity"})
	public void ValidateLogo()
	{
		boolean actual =login.Logo();
		
		Assert.assertTrue(actual);
	}
	
	@Test 
	public void ValidateLogoBanner()
	{
		boolean Actual =login.LogBranding();
		
		Assert.assertTrue(Actual);      // Validation    Hard Assertion
	}
	
	
	@Test
	public void ValidateURL()
	{
		String actual =driver.getCurrentUrl();
		String expected= prop.getProperty("WebUrl");
		
		Assert.assertEquals(actual, expected);   //Validation
		
	}
	
	@Test
	public void ValidateForgotpasswordLink()
	{
		
		login.ClickOnforgotpasswordLink();
		
		String ActualURL=driver.getCurrentUrl();
		System.out.println(ActualURL);
		String expected=prop.getProperty("ForgotpasswordPageURL");
		
		Assert.assertEquals(ActualURL, expected);  // Hard assert
			
	}
	@Test
	public void LoginWithValidCredential() 
	{
	    
	      
		login.setInputusername(login.getUsername());
		login.setInputpassword(login.getPassword());
		login.ClickOnLoginButton();
		
		String actual = driver.getTitle();    System.out.println(actual);
		String expected=prop.getProperty("Logintitle");
		
		Assert.assertEquals(actual,expected); 
		
	}
	
	@Test
	public void LoginWithBlanckUsername()
	{
		login.setInputusername("");
		login.setInputpassword("admin123");
		login.ClickOnLoginButton();
		
	  	String actual = login.RequiredErrorMessageforUsername();
	  	String expeted=prop.getProperty("RequiredErrorMessageforUsername");
	  	soft.assertEquals(actual,expeted);
	  	
	  	soft.assertAll();	
	}
	
	@Test
	public void LoginWithBlankPassword()                       // Failed Test Case
	{
		login.setInputusername("Admin");
		login.setInputpassword("");
		login.ClickOnLoginButton();

	  	String actual=login.RequiredErrorMessageforPassword();
	  	System.out.println(actual);
	  	String expected=prop.getProperty("RequiredErrorMessageforPassword");
	  	System.out.println(expected);
	  	
	  	Assert.assertEquals(actual,expected);  		
	}
	
	@Test
	public void LoginWithBlanckCredential()
	{
		login.setInputusername("");
		login.setInputpassword("");
		login.ClickOnLoginButton();
		
		String actual = login.RequiredErrorMessageforUsername();
	  	String expeted=prop.getProperty("RequiredErrorMessageforUsername");
	  	soft.assertEquals(actual,expeted);
	  	
	  	String actual1=login.RequiredErrorMessageforPassword();
	  	String expected1=prop.getProperty("RequiredErrorMessageforPassword");
	  	System.out.println(expected1);
	  	soft.assertEquals(actual1,expected1);
	  	
	  	soft.assertAll();	
	}
	
	@Test
	public void LoginWithValidUsernameInvalidPassword()     // Valid Username
	{
		
		login.setInputusername(login.getUsername());
		login.setInputpassword("admin");
		login.ClickOnLoginButton();
		
		String actual=login.InvalidCredentialsMessage();
		String expected=prop.getProperty("LoginWithInvalidCredMessage");
		
		Assert.assertEquals(actual,expected); 
	}
	
	@Test
	public void LoginWithInvalidUsernameValidPassword()      // Valid Password
	{
		login.setInputusername("Adm");
		login.setInputpassword(login.getPassword());
		login.ClickOnLoginButton();
		
		String actual=login.InvalidCredentialsMessage();
		String expected=prop.getProperty("LoginWithInvalidCredMessage");
		
		Assert.assertEquals(actual,expected);
		
	}
	
	@Test
	public void LoginWithInvalidCredentials()       // Invalid Credentials
	{
		
		login.setInputusername("adm");
		login.setInputpassword("admin12");
		login.ClickOnLoginButton();
		
		
		String actual = login.InvalidCredentialsMessage();
		String expected=prop.getProperty("LoginWithInvalidCredMessage");
		
		Assert.assertEquals(actual,expected); 
	}
	
	@Test
	public void LoginWithInvalidCharacterCredentials()       // Invalid Credentials
	{
		
		login.setInputusername("@@#$@@###!!%^^!!^");
		login.setInputpassword("!##@$%%@%^**%%@#!");
		login.ClickOnLoginButton();
		
		
		String actual = login.InvalidCredentialsMessage();
		String expected=prop.getProperty("LoginWithInvalidCredMessage");
		
		Assert.assertEquals(actual,expected); 
	}
	
	@Test
	public void ValidateWebApplicationVersionText()
	{
		String Actual=login.GetWebApplicationVersionText();
		String Expected= prop.getProperty("WebApplicationVersionText");
		
		Assert.assertEquals(Actual, Expected);
	}
	
	@Test
	public void ValidateCopyRightText()
	{
		String Actual=login.GetCopyRightText();
		String Expected= prop.getProperty("CopyRightText");
		
		Assert.assertEquals(Actual, Expected);
	}
	
	@Test
	public void ValidateLinkdnLinkIcon()            // Two Validations
	{
		boolean Actual=login.ClickOnLinkdnLinkIcon();
		System.out.println(Actual);
		
		soft.assertTrue(Actual);                 // soft assert
		
		String Actual1=driver.getCurrentUrl();
		String Expected1= prop.getProperty("LinkednURL");
		soft.assertEquals(Actual1, Expected1);     // soft assert
		
		soft.assertAll();
	}
	
	@Test
	public void ValidateFacebookLinkIcon()            // Two Validations
	{
		boolean Actual=login.ClickOnFacebookLinkIcon();
		System.out.println(Actual);
		
		soft.assertTrue(Actual);                 // soft assert
		
		String Actual1=driver.getCurrentUrl();
		String Expected1= prop.getProperty("FacebookURL");
		soft.assertEquals(Actual1, Expected1);     // soft assert
		
		soft.assertAll();
	}
	
	@Test
	public void ValidateTwitterLinkIcon()            // Two Validations
	{
		boolean Actual=login.ClickOnTwitterLinkIcon();
		System.out.println(Actual);
		
		soft.assertTrue(Actual);                 // soft assert
		
		String Actual1=driver.getCurrentUrl();
		String Expected1= prop.getProperty("TwitterURL");
		soft.assertEquals(Actual1, Expected1);     // soft assert
		
		soft.assertAll();
	}
	
	@Test
	public void ValidateYouTubeLinkIcon()            // Two Validations
	{
		boolean Actual=login.ClickOnYoutubeLinkIcon();
		System.out.println(Actual);
		
		soft.assertTrue(Actual);                 // soft assert
		
		String Actual1=driver.getCurrentUrl();
		String Expected1= prop.getProperty("YouTubeURL");
		soft.assertEquals(Actual1, Expected1);     // soft assert
		
		soft.assertAll();
	}
	
	
	
	
	
	
   
}
