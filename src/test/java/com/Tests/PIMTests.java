package com.Tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.beust.jcommander.Parameters;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.PIM;


public class PIMTests extends Base
{
	PIM pim;
	LoginPage login;
	
	
	@BeforeMethod
	public void SetUp(Method m) throws IOException
	{
	 	   LaunchTheWeb();
	 	   login = new LoginPage();
	 	  System.out.println("*****TestName****"+m.getName());
	 	   login.setInputusername(login.getUsername());
	 	   login.setInputpassword(login.getPassword());
	 	  HomePage  home=login.ClickOnLoginButton();            // linking the page
	 	   pim=    home.ClickOnPIMModule(); 
	 	   
	}
	
	@AfterMethod
	public void tearDown()
	{
	      driver.quit();
		
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
	
	@Test(groups= {"Sanity"})
	public void ValidateReports()
	{
		
		boolean actual = pim.ClickOnReports();
		
		Assert.assertTrue(actual);
	}
	
	/*
	@Test
	public void  ValidateSearchFunctionality() 
	{
		pim.EnterEmployeeeName("pravin kale");
		pim.EnterEmployeeId("1222");
		pim.SelectEmploymentStatus();
		pim.SelectInclude();
		pim.EnterSupervisorName();
		pim.SelectSupervisorName(prop.getProperty("Name"));
		pim.SelectJobTitle();
		pim.SelectSubUnit();
		pim.ClickOnSearchButton();
		
	}
	
	@Test
	public void  ValidateAddFunctionality() 
	{
		pim.ClickOnAddButton();
		
		
		
	}
	
	
	*/
	
	@Test
	public void ValidateRightArrow() throws InterruptedException
	{
		pim.ClickOnRightArrow();
		Thread.sleep(5000);
	}

}
