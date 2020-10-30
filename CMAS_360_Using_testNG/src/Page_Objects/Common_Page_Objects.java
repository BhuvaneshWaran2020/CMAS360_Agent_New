package Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Common_Page_Objects 

{

	@FindBy(xpath="//*[@id='js-nav-menu']/li[2]/a/span")
	public static WebElement SetUp;
	
	@FindBy(xpath="//*[@id='js-nav-menu']/li[2]/ul/li[1]/a/span")
	public static WebElement Company;
	
	@FindBy(xpath="//*[@id='js-nav-menu']/li[2]/ul/li[3]/a/span")
	public static WebElement Admin;
	
	@FindBy(xpath="//*[@id='js-nav-menu']/li[2]/ul/li[4]/a/span")
	public static WebElement Subscription_Plans;
	
	@FindBy(xpath="//*[@id='js-nav-menu']/li[2]/ul/li[5]/a/span")
	public static WebElement User_Subscription;
	
	
	
	
}
