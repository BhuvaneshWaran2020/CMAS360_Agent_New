package testCases;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Objects.Setup_Company_PageObjects;
import common_Functions.Base_class;

public class TC_003 extends Base_class

{



	@Test
	public void ValidCancel() throws InterruptedException
	{
		test=extent.createTest("GivenValidInputsToCancel");		
		PageFactory.initElements(driver, Setup_Company_PageObjects.class);

		Setup_Company_PageObjects.SetUp.click();
		Setup_Company_PageObjects.Company.click();
		Setup_Company_PageObjects.New.click();
		Setup_Company_PageObjects.AgencyName.sendKeys("Rndsoft");
		Setup_Company_PageObjects.ABN_No.sendKeys("2235");
		Setup_Company_PageObjects.Address.sendKeys("3, tirupur");
		Setup_Company_PageObjects.Contact_Email.sendKeys("bhuvaneh@gmail.com");
		Setup_Company_PageObjects.Enquiry_Email.sendKeys("bhuvaneh@gmail.com");
		Setup_Company_PageObjects.Contact_Person.sendKeys("bhuvaneh");
		Setup_Company_PageObjects.Telephone.sendKeys("9865328598");



		try {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {

			e.printStackTrace();
		}

		Thread.sleep(5000);

		Setup_Company_PageObjects.Cancel_Button.click();
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