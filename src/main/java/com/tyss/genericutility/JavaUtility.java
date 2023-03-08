package com.tyss.genericutility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**
 * This generic class contains some methods of java
 * @author arkg2
 *
 */
public class JavaUtility 
{
	SimpleDateFormat sdf;

	/**
	 * This generic method will generate random number
	 * @param boundary
	 * @return
	 */
	public int getRandomNumber(int boundary) 
	{
		return new Random().nextInt(boundary);
	}
	/**
	 * This generic method will return current date
	 * @return 
	 */
	public String getCurrentStringDate() 
	{
		sdf=new SimpleDateFormat();
		Calendar cal=Calendar.getInstance();
		String date=sdf.format(cal.getTime());
		return date;

	}
	/**
	 * This generic method will return the date in particular pattern
	 * @param d
	 * @param pattern
	 * @return
	 */
	public String getStringDate(String d,String pattern) 
	{
		sdf=new SimpleDateFormat(pattern);
		Calendar cal=Calendar.getInstance();
		try 
		{
			cal.setTime(sdf.parse(d));

		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		String date=sdf.format(cal.getTime());
		return date;

	}
	/**
	 * This generic method will add specific no of days to current date
	 * @param noofdays
	 * @param pattern
	 * @return
	 */
	public String addDayToCurrentDate(int noofdays,String pattern)
	{
		sdf=new SimpleDateFormat(pattern);
		Calendar cal=Calendar.getInstance();
		String date=sdf.format(cal.getTime());
		try 
		{
			cal.setTime(sdf.parse(date));
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH, noofdays);
		return (sdf.format(cal.getTime()));
	}
	/**
	 *  This generic method will substract specific no of days to current date
	 * @param noofdays
	 * @param pattern
	 * @return
	 */
	public String substractDayToCurrentDate(int noofdays,String pattern)
	{
		sdf=new SimpleDateFormat(pattern);
		Calendar cal=Calendar.getInstance();
		String date=sdf.format(cal.getTime());
		try 
		{
			cal.setTime(sdf.parse(date));
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH, -noofdays);
		return (sdf.format(cal.getTime()));

	}
	/**
	 *  This generic method will add specific no of days to specified date
	 * @param dateString
	 * @param noofdays
	 * @return
	 */

	public String addDayToDate(String dateString,int noofdays)
	{
		String date="";
		sdf=new SimpleDateFormat("dd_MMMM_yyyy");
		Calendar cal=Calendar.getInstance();
		try 
		{
			cal.setTime(sdf.parse(dateString));
			cal.add(Calendar.DAY_OF_MONTH, noofdays);
			date= sdf.format(cal.getTime());
		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	/**
	 *  This generic method will substract specific no of days to specific date
	 * @param dateString
	 * @param noofdays
	 * @return
	 */
	public String substractDayToDate(String dateString,int noofdays)
	{
		String date="";
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MMMM_yyyy");
		Calendar cal=Calendar.getInstance();
		try 
		{
			cal.setTime(sdf.parse(dateString));
			cal.add(Calendar.DAY_OF_MONTH,-noofdays);
			date= sdf.format(cal.getTime());
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * This method is used to encode username and password of login application
	 * @param s
	 * @return
	 */
	public String encode(String s)
	{
		byte[] byteA=s.getBytes();
		byte[] byteB= Base64.getEncoder().encode(byteA);
		String k=new String(byteB);
		return k;
	}
	/**
	 * This method is used to decode username and password of login application
	 * @param s
	 * @return
	 */
	public String decoding(String s)
	{
		byte[] byteC=s.getBytes();
		byte[] byteD=Base64.getDecoder().decode(byteC);
		String q=new String(byteD);
		return q;
	}
}
