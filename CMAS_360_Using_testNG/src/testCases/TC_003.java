package testCases;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Objects.TC001_Page_Objects;
import common_Functions.Base_class;

public class TC_003 extends Base_class

{



	@Test
	public void ValidCancel() throws InterruptedException
	{
		test=extent.createTest("GivenValidInputsToCancel");		
		PageFactory.initElements(driver, TC001_Page_Objects.class);

		TC001_Page_Objects.SetUp.click();
		TC001_Page_Objects.Company.click();
		TC001_Page_Objects.New.click();
		TC001_Page_Objects.AgencyName.sendKeys("Rndsoft");
		TC001_Page_Objects.ABN_No.sendKeys("2235");
		TC001_Page_Objects.Address.sendKeys("3, tirupur");
		TC001_Page_Objects.Contact_Email.sendKeys("bhuvaneh@gmail.com");
		TC001_Page_Objects.Enquiry_Email.sendKeys("bhuvaneh@gmail.com");
		TC001_Page_Objects.Contact_Person.sendKeys("bhuvaneh");
		TC001_Page_Objects.Telephone.sendKeys("9865328598");



		try {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {

			e.printStackTrace();
		}

		Thread.sleep(5000);

		TC001_Page_Objects.Cancel_Button.click();
		Thread.sleep(5000);

		String actual_value=driver.findElement(By.xpath("//*[@id='tblcompany']/tbody/tr[*]/td[text()='bhuvanesh']")).getText();
		
		
		String expected_value="Rndsoft";
		
		if(actual_value==expected_value)
		{
			System.out.println("testcase failed");
			Assert.assertTrue(false);
		}else if(actual_value!=expected_value)
		{
			System.out.println("testcase passed");
			Assert.assertTrue(true);
		}

		















		driver.switchTo().defaultContent();

	}
}