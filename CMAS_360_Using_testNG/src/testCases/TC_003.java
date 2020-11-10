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
		//Create 1 test in extent Report
		test=extent.createTest("GivenValidInputsToCancel");	

		// Using pagefactory 
		PageFactory.initElements(driver, Setup_Company_PageObjects.class);

		//click setup link in cmas application
		Setup_Company_PageObjects.SetUp.click();

		//click Company link in cmas application
		Setup_Company_PageObjects.Company.click();

		//click New link in cmas application
		Setup_Company_PageObjects.New.click();

		//Send value to AgencyName in cmas application
		Setup_Company_PageObjects.AgencyName.sendKeys("Rndsft");

		//Send value to Abn.no in cmas application
		Setup_Company_PageObjects.ABN_No.sendKeys("2235");

		//Send value to Address in cmas application
		Setup_Company_PageObjects.Address.sendKeys("3, tirupur");

		//Send value to contact Email in cmas application
		Setup_Company_PageObjects.Contact_Email.sendKeys("bhuvaneh@gmail.com");

		//Send value to Enquiry_Email in cmas application
		Setup_Company_PageObjects.Enquiry_Email.sendKeys("bhuvaneh@gmail.com");

		//Send value to Contact_Person in cmas application
		Setup_Company_PageObjects.Contact_Person.sendKeys("bhuvaneh");

		//Send value to Telephone in cmas application
		Setup_Company_PageObjects.Telephone.sendKeys("9865328598");


		//Using Robot class to Down page
		try {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {

			e.printStackTrace();
		}

		//3 min slow
		Thread.sleep(5000);

		//Click Cancel button
		Setup_Company_PageObjects.Cancel_Button.click();

		//3 min slow
		Thread.sleep(5000);




		// move to default browser
		driver.switchTo().defaultContent();

	}
}