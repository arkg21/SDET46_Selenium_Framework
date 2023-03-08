package crm.salesandinventory.objectrepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericutility.SelectUtility;

public class PointOfSalePage 
{
	@FindBy(xpath="//a[text()='Keyboard']")
	private WebElement keyboard;
	
	@FindBy(name="quantity")
	private WebElement quantity;
	
	@FindBy(name="addpos")
	private WebElement add;
	
	@FindBy(name="customer")
	private WebElement addingCustomer;
	
	@FindBy(xpath="//button[text()='SUBMIT']")
	private WebElement submitButton;
	
	@FindBy(id="txtNumber")
	private WebElement amoun;
	
	@FindBy(xpath="//h3[@class='py-0']")
	private WebElement proccedButton;
	
	@FindBy(xpath="//h3[@class='py-0']")
	private WebElement grandText;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-block']")
	private WebElement proceedPayment;
	
	@FindBy(xpath="(//input[@name='firstname'])[last()-2]")
	private WebElement first;
	
	@FindBy(xpath="(//input[@name='lastname'])[last()-2]")
	private WebElement last;
	
	@FindBy(xpath="(//input[@name='phonenumber'])[last()-1]")
	private WebElement phone;
	
	@FindBy(xpath="(//button[@class='btn btn-success'])[last()-2]")
	private WebElement saveButton;
	
	public PointOfSalePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart(String quan)
	{
		keyboard.click();
		quantity.sendKeys(quan);
		add.click();
	}
	
	public void addCustomer(SelectUtility s,String text)
	{	
		s.selectByVisibleText(text,addingCustomer);
		addingCustomer.click();
		submitButton.click();
	}
	
	public void paymentOption(String amt)
	{
		amoun.sendKeys(amt);
		proccedButton.click();
		grandText.click();
		proceedPayment.click();
	}
	
	public void addCustomerDetails(String firstName, String lastName, String PhNo)
	{
		first.click();
		first.sendKeys(firstName);
		first.click();
		last.click();
		last.sendKeys(lastName);
		last.click();
		phone.click();
		phone.sendKeys(PhNo);
		phone.click();
		saveButton.click();
	}
}
