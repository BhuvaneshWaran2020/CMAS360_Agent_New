package Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TC001_Page_Objects
{

	
	@FindBy(xpath="//*[@id='js-nav-menu']/li[2]/a/span")
	public static WebElement SetUp;
	
	@FindBy(xpath="//*[@id='js-nav-menu']/li[2]/ul/li[1]/a/span")
	public static WebElement Company;
	
	@FindBy(xpath="//*[@id='newBtn']/span")
	public static WebElement New;
	
	@FindBy(id="agencyName")
	public static WebElement AgencyName;
	
	@FindBy(id="ABN_RegNo")
	public static WebElement ABN_No;
	
	@FindBy(id="address")
	public static WebElement Address;
	
	@FindBy(id="contactEmail")
	public static WebElement Contact_Email;
	
	@FindBy(id="enquiryEmail")
	public static WebElement Enquiry_Email;
	
	@FindBy(id="tradingName")
	public static WebElement TradingName;
	
	@FindBy(id="contactPerson")
	public static WebElement Contact_Person;
	
	@FindBy(id="countryCode")
	public static WebElement Country_Code;
	
	@FindBy(id="areaCode")
	public static WebElement Area_Code;
	
	@FindBy(id="telephone")
	public static WebElement Telephone;
	
	@FindBy(id="agencyWebsite")
	public static WebElement Agency_Website;
	
	@FindBy(id="otherEmail")
	public static WebElement Other_Email;
	
	/*@FindBy(xpath="//*[@id='panel-1']/div/div[2]/div/div/div/div/button[2]")
	public static WebElement Save_Button;*/
	
	/*(OR) --> Using Own Xpath
	
	//*[@id='company_form']/following::div[4]/button[2]
*/	
	
	/*@FindBy(xpath="//*[@id='company_form']/following::div[4]/button[2]")
	public static WebElement Save_Button;*/
	
	@FindBy(xpath="//button[@class='btn save-btn box-shadow saveBtn waves-effect waves-themed']")
	public static WebElement Save_Button;
	
	
	
	@FindBy(xpath="//button[@class='btn btn-dark ml-auto waves-effect waves-themed box-shadow closeForm']")
	public static WebElement Cancel_Button;
	
	@FindBy(xpath="//*[@id='myBtn']/i")
	public static WebElement Above_Button;
	
	
	@FindBy(xpath="/html/body/div[7]/div[7]/div/button")
	public static WebElement Ok;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
