package Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Objects
{

	@FindBy(id="email")
	public static WebElement userrname;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(id="btnLogin")
	public static WebElement submitButton;
}
