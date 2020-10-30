package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Objects.Login_Page_Objects;
import Page_Objects.TC001_Page_Objects;
import common_Functions.Base_class;

public class TC_001 extends Base_class
{

	
	
	
	@Test
	public void login() throws InterruptedException
	
	{
		// Log in 
		test=extent.createTest("TC_001");
		PageFactory.initElements(driver, Login_Page_Objects.class);
		Login_Page_Objects.userrname.sendKeys(properties.getProperty("username"));
		Login_Page_Objects.password.sendKeys(properties.getProperty("password"));
		Login_Page_Objects.submitButton.click();
		
				
		PageFactory.initElements(driver, TC001_Page_Objects.class);
		
		TC001_Page_Objects.SetUp.click();
		TC001_Page_Objects.Company.click();
		TC001_Page_Objects.New.click();
		TC001_Page_Objects.AgencyName.sendKeys("bhuvanesh");
		TC001_Page_Objects.ABN_No.sendKeys("1997");
		TC001_Page_Objects.Address.sendKeys("3, tirupur");
		TC001_Page_Objects.Contact_Email.sendKeys("bhuvanesh@gmail.com");
		TC001_Page_Objects.Enquiry_Email.sendKeys("bhuvanesh@gmail.com");
		TC001_Page_Objects.Contact_Person.sendKeys("bhuvanesh");
		TC001_Page_Objects.Telephone.sendKeys("9865326598");
		
		
		
		try {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		
		TC001_Page_Objects.Save_Button.click();
		
		Thread.sleep(5000);
		
		TC001_Page_Objects.Ok.click();
		
		Thread.sleep(5000);
		
		String Actual_value=driver.findElement(By.xpath("//*[@id='tblcompany']/tbody/tr[1]/td[2]")).getText();
		
		Thread.sleep(5000);
		 
		/*(OR)
		Using below Xpath
		//*[@id='tblcompany']/tbody/tr[*]/td[text()='bhuvanesh']
*/		
		System.out.println(Actual_value);
		
		String Expected_value="bhuvanesh";
		
		Assert.assertEquals(Actual_value, Expected_value); 
		
		driver.switchTo().defaultContent();
		
		
		
		
		
	}
	
}
