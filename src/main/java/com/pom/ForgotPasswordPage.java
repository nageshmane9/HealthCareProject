package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class ForgotPasswordPage extends Base
{

	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="username") private WebElement username;
	@FindBy(xpath="//button[text()=' Cancel ']") private WebElement cancelButton;
	@FindBy(xpath="//button[@type='submit'][text()=' Reset Password ']") private WebElement ResetPasswordButton;
	
	
	public void EnterUsername(String text)
	{
		username.sendKeys(text);
		System.out.println("Entered username");
	}
	
	public void ClickOnCancelButton()
	{
		cancelButton.click();
		System.out.println("Clicked on cacel button");
	}
	
	public void ClickonResetPassword()
	{
		ResetPasswordButton.click();
		System.out.println("Clicked on Reset password button");
		
	}
	
}
