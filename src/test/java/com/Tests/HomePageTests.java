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
import com.pom.PIM;

public class HomePageTests extends Base
{
    
	HomePage home;
	SoftAssert soft =soft= new SoftAssert();     // softAssert 
	LoginPage login;

	
	@BeforeMethod
	public void SetUp() throws IOException
	{
		LaunchTheWeb();
		login = new LoginPage();
		login.setInputusername(login.getUsername());
		login.setInputpassword(login.getPassword());
	    home=login.ClickOnLoginButton();
		       
		
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
	public void ValidateSearchFunctionality()
	{
	     
		home.EnterSearchModule("Ad");
		boolean actual = home.AdminModule();
		
		soft.assertTrue(actual);
	
	}
	
	@Test
	public void ValidateAdmin_Module()
	{
	    home.ClickOnAdminModule();
	  
	    String actual1=driver.getCurrentUrl();
	    String expected=prop.getProperty("Admin_Module_URL");
	    
	    Assert.assertEquals(actual1, expected);
	   
	    
	}
	
	@Test
	public void ValidatePIM_Module()
	{
	    home.ClickOnPIMModule();
	  
	    String actual1=driver.getCurrentUrl();
	    System.out.println(actual1);
	    String expected=prop.getProperty("PIM_Module_URL");
	    
	    Assert.assertEquals(actual1, expected);
	   
	    
	}
	
	@Test
	public void ValidateLeave_Module()
	{
	    home.ClickOnLeaveModule();
	  
	    String actual1=driver.getCurrentUrl();
	    String expected=prop.getProperty("Leave_Module_URL");
	    
	    Assert.assertEquals(actual1, expected);
	   
	    
	}
	
	@Test
	public void ValidateTime_Module()
	{
	    home.ClickOnTimeModule();
	  
	    String actual1=driver.getCurrentUrl();
	    String expected=prop.getProperty("Time_Module_URL");
	    
	    Assert.assertEquals(actual1, expected);
	   
	    
	}
	
	@Test
	public void ValidateRecruitment_Module()
	{
	    home.ClickOnRecruitmentModule();
	  
	    String actual1=driver.getCurrentUrl();
	    String expected=prop.getProperty("Recruitment_Module_URL");
	    
	   Assert.assertEquals(actual1, expected);
	    
	    
	}
	
	@Test
	public void ValidateMyInfo_Module()
	{
	    home.ClickOnMyInfoModule();
	  
	    String actual1=driver.getCurrentUrl();
	    String expected=prop.getProperty("MyInfo_Module_URL");
	    
	    Assert.assertEquals(actual1, expected);
	   
	    
	}
	
	@Test
	public void ValidatePerformance_Module()
	{
	    home.ClickOnPerformanceModule();
	  
	    String actual1=driver.getCurrentUrl();
	    String expected=prop.getProperty("Performance_Module_URL");
	    
	    Assert.assertEquals(actual1, expected);
	   
	    
	}
	
	@Test
	public void ValidateDashboard_Module()
	{
	    home.ClickOnDashboardModule();
	  
	    String actual=driver.getCurrentUrl();
	    String expected=prop.getProperty("Dashboard_Module_URL");
	    
	    Assert.assertEquals(actual,expected);
	   
	    
	}
	
	@Test
	public void ValidateDirectory_Module()
	{
	    home.ClickOnDirectoryModule();
	  
	    String actual1=driver.getCurrentUrl();
	    String expected=prop.getProperty("Directory_Module_URL");
	    
	    Assert.assertEquals(actual1, expected);
	  
	    
	}
	
	@Test
	public void ValidateMaintenance_Module()
	{
	    home.ClickOnMaintenanceModule();
	  
	    String actual1=driver.getCurrentUrl();
	    String expected=prop.getProperty("Maintenance_Module_URL");
	    
	    Assert.assertEquals(actual1, expected);
	   
	    
	}
	
	@Test
	public void ValidateClaim_Module()
	{
	    home.ClickOnClaimModule();
	  
	    String actual1=driver.getCurrentUrl();
	    String expected=prop.getProperty("Claim_Module_URL");
	    
	    Assert.assertEquals(actual1, expected);
	   
	    
	}
	
	@Test
	public void ValidateBuzz_Module()
	{
	    home.ClickOnBuzzModule();
	  
	    String actual1=driver.getCurrentUrl();
	    String expected=prop.getProperty("Buzz_Module_URL");
	    
	   Assert.assertEquals(actual1, expected);
	  
	    
	}
	
	@Test
	public void ValidateLeftArrow()
	{
	      home.ClickOnLeftArrow();
		
	      boolean actual=home.PIMModule();
	      System.out.println(actual);
	      
	      Assert.assertFalse(actual);
	
	}
	
	@Test
	public void ValidateHelpLinkFunctionality()        
	{
	     home.ClickOnHelpLink();
		
	     String actual = driver.getCurrentUrl();
	     System.out.println(actual);
	     String expected=prop.getProperty("HelpLink_URL");
	     
	     Assert.assertEquals(actual,expected);
	
	}
	
	@Test
	public void ValidateProfileTab()
	{
		boolean actual=home.ClickOnProfileTab();
		
		Assert.assertTrue(actual);
	}
	
	
	@Test
	public void ValidateProfileAboutFuctionality()
	{
	  boolean actual=	home.SelectProfileTabsForValidateAbout();
		String a=home.AboutDetails();
		System.out.println(a);
		
		Assert.assertTrue(actual);	
	}
	
	@Test
	public void ValidateProfileSupportFuctionality()
	{
	 	home.SelectProfileTabsForValidateSupport();
		String actual=driver.getCurrentUrl();
		System.out.println(actual);
		String expected=prop.getProperty("Support_URL");
		
		Assert.assertEquals(actual,expected);	
	}
	
	@Test
	public void ValidateProfileChangePasswordFuctionality()
	{
	 	home.SelectProfileTabsForValidateChangePassword();
		String actual=driver.getCurrentUrl();
		System.out.println(actual);
		String expected=prop.getProperty("ChangePassword_URL");
		
		Assert.assertEquals(actual,expected);	
	}
	
	@Test
	public void ValidateProfileLogoutFuctionality()
	{
	 	home.SelectProfileTabsForValidateLogout();
		String actual=driver.getCurrentUrl();
		System.out.println(actual);
		String expected=prop.getProperty("WebUrl");
		
		Assert.assertEquals(actual,expected);	
	}
	
	
}
