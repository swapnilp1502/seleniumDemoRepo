package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	@Test(dataProvider="getLoginData")
	public void login(String email, String pass, String expectedResult) throws IOException, InterruptedException
	{
		
		LandingPage landingpage =new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		landingpage.loginOption().click();
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.emailAddressField().sendKeys(email);
		loginpage.passwordField().sendKeys(pass);
		loginpage.loginButton().click();
		
		//loginpage.loginFunctionality(email, pass);
	
		AccountPage accPage= new AccountPage(driver);
		
		String actualResult=null;
		try {
			if (accPage.editAccInfo().isDisplayed()) {
			actualResult="Successful";
			}
		}
		catch(Exception e) {
			actualResult="Failure";
		}
	    Assert.assertEquals(actualResult, expectedResult);
	}
	@BeforeMethod
	public void openApplication() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	@DataProvider
	public Object[][] getLoginData()
	{
	Object[][] data = {{"swapnil.parande7@gmail.com","root123","Successful"}, {"dummy@test","1#p","Failure"}};
	
	return data;
	}
}
