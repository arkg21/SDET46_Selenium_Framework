package crm.salesandinventory.objectrepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage 
{ 	
 	@FindBy(xpath="//a[@class='btn btn-primary bg-gradient-primary' and @href='trans_view.php?action=edit & id=25']")
 	private WebElement viewTab;

	public TransactionPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void viewCustomerDetails() 
	{
		viewTab.click();
	}
}