package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	public WebDriver driver	;
	@Test
		public void testFour() throws InterruptedException, IOException
		{
		System.out.println("Karan updated with this ###");
			System.out.println("test FOUR---");
			 driver= initializeDriver();
			driver.get("https://tutorialsninja.com/demo/");
			
			Thread.sleep(2000);
			driver.close();
		}
}
