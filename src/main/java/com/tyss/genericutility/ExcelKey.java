package com.tyss.genericutility;
/**
 * 
 * @author arkg2
 *
 */
public enum ExcelKey 
{
SHEET("PointOfSaleItems"),SHEET1("Employee"),SHEET2("Customer");
	String key;
	private ExcelKey(String key) 
	{
		this.key=key;
	}
	public String getSheetName() 
	{
		return key;
	}
	

}
