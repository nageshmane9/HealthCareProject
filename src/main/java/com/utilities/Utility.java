package com.utilities;

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

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
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
	
	public static void getAllData(Sheet sh) throws IOException
	{
		
		HashMap<Object,Object> map = new HashMap();
		
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			int cellNum = sh.getRow(i).getLastCellNum();
			
				Object a=sh.getRow(i).getCell(0).getStringCellValue();
				Object b=sh.getRow(i).getCell(1).getStringCellValue();
				
				map.put(a, b);
			
		}
		System.out.println(map);
		
		for(Map.Entry e: map.entrySet())
		{
			
			System.out.println(e.getKey()+" "+e.getValue());
		}
		
		
		
		/*
		// By using Iterator
		 Iterator<Entry<String,String> > iterator= hm.entrySet().iterator();
	        
	        while(iterator.hasNext())
	        {
	        	Map.Entry<String,String> e1=(Map.Entry<String, String>)iterator.next();
	        	
	        	System.out.println(e1.getKey()+" "+e1.getValue());
	        }
	        
		  */
			
	}
	 
	 
	  public static  void WaitForVisibility( String e)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		}
	 
	 
	  public void AlertIsPresent()
	  {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.alertIsPresent());
	  }
	 
	 
	
	 
	
}
