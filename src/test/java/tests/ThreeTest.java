package tests;


import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import resources.Base;
import org.testng.annotations.*;

public class ThreeTest extends Base{
	public WebDriver driver;
	@Test
		public void testThree() throws Exception
		{
			System.out.println("TestThree");
			 driver= initializeDriver();
			driver.get("https://tutorialsninja.com/demo/");
			
			Thread.sleep(2000);
			
			Assert.assertTrue(false);
		}
		@AfterMethod
		public void closeBrowser()
		{
			driver.close();
		}
}
