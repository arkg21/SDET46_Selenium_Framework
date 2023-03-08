package com.tyss.genericutility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility {
	

	/**
	 * This generic method will select the option using index
	 * @param index
	 */
	public void selectByIndex(int index, WebElement element) {
		 Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This generic method will select the option using value
	 * @param value
	 */
	public void selectByValue(String value,WebElement element) {
		 Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This generic method will select the option using visible text
	 * @param visibleText
	 */
	public void selectByVisibleText(String visibleText,WebElement element) {
		 Select s=new Select(element);
		s.selectByVisibleText(visibleText);
	}
	public void printOptions(WebElement element) {
		 Select s=new Select(element);
		List<WebElement> options = s.getOptions();
		for(WebElement option:options) {
			System.out.println(option.getText());
		}
	}
	/**
	 * This generic method will print the selected options
	 */
	public void printSelectedOptions(WebElement element) {
		Select s=new Select(element);
		List<WebElement> selectedOptions = s.getAllSelectedOptions();
		for(WebElement selectedOption:selectedOptions) {
			System.out.println(selectedOption.getText());
		}
	}
	/**
	 * This generic method will select all options 
	 */
	public void selectAllOption(WebElement element) {
		Select s=new Select(element);
		List<WebElement> options = s.getOptions();
		for(int i=0;i<options.size();i++) {
			s.selectByIndex(i);
		}

	}
/**
 * This generic method will deselect the option using index
 * @param index
 */
	public void deSelectByIndex(int index, WebElement element) {
		Select s=new Select(element);
		s.deselectByIndex(index);
	}
	/**
	 * This generic method will deselect the option using value
	 * @param value
	 */
	public void deSelectByValue(String value,WebElement element) {
		Select s=new Select(element);
		s.deselectByValue(value);
		
	}
	/**
	 * This generic method will deselect the option using visible text
	 * @param visibleText
	 */
	public void deSelectByVisibleText(String visibleText,WebElement element) {
		Select s=new Select(element);
		s.deselectByVisibleText(visibleText);


	}
	/**
	 * This generic method will deselect all the options using 
	 */
	public void deSelectAllOption(WebElement element) {
		Select s=new Select(element);
		List<WebElement> options = s.getOptions();
		for(int i=0;i<options.size();i++) {
			s.deselectByIndex(i);
		}

	}


}
