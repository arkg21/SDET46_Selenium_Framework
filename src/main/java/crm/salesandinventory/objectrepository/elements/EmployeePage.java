package crm.salesandinventory.objectrepository.elements;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericutility.SelectUtility;
import com.tyss.genericutility.WaitUtility;

public class EmployeePage 
{
	private WebDriver driver;
	private String tabPartialXpath=("//div[@id='employeeModal']//input[@name='%s']");

	@FindBy(xpath="//a[@class='btn btn-primary bg-gradient-primary' and @href='#']")
	private WebElement createEmpButton;

	@FindBy(name="gender")
	private WebElement selectGender;

	@FindBy(name="jobs")
	private WebElement selectJobs;

	@FindBy(id="province")
	private WebElement selectProvince;

	@FindBy(id="city")
	private WebElement selectCity;

	@FindBy(xpath="//div[@id='employeeModal']//input[@name='lastname']")
	private WebElement selectLast;

	@FindBy(xpath="//div[@id='employeeModal']//input[@name='email']")
	private WebElement selectEmail;

	@FindBy(xpath="//div[@id='employeeModal']//input[@name='phonenumber']")
	private WebElement selectNumb;

	@FindBy(xpath="//div[@id='employeeModal']//input[@name='hireddate']")
	private WebElement selectHiredate;


	@FindBy(xpath="//div[@id='employeeModal']//input[@name='firstname']")
	private WebElement selectFirst;





	private WebElement convertToWebElement(String key) 
	{
		return driver.findElement(By.name(key));
	}

	public EmployeePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void addEmployeeDetails(SelectUtility s,String text, String job, String province, String city, String first, String last, String emailid, String phone, String date) 
	{
		//waitUtility.waitAndSend(selectFirst, 10, "abc", 1000); WaitUtility waitUtility
		s.selectByVisibleText(text, selectGender);
		s.selectByVisibleText(job, selectJobs);
		s.selectByVisibleText(province, selectProvince);
		s.selectByVisibleText(city, selectCity);
		selectFirst.sendKeys(first);
		selectLast.sendKeys(last);
		selectEmail.sendKeys(emailid);
		selectNumb.sendKeys(phone);
		selectHiredate.click();
		selectHiredate.sendKeys(date);
	}

	public void createEmployeeButton()
	{
		createEmpButton.click();
	}
	//for(Entry <String,String>keyValue:map.entrySet())
	//{
		//convertToWebElement(keyValue.getKey()).sendKeys(keyValue.getValue());
	//}
}
