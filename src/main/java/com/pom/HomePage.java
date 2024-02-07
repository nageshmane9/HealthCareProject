package com.pom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class HomePage extends Base
{

	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//img[@alt='client brand banner']") private WebElement LogoBanner;
	@FindBy(xpath="//input[@placeholder='Search']") private WebElement SearchInput;
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
	
	@FindBy(xpath="//i[@class='oxd-icon bi-chevron-left']") private WebElement LeftArrow;
	@FindBy(xpath="//i[@class='oxd-icon bi-question-lg']") private WebElement HelpLink;
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']") private WebElement ProfileTab;
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/li") private List<WebElement> ProfileDropDown;
	
	//About
	@FindBy(xpath="//div[@class='oxd-grid-2 orangehrm-about']") private WebElement Aboutdetails;
	@FindBy(xpath="//div/h6[text()='About']") private WebElement AboutShortPage;
	
	public boolean ValidateHomeLogo()
	{
		if(LogoBanner.isDisplayed())
		{
			System.out.println("WebLogo is displayed");
		}
		return LogoBanner.isDisplayed();
	}
	
	public boolean SearchModuleIsEnabled()
	{
	    
		return SearchInput.isDisplayed() && SearchInput.isEnabled();
	}
	
	public void EnterSearchModule(String text)
	{
	    
		SearchInput.sendKeys(text);
	}
	
	public Admin ClickOnAdminModule()
	{
		if(Admin_Module.isDisplayed()&& Admin_Module.isEnabled())
		{
			Admin_Module.click();
			System.out.println("Clicked on the Admin Module");
			
		}
		
		return new Admin();
	}
	
	public boolean AdminModule()
	{
		return Admin_Module.isDisplayed();
	}
	
	public PIM ClickOnPIMModule()
	{
		if(PIM_Module.isDisplayed()&& PIM_Module.isEnabled())
		{
			PIM_Module.click();
			System.out.println("Clicked on the PIM Module");
			
		}
		
		return new PIM();
	}
	
	public boolean PIMModule()
	{
	
		return PIM_Module.isDisplayed();
	}
	
	public Leave ClickOnLeaveModule()
	{
		if(Leave_Module.isDisplayed()&& Leave_Module.isEnabled())
		{
			Leave_Module.click();
			System.out.println("Clicked on the Leave Module");
			
		}
		
		return new Leave();
	}
	
	public boolean LeaveModule()
	{
	
		return Leave_Module.isDisplayed();
	}
	
	public Time ClickOnTimeModule()
	{
		if(Time_Module.isDisplayed()&& Time_Module.isEnabled())
		{
			Time_Module.click();
			System.out.println("Clicked on the Time Module");
			
		}
		
		return new Time();
	}
	
	public Recruitment ClickOnRecruitmentModule()
	{
		if(Recruitment_Module.isDisplayed()&& Recruitment_Module.isEnabled())
		{
			Recruitment_Module.click();
			System.out.println("Clicked on the Recruitment Module");
			
		}
		
		return new Recruitment();
	}
	
	public MyInfo ClickOnMyInfoModule()
	{
		if(MyInfo_Module.isDisplayed()&& MyInfo_Module.isEnabled())
		{
			MyInfo_Module.click();
			System.out.println("Clicked on the My Info Module");
			
		}
		
		return new MyInfo();
	}
	
	public Performance ClickOnPerformanceModule()
	{
		if(Performance_Module.isDisplayed()&& Performance_Module.isEnabled())
		{
			Performance_Module.click();
			System.out.println("Clicked on the Performance Module");	
		}
		
		return new Performance();
	}
     
	public Dashboard ClickOnDashboardModule()
	{
		if(Dashboard_Module.isDisplayed()&& Dashboard_Module.isEnabled())
		{
			Dashboard_Module.click();
			System.out.println("Clicked on the Dashboard Module");	
		}
		
		return new Dashboard();
	}
	
	public Directory ClickOnDirectoryModule()
	{
		if(Directory_Module.isDisplayed()&& Directory_Module.isEnabled())
		{
	       	Directory_Module.click();
			System.out.println("Clicked on the Directory Module");	
		}
		
		return new Directory();
	}
	
	public Maintenance ClickOnMaintenanceModule()
	{
		if(Maintenance_Module.isDisplayed()&& Maintenance_Module.isEnabled())
		{
			Maintenance_Module.click();
			System.out.println("Clicked on the Maintenance Module");	
		}
		
		return new Maintenance();
	}
	
	public Claim ClickOnClaimModule()
	{
		if(Claim_Module.isDisplayed()&& Claim_Module.isEnabled())
		{
			Claim_Module.click();
			System.out.println("Clicked on the Claim Module");	
		}
		
		return new Claim();
	}
	
	public Buzz ClickOnBuzzModule()
	{
		if(Buzz_Module.isDisplayed()&& Buzz_Module.isEnabled())
		{
			Buzz_Module.click();
			System.out.println("Clicked on the Buzz Module");	
		}
		
		return new Buzz();
	}
	
	
	public void ClickOnLeftArrow()
	{
		if(LeftArrow.isDisplayed()&&LeftArrow.isEnabled())
		{
			LeftArrow.click();
		}
		
	}
	
	public void ClickOnHelpLink()                  // Check it
	{
		if(HelpLink.isDisplayed())
		{
		HelpLink.click();
		System.out.println("Clicked on the Help Link");
		
		Set<String> set= driver.getWindowHandles();
		ArrayList<String> arr= new ArrayList(set);
		String child= arr.get(1);
		
		  driver.switchTo().window(child);
		
		}
		
	}
	
	public boolean ClickOnProfileTab()
	{
		boolean cd= ProfileTab.isDisplayed() && ProfileTab.isEnabled();
		ProfileTab.click();
		System.out.println("clicked on Profile Tab");
		return cd;
	}
	
	public boolean SelectProfileTabsForValidateAbout()
	{
		ProfileTab.click();
		for(WebElement i : ProfileDropDown)
		{
			String a=i.getText();
			System.out.println(a);
			if(a.equals("About"))
			{
				i.click();
				break;
			}
		}
		
		return AboutShortPage.isDisplayed();
	}
	
	public String AboutDetails()
	{
		return Aboutdetails.getText();
	}
	
	public void SelectProfileTabsForValidateSupport()
	{
		ProfileTab.click();
		for(WebElement i : ProfileDropDown)
		{
			String a=i.getText();
			System.out.println(a);
			if(a.equals("Support"))
			{
				i.click();
				break;
			}
		}		
	}
	
	public void SelectProfileTabsForValidateChangePassword()
	{
		ProfileTab.click();
		for(WebElement i : ProfileDropDown)
		{
			String a=i.getText();
			System.out.println(a);
			if(a.equals("Change Password"))
			{
				i.click();
				break;
			}
		}		
	}
	
	public void SelectProfileTabsForValidateLogout()
	{
		ProfileTab.click();
		for(WebElement i : ProfileDropDown)
		{
			String a=i.getText();
			System.out.println(a);
			if(a.equals("Logout"))
			{
				i.click();
				break;
			}
		}		
	}
	
	
	
	
	
	
}
