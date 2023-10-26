package ListenerPKG;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utilities.Utility;

public class MyListener implements ITestListener
{


	@Override
	public void onTestSuccess(ITestResult result) 
	{
	
		try 
		{
			Utility.getScreenshotMethod(result.getName());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		
	}

	
	
	

}
