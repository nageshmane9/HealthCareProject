package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class PIM extends Base
{
      
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Configuration ']") private WebElement ConfigurationDropDown;
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
	

	
}
