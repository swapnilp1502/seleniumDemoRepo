package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-email")
	 WebElement emailAddressField;
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@value=\"Login\"]")
	WebElement loginButton;
	
	public WebElement emailAddressField() {
		return emailAddressField;
		
	}
	public WebElement passwordField() {
		return passwordField;		
		}
	public WebElement loginButton()
	{
		return loginButton;
	}
	
	public void loginFunctionality(String email1, String pass1)
	{
		emailAddressField.sendKeys(email1);
		passwordField.sendKeys(pass1);
		loginButton.click();
	}
}
