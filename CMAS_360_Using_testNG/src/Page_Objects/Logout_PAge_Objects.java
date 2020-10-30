package Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout_PAge_Objects
{

	@FindBy(xpath="//*[@id='topNavLogo']/img")
	public static WebElement Logout_Image;
	
	@FindBy(xpath="/html/body/div[3]/div/div/header/div[4]/div/div/a[3]/span")
	public static WebElement Logout;
	
	
	
}
