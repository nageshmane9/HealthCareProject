package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;

public class Utility extends Base
{

	 public static void Implicitlywait()
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  
	 }
	 
	public static Sheet getsheet(String sheetname) throws IOException
	{
		FileInputStream fileinputstream = new FileInputStream(projectpath+"\\src\\main\\resources\\Exeldata\\OrangeHrmLogin.xlsx");
		
		Sheet sh=WorkbookFactory.create(fileinputstream).getSheet(sheetname);
		return sh;
	}
	
	public static Object getSingleData(int rowNum,int cellNum,Sheet sh)
	{
		if(sh.getRow(rowNum).getCell(cellNum).getCellType().toString().equalsIgnoreCase("string"))
		{
			String ab=sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
			System.out.println(ab);
			return ab;
		}
		else 
		{
			double ab=sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();
			return ab;
		}		
	}
	
	public static HashMap<String,String> getAllData(Sheet sh) throws IOException
	{
		int rowCount=sh.getLastRowNum();
		
		HashMap<String,String> map = new HashMap();
		
		Object[][] dataprovider = new Object[rowCount][2];
		
		for(int i=0;i<=rowCount;i++)
		{
			int cellNum = sh.getRow(i).getLastCellNum();
			for(int j=0;j<cellNum;j++)
			{
				
				map.put(sh.getRow(i).getCell(j).getStringCellValue(),sh.getRow(i).getCell(j).getStringCellValue());
			}
		}
		
		return map;
		
	}
	 
	
	public static  Object[][] getData(Sheet sh)
	{
		int rowCount=sh.getLastRowNum();
		
		Map<String,String> finalData = new HashMap();
		
		Object[][] excelData = new Object[rowCount][1];  
		
		for(int i=0;i<rowCount;i++)
		{
			Map<String,String> data = new HashMap();
			
			int colNum=sh.getRow(i).getLastCellNum();
			
			for(int j=0;j<colNum;j++)
			{
				if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("string"))
				{
					data.put(sh.getRow(0).getCell(j).getStringCellValue() , sh.getRow(i+1).getCell(j).getStringCellValue());
				}
				else if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("numeric"))
				{
					data.put(sh.getRow(0).getCell(j).getStringCellValue() , sh.getRow(i+1).getCell(j).getStringCellValue());
				}
				else
				{
					System.out.println("Cell type not match");
				}
			}
			excelData[i][0] = data;  
			
			data.forEach(finalData :: put);
			
		}
		return excelData;
	}
	 
	  public static  void WaitForVisibility( String e)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		}
	 
	  public static  void WaitForVisibilityElement( WebElement e)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			  wait.until(ExpectedConditions.elementToBeClickable(e));
		}
	 
	  public void AlertIsPresent()
	  {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.alertIsPresent());
	  }
	 
	  
	  public static void getScreenshotMethod(String testname) throws IOException
	  {
		  
		  File screenshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(screenshotfile, new File(projectpath+".\\src\\test\\resources\\Scrrenshots"+testname+".jpg"));
	 
	  }
	 
	
	 
	
}
