package crm.salesandinventory.objectrepository.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage 
{
	private WebDriver driver;
	private String tabPartialXpath="//span[text()='%s']";
	
	@FindBy(xpath="//div[text()='Sales and Inventory System']")
	private WebElement projectName;

	private WebElement ConvertToWebElement(String PartialXpath,String replaceData) 
	{
		String xpath=String.format(PartialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	public CommonPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CommonAction(TabNames tabname) 
	{
		ConvertToWebElement(tabPartialXpath,tabname.getTab()).click();
	}
	
	public void titleName()
	{
		projectName.click();
	}
}
