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
import Page_Objects.Setup_Company_PageObjects;
import common_Functions.Base_class;

public class TC_001 extends Base_class
{




	@Test
	public void login() throws InterruptedException

	{

		//Create 1 test in extent Report
		test=extent.createTest("ValidInputsToCreateNewCompany");

		// Using pagefactory 
		PageFactory.initElements(driver, Login_Page_Objects.class);

		// Log in 
		Login_Page_Objects.userrname.sendKeys(properties.getProperty("username"));
		Login_Page_Objects.password.sendKeys(properties.getProperty("password"));
		Login_Page_Objects.submitButton.click();

		// Using pagefactory 
		PageFactory.initElements(driver, Setup_Company_PageObjects.class);


		//click setup link in cmas application
		Setup_Company_PageObjects.SetUp.click();

		//click Company link in cmas application
		Setup_Company_PageObjects.Company.click();

		//click New link in cmas application
		Setup_Company_PageObjects.New.click();

		//Send value to AgencyName in cmas application
		Setup_Company_PageObjects.AgencyName.sendKeys("Rnd soft");

		//Send value to Abn.no in cmas application
		Setup_Company_PageObjects.ABN_No.sendKeys("2233");

		//Send value to Address in cmas application
		Setup_Company_PageObjects.Address.sendKeys(" 3,street");

		//Send value to contact Email in cmas application
		Setup_Company_PageObjects.Contact_Email.sendKeys("Rnd@gmail.com");

		//Send value to Enquiry_Email in cmas application
		Setup_Company_PageObjects.Enquiry_Email.sendKeys("Rnd@gmail.com");

		//Send value to Contact_Person in cmas application
		Setup_Company_PageObjects.Contact_Person.sendKeys("bhuvanesh");

		//Send value to Telephone in cmas application
		Setup_Company_PageObjects.Telephone.sendKeys("8956232214");


		//Using Robot class to Down page
		try {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {

			e.printStackTrace();
		}


		//3 min slow
		Thread.sleep(3000);

		//click save button
		Setup_Company_PageObjects.Save_Button.click();

		//3 min slow
		Thread.sleep(3000);

		//click ok button
		Setup_Company_PageObjects.Ok.click();

		//3 min slow
		Thread.sleep(3000);

		//Return actual_value
		String Actual_value=driver.findElement(By.xpath("//*[@id='tblcompany']/tbody/tr[1]/td[2]")).getText();

		//Return Expected_value
		String Expected_value="Rnd soft";

		//Verify using testng assersion
		Assert.assertEquals(Actual_value, Expected_value); 

		// move to default browser
		driver.switchTo().defaultContent();





	}

}
