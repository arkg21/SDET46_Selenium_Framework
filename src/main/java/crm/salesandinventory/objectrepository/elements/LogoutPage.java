package crm.salesandinventory.objectrepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
	@FindBy(xpath="//span[text()='Prince Ly Cesar']")
	private WebElement selectlogtab ;

	@FindBy(xpath=("(//a[@class='dropdown-item'])[last()]"))
	private WebElement logoutbtn; 

	@FindBy(xpath=("(//a[text()='Logout'])[last()-1]"))
	private WebElement logoutapp; 

	public LogoutPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void SignOutAction() 
	{
		selectlogtab.click();
		logoutbtn.click();
	}

	public void SignOutApp() 
	{

		logoutapp.click();
	}
}