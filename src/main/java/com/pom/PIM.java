package com.pom;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.utilities.Utility;

public class PIM extends Base
{
      
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Configuration ']/i[@class='oxd-icon bi-chevron-down']") private WebElement ConfigurationDropDown;
	@FindBy(xpath="//li/a[text()='Employee List']") private WebElement EmployeeListTab;
	@FindBy(xpath="//a[text()='Add Employee']") private WebElement AddEmployeeTab;
	@FindBy(xpath="//a[text()='Reports']") private WebElement RepotsTab;
	@FindBy(xpath="//button[@title='Help']") private WebElement HelpButton;
	@FindBy(xpath="//input[@placeholder='Type for hints...']") private WebElement EnterEmployeeName;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]") private WebElement EnterEmployeeId;
	@FindBy(xpath="//div[@class='oxd-select-text-input'][1]") private WebElement EmpStstus;
	@FindBy(xpath="//div[@role='listbox']/div[@role='option']") private List<WebElement> EmploymentStatusDropDownList;
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]") private WebElement  IncludeDropdown;
	
	@FindBy(xpath="//div[@role='listbox']/div[@role='option']") private List<WebElement> IncludeDropDownList;
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[2]") private WebElement entersupervisorName;
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[3]") private WebElement JobTitleDropDown;
	@FindBy(xpath="//div[@role='listbox']/div") private List<WebElement> JobTitleDropdownList;
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[4]") private WebElement SubUnitDropDown;
	@FindBy(xpath="//button[@type='reset']") private WebElement ResetButton;
	@FindBy(xpath="//button[text()=' Search ']") private WebElement SearchButton;
	@FindBy(xpath="//button[text()=' Add ']") private WebElement AddButton;
	
   //div[@role='listbox']
	public boolean ClickOnConfigurationDropDown()
	{
        boolean cd1=ConfigurationDropDown.isDisplayed()&& ConfigurationDropDown.isEnabled();
		if(cd1)
		{
			ConfigurationDropDown.click();
			System.out.println("Clicked on ConfigurationDropDown");
		}
			
		return cd1;
	}

	public boolean ClickOnEmployeeList()
	{
		boolean cd1= EmployeeListTab.isDisplayed() && EmployeeListTab.isEnabled();
	     EmployeeListTab.click();
		return cd1;
	}
	
	public boolean ClickOnAddEmployee()
	{
		boolean cd1= AddEmployeeTab.isDisplayed() && AddEmployeeTab.isEnabled();
	     AddEmployeeTab.click();
	     System.out.println("Clicked on Add Employee");
		return cd1;
	}
	
	public boolean ClickOnReports()
	{
		boolean cd1= RepotsTab.isDisplayed() && RepotsTab.isEnabled();
	     RepotsTab.click();
	     System.out.println("Clicked on Reports");
		return cd1;
	}
	
	public boolean ClickOnHelp()
	{
		boolean cd1= HelpButton.isDisplayed() && HelpButton.isEnabled();
	     HelpButton.click();
	     System.out.println("Clicked on Help");
		return cd1;
	}
	
	public boolean ClickOnReset()
	{
		boolean cd1= ResetButton.isDisplayed() && ResetButton.isEnabled();
	    ResetButton.click();
	    System.out.println("Clicked on Reset button");
		return cd1;
	}
	
	public boolean ClickOnSearch()
	{
		boolean cd1= SearchButton.isDisplayed() && SearchButton.isEnabled();
	     SearchButton.click();
	     System.out.println("Clicked on Search Button");
		return cd1;
	}
	
	public boolean ClickOnAdd()
	{
		boolean cd1= AddButton.isDisplayed() &&AddButton.isEnabled();
	     AddButton.click();
		return cd1;
	}
	
	public void EnterEmployeeeName(String text)
	{
		EnterEmployeeName.sendKeys(text);
	}
	
	public void EnterEmployeeId(String text)
	{
		EnterEmployeeId.sendKeys(text);
	}
	
	
	public void  SelectEmploymentStatus() 
	{
		EmpStstus.click();
		Utility.WaitForVisibility("//div[@role='listbox']/div[@role='option']");
		
		for(WebElement i: EmploymentStatusDropDownList)
		{
			String a= i.getText();
			System.out.println(a);
			if(a.equals("Full-Time Permanent"))
			{
				i.click();
				break;
			}
			
		 
		}
	}
	
	
	public void  SelectInclude()
	{
		IncludeDropdown.click();
		
		for(WebElement i: IncludeDropDownList)
		{
			String a= i.getText();
			System.out.println(a);
			if(a.equals("Current and Past Employees"))
			{
				i.click();
				break;
			}
			
		 
		}
	}
	
	public void EnterSupervisorName()
	{
		System.out.println("hi");
		entersupervisorName.sendKeys("Kevin Mathews");
	}
	
	
	public void  SelectJobTitle()
	{
		JobTitleDropDown.click();
		
		for(WebElement i: JobTitleDropdownList)
		{
			String a= i.getText();
			System.out.println(a);
			if(a.equals("Finance Manager"))
			{
				i.click();
				break;
			}
			
		 
		}
	}
	
	
	
	
	
}

       