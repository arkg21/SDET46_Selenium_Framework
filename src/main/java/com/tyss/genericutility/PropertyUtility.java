package com.tyss.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains re-usable methods to handle property files
 * @author arkg2
 *
 */
public class PropertyUtility 
{
	FileInputStream fis=null;
	FileOutputStream fos=null;
	Properties p=null;
	public PropertyUtility() 
	{
		initialize();
		
	}
	public void initialize() 
	{

		try 
		{
			fis=new FileInputStream(Constants.TEST_PROPERTY_FILE_PATH);
			p=new Properties();
			p.load(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void set() 
	{
		try 
		{
			fos=new FileOutputStream(Constants.TEST_PROPERTY_FILE_PATH,true);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
/**
 * This method is used to fetch the data from property files
 * @param key
 * @return
 */
	public String getPropertyData(PropertyKey key) 
	{
		String k=key.name().toLowerCase();
		String data=p.getProperty(k,"").trim();
		return data;
	}
	/**
	 * This method is used to write the data to property files
	 * @param key
	 * @param value
	 */
	public void setPropertyData(String key,String value) 
	{
		p.setProperty(key, value);
		try 
		{
			p.store(fos, " New Data Added ");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	
}

