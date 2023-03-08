package crm.salesandinventory.objectrepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericutility.SelectUtility;

public class AccountsPage 
{
	private WebDriver driver;
	
	@FindBy(name="empid")
	private WebElement employeeid;
	
	@FindBy(xpath="(//input[@name='username'])[last()]")
	private WebElement username;
	
	@FindBy(xpath="(//input[@name='password'])[last()]")
	private WebElement password;
	
	@FindBy(xpath="(//button[@class='btn btn-success'])[last()]")
	private WebElement saveButton;
	
	@FindBy(xpath="//a[@href='user.php']")
	private WebElement accountsSection;
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addingCustomer(SelectUtility s,String text, String user, String pass)
	{
		s.selectByVisibleText(text, employeeid);
		employeeid.click();
		username.click();
		username.sendKeys(user);
		password.click();
		password.sendKeys(pass);
		saveButton.click();
		accountsSection.click();
	}



}
