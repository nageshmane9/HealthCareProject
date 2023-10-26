package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;
import com.utilities.Utility;

public class ForgotPasswordPage extends Base
{

	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")  private WebElement username;
	@FindBy(xpath="//button[text()=' Cancel ']") private WebElement cancelButton;
	@FindBy(xpath="//button[@type='submit'][text()=' Reset Password ']") private WebElement ResetPasswordButton;
	@FindBy(xpath="//span[text()='Required']") private WebElement RequiredMessageForUsername;
	@FindBy(xpath="//div/h6[text()='Reset Password link sent successfully']") private WebElement ResetSMessage;
	
	
	public void EnterUsername(String text)
	{
		Utility.WaitForVisibility("//input[@name='username']");
		username.sendKeys(text);
		System.out.println("Entered username");
	}
	
	public boolean ClickOnCancelButton()
	{
		Utility.WaitForVisibility("//button[text()=' Cancel ']");
	 boolean ft=	cancelButton.isDisplayed() && cancelButton.isEnabled();
		
			cancelButton.click();
			System.out.println("Clicked on cancel button");
		 
		return ft;
	 }
	
	public boolean ClickonResetPasswordButton()
	{
		boolean ft= ResetPasswordButton.isDisplayed() && ResetPasswordButton.isEnabled();
		        System.out.println(ft);
			ResetPasswordButton.click();
			System.out.println("Clicked on Reset password button");
			return	ft;
	}
	
	public String RequiredMessageForUsername()
	{
		if(RequiredMessageForUsername.isDisplayed())
		{
			System.out.println("Required Message is displayed");
		}
		return RequiredMessageForUsername.getText();
	}
	
	public String ResetSuccessfulMessage()
	{
		
		if(ResetSMessage.isDisplayed())
		{
			System.out.println("Reset password link send succefully message displayed");
		}
		return ResetSMessage.getText();
	}
	
}
