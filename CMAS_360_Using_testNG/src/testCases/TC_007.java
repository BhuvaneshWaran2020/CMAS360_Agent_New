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

public class TC_007 extends Base_class
{

	@Test
	public void emptyValidationToCancel() throws InterruptedException
	{
		test=extent.createTest("emptyValidationToCancel");
		PageFactory.initElements(driver, Setup_Company_PageObjects.class);

		Setup_Company_PageObjects.SetUp.click();
		Setup_Company_PageObjects.Company.click();
		Setup_Company_PageObjects.New.click();
		Setup_Company_PageObjects.AgencyName.sendKeys("");
		Setup_Company_PageObjects.ABN_No.sendKeys("");
		Setup_Company_PageObjects.Address.sendKeys("");
		Setup_Company_PageObjects.Contact_Email.sendKeys("");
		Setup_Company_PageObjects.Enquiry_Email.sendKeys("");
		Setup_Company_PageObjects.Contact_Person.sendKeys("");
		Setup_Company_PageObjects.Telephone.sendKeys("");



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

		
		
		
		

		









		driver.switchTo().defaultContent();
		
	}
}
