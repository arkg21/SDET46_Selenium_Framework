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

public class SellingAnItemForNewCustomerTest extends ConfigClass
{
	@Record(author = "Archit")
	@Test
	public void sellingAnItemForNewCustomerTest()
	{
		excelutils.initializeExcel(); 
		String customerFN = excelutils.getExcelData(ExcelKey.SHEET2.getSheetName(), "AddUser", "Username");
		String customerLN = excelutils.getExcelData(ExcelKey.SHEET2.getSheetName(), "AddUser", "Password");
		String customerPH = excelutils.getExcelData(ExcelKey.SHEET2.getSheetName(), "AddUser", "PhoneNumber");
		String quantity = excelutils.getExcelData(ExcelKey.SHEET.getSheetName(), "Products", "Keyboard");
		String amount=excelutils.getExcelData(ExcelKey.SHEET.getSheetName(), "Quantity", "2");
		excelutils.closeExcel();

		CommonPage cp=new CommonPage(driver);
		cp.CommonAction(TabNames.POS);

		String actPosURL=driver.getCurrentUrl();
		String expPosURL="http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/pos.php";
		assertEquals(actPosURL, expPosURL, "Expected URL is not been executed");

		PointOfSalePage pos=new PointOfSalePage(driver);
		pos.addToCart(quantity);

		driver.findElement(By.xpath("(//a[@href='#'])[last()]")).click();
		waitUtility.explicitVisibilityOfElementLocated(driver, By.xpath("(//input[@name='firstname'])[last()-2]"));
		String actText=driver.findElement(By.xpath("(//h5[@id='exampleModalLabel'])[last()-3]")).getText();
		String expText="Add Customer";
		assertEquals(actText, expText, "Expected text is not been displayed");

		pos.addCustomerDetails(customerFN, customerLN, customerPH);

		pos.addCustomer(select,"Luffy D Monkey");

		waitUtility.explicitVisibilityOfElementLocated(driver, By.xpath("//input[@id='txtNumber']"));
		pos.paymentOption(amount);

		alert.initializeAlert(driver);
		String actMessage=alert.getTextOfAlert();
		String expMessage="Success.";
		assertEquals(actMessage, expMessage, "Expected Pop-Up is not been displayed");
		alert.alertAccept();
	}
}
