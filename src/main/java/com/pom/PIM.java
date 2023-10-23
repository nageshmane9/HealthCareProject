package com.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;

public class PIM extends Base
{
    LoginPage login;  
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Configuration ']/i[@class='oxd-icon bi-chevron-down']") private WebElement ConfigurationDropDown;
	@FindBy(xpath="//li/a[text()='Employee List']") private WebElement EmployeeListTab;
	@FindBy(xpath="//a[text()='Add Employee']") private WebElement AddEmployeeTab;
	@FindBy(xpath="//a[text()='Reports']") private WebElement RepotsTab;
	@FindBy(xpath="//button[@title='Help']") private WebElement HelpButton;
	@FindBy(xpath="//input[@fdprocessedid='idud6s']") private WebElement EnterEmployeeName;
	@FindBy(xpath="//input[@fdprocessedid='es6xst']") private WebElement EnterEmployeeId;
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]") private WebElement EmploymentStatusDropDown;
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]") private WebElement IncludeDropDown;
	@FindBy(xpath="//input[@fdprocessedid='26ej4s']") private WebElement entersupervisorName;
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[3]") private WebElement JobTitleDropDown;
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[4]") private WebElement SubUnitDropDown;
	@FindBy(xpath="//button[@type='reset']") private WebElement ResetButton;
	@FindBy(xpath="//button[text()=' Search ']") private WebElement SearchButton;
	@FindBy(xpath="//button[text()=' Add ']") private WebElement AddButton;
	
	
	public void ClickOnConfigurationDropDown()
	{
		System.out.println("here");
		
		ConfigurationDropDown.click();
				
	}

	
	
	
	
	
}

       