package com.tyss.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author arkg2
 *
 */
public class ExcelUtility 
{
	FileInputStream fis=null;
	Workbook workbook=null;
	DataFormatter df=null;
	Sheet sheet =null;
	FileOutputStream fos;
	/**
	 * This generic method will initialize {@link FileInputStream} {@link Workbook} {@link FileOutputStream}
	 */
	public void initializeExcel() 
	{
		df=new DataFormatter();
		try 
		{
			fis=new FileInputStream(Constants.TEST_EXCEL_FILE_PATH);
			workbook=WorkbookFactory.create(fis);
			fos=new FileOutputStream(Constants.TEST_EXCEL_FILE_PATH,true); 
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
		catch (EncryptedDocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * This generic method will fetch the data from excel sheet using row number and column number
	 * @param sheetName
	 * @param rowNumber
	 * @param columnNumber
	 * @return
	 */
	public String getExcelData(String sheetName,int rowNumber,int columnNumber) 
	{
		sheet = workbook.getSheet(sheetName);
		return df.formatCellValue(sheet.getRow(rowNumber-1).getCell(columnNumber-1));
	}
	/**
	 * This generic method will fetch the data from excel sheet using sheet name and key
	 * @param sheetName
	 * @param testScriptName
	 * @param key
	 * @return
	 */
	public String getExcelData(String sheetName,String testScriptName,String key) 
	{
		sheet = workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		for(int i=1;i<=rowCount;i++) 
		{
			String actTestScriptName=df.formatCellValue(sheet.getRow(i).getCell(0));
			if(actTestScriptName.equalsIgnoreCase(testScriptName)) 
			{
				short cellCount = sheet.getRow(i).getLastCellNum();
				for(int j=1;j<cellCount;j++) 
				{
					String expKey = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(expKey.equalsIgnoreCase(key)) 
					{
						String value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
						return value;
					}
				}
				break;
			}
		}
		return null;

	}
	/**
	 * This generic method will fetch the datas from excel sheet using row number and column number
	 * @param sheetName
	 * @param testScriptName
	 * @param key
	 * @return
	 */
	public List<String> getExcelDatas(String sheetName,String testScriptName,String key) 
	{
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		sheet = workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		for(int i=1;i<=rowCount;i++) 
		{
			String actTestScriptName=df.formatCellValue(sheet.getRow(i).getCell(0));
			if(actTestScriptName.equalsIgnoreCase(testScriptName)) 
			{
				short cellCount = sheet.getRow(i).getLastCellNum();
				for(int j=1;j<cellCount;j++) 
				{
					String keys = df.formatCellValue(sheet.getRow(i).getCell(j));
					List<String>values=new ArrayList<String>();
					for(int k=i+1;;k++) 
					{

						String value=df.formatCellValue(sheet.getRow(k).getCell(j));
						if(value.equals(""))
						{
							break;
						}
						else 
						{
							values.add(df.formatCellValue(sheet.getRow(k).getCell(j)));
						}
					}
					map.put(keys, values);
				}           
				break;
			}
		}
		return map.get(key);
	}
	/**
	 * This generic method will set the data from excel sheet using row number and column number
	 * @param sheetName
	 * @param value
	 * @param rowNumber
	 * @param columnNumber
	 */
	public void setExcelData(String sheetName,String value,int rowNumber,int columnNumber) 
	{
		try 
		{
			workbook.write(fos);
			sheet=workbook.getSheet(sheetName);
			sheet.getRow(rowNumber-1).createCell(columnNumber-1).setCellValue(value);

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
	/**
	 * This generic method will set the data in excel sheet using sheet name and key
	 * @param testScriptName
	 * @param sheetName
	 * @param key
	 * @param value
	 */
	public void setExcelData(String testScriptName,String sheetName,String key,String value) 
	{
		sheet = workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		for(int i=1;i<=rowCount;i++) 
		{
			String actTestScriptName=df.formatCellValue(sheet.getRow(i).getCell(0));
			if(actTestScriptName.equalsIgnoreCase(testScriptName)) 
			{
				short cellCount = sheet.getRow(i).getLastCellNum();
				for(int j=1;j<cellCount;j++) 
				{
					String expKey = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(expKey.equalsIgnoreCase(key)) 
					{
						try 
						{
							workbook.write(fos);
							sheet=workbook.getSheet(sheetName);
							sheet.getRow(i+1).createCell(j).setCellValue(value);
						} catch (IOException e) 
						{
							e.printStackTrace();
						}
						break;
					}
				}
				break;
			}
		}

	}
	/**
	 * This generic method will set the datas in excel sheet using sheet name and key
	 * @param sheetName
	 * @param testScriptName
	 * @param key
	 * @param values
	 */
	public void setExcelDatas(String sheetName,String testScriptName,String key,List<String>values) 
	{
		sheet = workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		for(int i=1;i<=rowCount;i++) 
		{
			String actTestScriptName=df.formatCellValue(sheet.getRow(i).getCell(0));
			if(actTestScriptName.equalsIgnoreCase(testScriptName)) 
			{
				short cellCount = sheet.getRow(i).getLastCellNum();
				for(int j=1;j<cellCount;j++) 
				{
					String actkey = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(actkey.equals(key)) 
					{
						try 
						{
							workbook.write(fos);
						} 
						catch (IOException e) 
						{
							e.printStackTrace();
						}
						sheet=workbook.getSheet(sheetName);

						for(int k=0;k<values.size();k++) 
						{
							sheet.getRow(i+k+1).createCell(j).setCellValue(values.get(k));	
						}
						break;
					}

				}           
				break;
			}
		}
	}
	/**
	 * This generic method will fetch the datas from excel sheet using sheet name and key
	 * @param sheetName
	 * @param testScriptName
	 * @return
	 */
	public Map<String, String> getExcelData(String sheetName,String testScriptName) 
	{
		 sheet = workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		Map<String,String>map=new HashMap<String,String>();
		for(int i=1;i<=rowCount;i++) 
		{
			String actTestScriptName=df.formatCellValue(sheet.getRow(i).getCell(0));
			if(actTestScriptName.equalsIgnoreCase(testScriptName)) 
			{
				short cellCount = sheet.getRow(i).getLastCellNum();
				for(int j=1;j<cellCount;j++) 
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
						 map.put(key, value);
				}
				break;
			}
		}
		return map;
	}
	
	
	/**
	 * This generic method will close the workbook
	 */
	public void closeExcel() 
	{
		try 
		{
			fos.close();
			workbook.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

}
