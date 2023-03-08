package crm.salesandinventory.objectrepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
@FindBy(name="user")
private WebElement username;

@FindBy(name="password")
private WebElement password;

@FindBy(name="btnlogin")
private WebElement loginButton;

public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void loginToApp(String user, String passw)
{
	username.sendKeys(user);
	password.sendKeys(passw);
	loginButton.click();
}
}
