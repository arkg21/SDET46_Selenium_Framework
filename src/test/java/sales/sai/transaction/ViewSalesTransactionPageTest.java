package sales.sai.transaction;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tyss.genericutility.ConfigClass;
import com.tyss.genericutility.ExcelKey;
import com.tyss.genericutility.Record;

import crm.salesandinventory.objectrepository.elements.CommonPage;
import crm.salesandinventory.objectrepository.elements.PointOfSalePage;
import crm.salesandinventory.objectrepository.elements.TabNames;
import crm.salesandinventory.objectrepository.elements.TransactionPage;

public class ViewSalesTransactionPageTest extends ConfigClass
{
	@Record(author = "Archit")
	@Test
	public void viewSalesTransactionPageTest() 
	{	
		excelutils.initializeExcel(); 
		String quantity = excelutils.getExcelData(ExcelKey.SHEET.getSheetName(), "Products", "Keyboard");
		String amount=excelutils.getExcelData(ExcelKey.SHEET.getSheetName(), "Quantity", "1");
		excelutils.closeExcel();

		String actURL=driver.getCurrentUrl();
		String expURL="http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/index.php";
		assertEquals(actURL, expURL, "Expected URL is not been executed");
		
		CommonPage cp=new CommonPage(driver);
		cp.CommonAction(TabNames.POS);
		
		String actPosURL=driver.getCurrentUrl();
		String expPosURL="http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/pos.php";
		assertEquals(actPosURL, expPosURL, "Expected URL is not been executed");
		
		PointOfSalePage pos=new PointOfSalePage(driver);
		pos.addToCart(quantity);
		
		pos.addCustomer(select,"Tony Stark");
		
		waitUtility.explicitWaittextToBePresentInElementLocated(driver, By.xpath("//h5[@id='exampleModalCenterTitle']"), "SUMMARY");
		String actText=driver.findElement(By.xpath("//h5[@id='exampleModalCenterTitle']")).getText();
		String expText="SUMMARY";
		assertEquals(actText, expText, "Expected text is not been displayed");
		
		waitUtility.explicitWaitVisibilityOf(driver, driver.findElement(By.id("txtNumber")));
		pos.paymentOption(amount);
		
		alert.initializeAlert(driver);
		String actMessage=alert.getTextOfAlert();
		String expMessage="Success.";
		assertEquals(actMessage, expMessage, "Expected Pop-Up is not been displayed");
		alert.alertAccept();
		
		cp.titleName();
		cp.CommonAction(TabNames.TRANSACTION);
		
		TransactionPage tp=new TransactionPage(driver);
		tp.viewCustomerDetails();
	}
}
