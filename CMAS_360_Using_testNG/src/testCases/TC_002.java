package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Objects.Login_Page_Objects;
import Page_Objects.Setup_Company_PageObjects;
import common_Functions.Base_class;

public class TC_002 extends Base_class
{

	@Test
	public void failedtest() throws InterruptedException
	{			
		test=extent.createTest("FailedTestCase");		
		PageFactory.initElements(driver, Setup_Company_PageObjects.class);
		
		Setup_Company_PageObjects.SetUp.click();
		Setup_Company_PageObjects.Company.click();
		Setup_Company_PageObjects.New.click();
		Setup_Company_PageObjects.AgencyName.sendKeys("Rnd soft");
		Setup_Company_PageObjects.ABN_No.sendKeys("2234");
		Setup_Company_PageObjects.Address.sendKeys("3,street");
		Setup_Company_PageObjects.Contact_Email.sendKeys("Rnd@gmail.com");
		Setup_Company_PageObjects.Enquiry_Email.sendKeys("Rnd@gmail.com");
		Setup_Company_PageObjects.Contact_Person.sendKeys("bhuvaneh");
		Setup_Company_PageObjects.Telephone.sendKeys("8956232214");
		
		
		
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
		
		Setup_Company_PageObjects.Ok.click();
		
		Thread.sleep(3000);
		
		String Actual_value=driver.findElement(By.xpath("//*[@id='tblcompany']/tbody/tr[1]/td[2]")).getText();
		
		
		 
		/*(OR)
		Using below Xpath
		//*[@id='tblcompany']/tbody/tr[*]/td[text()='bhuvanesh']
*/		
		System.out.println(Actual_value);
		String Expected_value="nd soft";
		
		Assert.assertEquals(Actual_value, Expected_value);
		
		driver.switchTo().defaultContent();
		
		
		
		
		
		
	/*	logout();*/
		
		
		
		
	}
	
}
