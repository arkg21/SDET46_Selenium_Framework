package sales.sai.employee;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tyss.genericutility.ConfigClass;

import crm.salesandinventory.objectrepository.elements.AccountsPage;
import crm.salesandinventory.objectrepository.elements.CommonPage;
import crm.salesandinventory.objectrepository.elements.EmployeePage;
import crm.salesandinventory.objectrepository.elements.TabNames;

public class CreateEmployeeTest extends ConfigClass
{
	@Test
	public void createEmployeeTest()
	{	
		excelutils.initializeExcel(); 
		Map<String, String> data = excelutils.getExcelData("Employee", "AddEmployee");
		
		String fn=data.get("firstname");
		String ln=data.get("lastname");
		String phn=data.get("phonenumber");
		String email=data.get("email");
		String hire=data.get("hireddate");
		String gender= data.get("gender");
		String job = data.get("jobs"); 
		String province = data.get("province");
		String city = data.get("city");
		
		Map<String, String> details = excelutils.getExcelData("Employee", "AddUser");
		String userun=details.get("Username");
		String userpw=details.get("Password");
		String emp=details.get("SelectEmp");
		excelutils.closeExcel();
	
		CommonPage cp=new CommonPage(driver);
		cp.CommonAction(TabNames.EMPLOYEE);
		
		String actEmpURL=driver.getCurrentUrl();
		String expEmpURL="http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/employee.php";
		assertEquals(actEmpURL, expEmpURL, "Expected URL is not been executed");
		
		EmployeePage ep=new EmployeePage(driver);
		ep.createEmployeeButton();
		waitUtility.explicitVisibilityOfElementLocated(driver, By.xpath("(//h5[@id='exampleModalLabel'])[last()-2]"));
		String actText=driver.findElement(By.xpath("(//h5[@id='exampleModalLabel'])[last()-2]")).getText();
		String expText="Add Employee";
		assertEquals(actText, expText, "Expected text is not been displayed");
		
		ep.addEmployeeDetails(select,gender,job,province,city,fn,ln,email,phn, hire);

		driver.findElement(By.xpath("//div[@id='employeeModal']//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//a[@href='user.php']")).click();
		
		String actAccURL=driver.getCurrentUrl();
		String expAccURL="http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/user.php";
		assertEquals(actAccURL, expAccURL, "Expected URL is not been executed");
		
		driver.findElement(By.xpath("(//a[@href='#'])[last()]")).click();
		waitUtility.explicitVisibilityOfElementLocated(driver, By.name("empid"));
		String actUserText=driver.findElement(By.xpath("(//h5[@id='exampleModalLabel'])[last()]")).getText();
		String expUserText="Add User Account";
		assertEquals(actUserText, expUserText, "Expected text is not been displayed");
		
		AccountsPage ap=new AccountsPage(driver);
		ap.addingCustomer(select, emp,userun,userpw);
	}
}
