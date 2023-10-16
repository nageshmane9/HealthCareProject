package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

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
	
	
     public String getUsername()
     {
    	WaitForVisibility("//p[text()='Username : Admin']");
    	
    	 return username.getText();
    	 
    	
     }
     
     public String getPassword()
     {
    	 return password.getText();
     }
     
     public void ClickOnLoginButton()
     {
    	 LoginButton.click();
     }

	
	public void setInputusername(String Setusername) {
		 inputusername.sendKeys(Setusername);
	}

	
	public void setInputpassword(String Setpassword) {
		 inputpassword.sendKeys(Setpassword);
	}
     
     
	
	
}
