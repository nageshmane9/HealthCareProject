package com.pom;

import java.util.ArrayList;
import java.util.Set;

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
	@FindBy(xpath="//img[@alt='company-branding']") private WebElement logoBranding;
	@FindBy(xpath="//div[@class='orangehrm-login-logo']/img[@alt='orangehrm-logo']") private WebElement logo;
	@FindBy(xpath="//p[text()='Invalid credentials']") WebElement InvalidcredentialsMessage;
	
	@FindBy(xpath="//span[text()='Required'][1]") private WebElement RequiredFieldMessageOfUsername;
	@FindBy(xpath="//span[text()='Required']") private WebElement RequiredFieldMessageOfPassword;
	
	@FindBy(xpath="//p[text()='OrangeHRM OS 5.5']") private WebElement WebApplicationVersion;
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-copyright'][2]") private WebElement CopyRightText ;
	@FindBy(xpath="//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']") private WebElement LinkdnLinkIcon;
	@FindBy(xpath="//a[@href='https://www.facebook.com/OrangeHRM/']") private WebElement FacebookLinkIcon;
	@FindBy(xpath="//a[@href='https://twitter.com/orangehrm?lang=en']") private WebElement TwitterLinkIcon ;
	@FindBy(xpath="//a[@href='https://www.youtube.com/c/OrangeHRMInc']") private WebElement YouTubeLinkIcon;
	
     public String getUsername()
     {
    	
    	String a= username.getText();
    	System.out.println("Username-"+a.substring(a.indexOf('A')));
    	
    	 return a.substring(a.indexOf('A')); 
    	 
     }
     
     public String getPassword()
     {
    	 String a=password.getText();
    	 System.out.println("Password-"+a.substring(11));
    	 return a.substring(11);
     }
     
    public void setInputusername(String Setusername) 
 	{
 		 inputusername.sendKeys(Setusername);
 	}

 	
 	public void setInputpassword(String Setpassword) 
 	{
 		 inputpassword.sendKeys(Setpassword);
 	}
 	
 	
     public HomePage ClickOnLoginButton()      //  Page Linking
     {
    	if(LoginButton.isDisplayed()&& LoginButton.isEnabled())
    	{
    		 LoginButton.click();
    		 System.out.println("Clicked on login Button");
    	}
    	
    	return new HomePage();
     }

     
     public boolean Logo()
 	{
    	 Utility.WaitForVisibility("//div[@class='orangehrm-login-logo']/img[@alt='orangehrm-logo']");
 		if(logo.isDisplayed()) 
 		{
 			System.out.println("Logo is displayed");
 		}
 		return logo.isDisplayed();
 	}
 	
     
	public boolean LogBranding()
	{
		Utility.WaitForVisibility("//img[@alt='company-branding']");
		if(logoBranding.isDisplayed())
		{
			System.out.println("Logo is displayed");
		}
		return logoBranding.isDisplayed();
	}
	
	
	public ForgotPasswordPage ClickOnforgotpasswordLink()              // Page Linking
	{
		if(forgotpasswordlink.isDisplayed() && forgotpasswordlink.isEnabled())
		{
			forgotpasswordlink.click();
			System.out.println("Clicked on forgotPassword link");
		}
		 return new ForgotPasswordPage();
	}
	
	
	public String InvalidCredentialsMessage()
	{
		if(InvalidcredentialsMessage.isDisplayed())
		{
			System.out.println("Invalid Credentials message is displayed");
		}
		
		return InvalidcredentialsMessage.getText();
		
	}
	
	
	public String RequiredErrorMessageforUsername()      // required message of username
	{
		if(RequiredFieldMessageOfUsername.isDisplayed())
		{
			System.out.println("Required message is displayed");
		}
		return RequiredFieldMessageOfUsername.getText();
	}
     
	
	public String RequiredErrorMessageforPassword()           // required message of password
	{
		String ms=RequiredFieldMessageOfPassword.getText();
		System.out.println(ms);
			System.out.println("Required message is displayed");
	           
		return ms;
	}
	
	public String GetWebApplicationVersionText()
	{
		String a=WebApplicationVersion.getText();
		System.out.println(a);
		
		return a;
	}
	
	public String GetCopyRightText()
	{
		String a=CopyRightText.getText();
		System.out.println(a);
		return a;
	}
	
	public boolean ClickOnLinkdnLinkIcon()
	{
		boolean cd=LinkdnLinkIcon.isDisplayed() && LinkdnLinkIcon.isEnabled();
		LinkdnLinkIcon.click();
		
		Set<String> set= driver.getWindowHandles();
		ArrayList<String> arr= new ArrayList(set);
		String child=arr.get(1);
		driver.switchTo().window(child);
		
		return cd;
		
	}
	
	public boolean ClickOnFacebookLinkIcon()
	{
		boolean cd=FacebookLinkIcon.isDisplayed() && FacebookLinkIcon.isEnabled();
		FacebookLinkIcon.click();
		Set<String> set= driver.getWindowHandles();
		ArrayList<String> arr= new ArrayList(set);
		String child=arr.get(1);
		driver.switchTo().window(child);
		
		return cd;
		
	}
	
	public boolean ClickOnTwitterLinkIcon()
	{
		boolean cd= TwitterLinkIcon.isDisplayed() && TwitterLinkIcon.isEnabled();
		TwitterLinkIcon.click();
		Set<String> set= driver.getWindowHandles();
		ArrayList<String> arr= new ArrayList(set);
		String child=arr.get(1);
		driver.switchTo().window(child);
		
		return cd;
	}
	
	public boolean ClickOnYoutubeLinkIcon()
	{
		boolean cd= YouTubeLinkIcon.isDisplayed() && YouTubeLinkIcon.isEnabled();
		YouTubeLinkIcon.click();
		Set<String> set= driver.getWindowHandles();
		ArrayList<String> arr= new ArrayList(set);
		String child=arr.get(1);
		driver.switchTo().window(child);
		
		return cd;
	}
     
	
	
}
