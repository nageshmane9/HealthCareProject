package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;
import com.utilities.Utility;

public class LoginPage extends Base
{
  
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[text()='Username : Admin']") private WebElement username;
	@FindBy(xpath="//p[text()='Password : admin123']") private WebElement password;
	@FindBy(name="username") private WebElement inputusername;
	@FindBy(name="password") private WebElement inputpassword;
	@FindBy(xpath="//button[@type='submit']") private WebElement LoginButton;
	@FindBy(xpath="//p[text()='Forgot your password? ']") private WebElement forgotpasswordlink;
	@FindBy(xpath="//img[@alt='company-branding']") private WebElement logo;
	@FindBy(xpath="//p[text()='Invalid credentials']") WebElement InvalidcredentialsMessage;
	@FindBy(xpath="//span[text()='Required']") private WebElement RequiredFieldMessage;
	
     public String getUsername()
     {
    	
    	String a= username.getText();
    	System.out.println(a);
    	 return a.substring(a.indexOf('A')); 
    	 
     }
     
     public String getPassword()
     {
    	
    	 String a=password.getText();
    	 return a.substring(11);
     }
     
     public void ClickOnLoginButton()
     {
    	 LoginButton.click();
     }

	
	public void setInputusername(String Setusername) 
	{
		 inputusername.sendKeys(Setusername);
	}

	
	public void setInputpassword(String Setpassword) 
	{
		 inputpassword.sendKeys(Setpassword);
	}
	
	
	public boolean Logo()
	{
		Utility.WaitForVisibility("//img[@alt='company-branding']");
		boolean a=logo.isDisplayed();
		System.out.println(a);
		return a;
	}
	
	public void ClickOnforgotpasswordLink()
	{
		forgotpasswordlink.click();
	}
	
	public boolean InvalidMessage()
	{
		return InvalidcredentialsMessage.isDisplayed();
		
	}
	
	public boolean RequiredErrorMessage()
	{
		return RequiredFieldMessage.isDisplayed();
	}
     
     
	
	
}
