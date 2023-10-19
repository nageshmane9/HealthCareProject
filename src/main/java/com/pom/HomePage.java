package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class HomePage extends Base
{

	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//img[@alt='client brand banner']") private WebElement LogoBanner;
	@FindBy(xpath="//input[@fdprocessedid='ruwi0k']") private WebElement SearchInput;
	@FindBy(xpath="//span[text()='Admin']") private WebElement Admin_Module;
	@FindBy(xpath="//span[text()='PIM']") private WebElement PIM_Module;
	
	@FindBy(xpath="//span[text()='Leave']") private WebElement Leave_Module;
	@FindBy(xpath="//span[text()='Time']") private WebElement Time_Module;
	@FindBy(xpath="//span[text()='Recruitment']") private WebElement Recruitment_Module;
	
	@FindBy(xpath="//span[text()='My Info']") private WebElement MyInfo_Module;
	@FindBy(xpath="//span[text()='Performance']") private WebElement Performance_Module;
	@FindBy(xpath="//span[text()='Dashboard']") private WebElement Dashboard_Module;
	@FindBy(xpath="//span[text()='Directory']") private WebElement Directory_Module;
	
	@FindBy(xpath="//span[text()='Maintenance']") private WebElement Maintenance_Module;
	@FindBy(xpath="//span[text()='Claim']") private WebElement Claim_Module;
	@FindBy(xpath="//span[text()='Buzz']") private WebElement Buzz_Module;
	
	
	public boolean ValidateHomeLogo()
	{
		return LogoBanner.isDisplayed();
	}
	
	
	public void ClickOnPIM_Module()
	{
		PIM_Module.click();
	}
	
	
	
}
