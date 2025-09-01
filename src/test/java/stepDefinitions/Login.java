package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Login extends Base{
	WebDriver driver;
	LandingPage landingpage;
	LoginPage loginpage;
	@Given("user is on login page")
	public void user_is_on_login_page() throws IOException, InterruptedException {
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		landingpage =new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		landingpage.loginOption().click();
		Thread.sleep(2000);
	}

	@When("user enter valid username & password")
	public void user_enter_valid_username_password(String email, String pass) {
		 /*loginpage= new LoginPage(driver);
		 loginpage.emailAddressField().sendKeys(email);
		 loginpage.passwordField().sendKeys(pass); */
		 
		 loginpage.loginFunctionality(email, pass);
	}

	@Then("user click on login button")
	public void user_click_on_login_button() {
		loginpage.loginButton().click();
	}
	@After
	public void closeBrowser() {
		driver.close();
	}
}
