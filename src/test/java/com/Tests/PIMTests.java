package com.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.PIM;

public class PIMTests extends Base
{
	PIM pim;
	LoginPage login;
	
	
	@BeforeMethod
	public void SetUp() throws IOException
	{
	 	   LaunchTheWeb();
	 	   login = new LoginPage();
	 	 
	 	   login.setInputusername(login.getUsername());
	 	   login.setInputpassword(login.getPassword());
	 	  HomePage  home=login.ClickOnLoginButton();       // linking the page
	 	       home.ClickOnPIMModule();                
	 	   pim = new PIM();	   
	}
	
	@AfterMethod
	public void tearDown()
	{
	     // driver.quit();
		
	}
	
	@Test
	public void ValidateConfigurationDropDown() 
	{
		boolean actual =pim.ClickOnConfigurationDropDown();
		
		Assert.assertTrue(actual);
		
	}
	
	@Test
	public void ValidateEmployeeList()
	{
		boolean actual = pim.ClickOnEmployeeList();
		
		Assert.assertTrue(actual);
		
	}
	
	@Test
	public void ValidateaAddEmployee()
	{
		boolean actual = pim.ClickOnAddEmployee();
		
		Assert.assertTrue(actual);
	}
	
	@Test
	public void ValidateReports()
	{
		boolean actual = pim.ClickOnReports();
		
		Assert.assertTrue(actual);
	}
	
	@Test
	public void  ValidateSearchFunctionality() 
	{
		
		pim.EnterEmployeeeName("John999181 Jacob999181 Smith999181");
		pim.EnterEmployeeId("0024");
		pim.SelectEmploymentStatus();
		pim.SelectInclude();
		pim.EnterSupervisorName();
		pim.SelectJobTitle();
		
	}
	
	
	

}
