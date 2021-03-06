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

public class TC_005 extends Base_class
{

	@Test
	public void EmptyValidationToSave() throws InterruptedException
	{
		test=extent.createTest("EmptyValidationToSave");
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

		Thread.sleep(3000);

		Setup_Company_PageObjects.Save_Button.click();

		Thread.sleep(3000);

		

		
		
		boolean t=driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")).isDisplayed();

		if(t=true)
		{
			Assert.assertTrue(true);
			System.out.println("passed");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("failed");
		}

		 

		driver.switchTo().defaultContent();
	}

}



