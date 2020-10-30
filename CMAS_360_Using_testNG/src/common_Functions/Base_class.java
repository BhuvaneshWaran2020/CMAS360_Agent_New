package common_Functions;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import screenShot_Source.Utility;







public class Base_class




{

	public static WebDriver driver=null;
	public static Properties properties=null;

	//builds a new report using the html template 
	public static   ExtentHtmlReporter htmlReporter;

	public static  ExtentReports extent;

	//helps to generate the logs in test report.
	public static   ExtentTest test;
	


	public static Properties loadPropertyFile() throws IOException
	{

		FileInputStream fileInputStream= new FileInputStream("config.properties");
		properties=new Properties();
		properties.load(fileInputStream);
		return properties;

	}


	@BeforeSuite
	public static void launchBrowser() throws IOException
	{

		loadPropertyFile();


		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		String driverlocation=properties.getProperty("driverlocation");
		
		htmlReporter=new ExtentHtmlReporter("./reports/extent.html");

		htmlReporter.config().setDocumentTitle("Extent Report Demso");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent=new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("TesterName", "Bhuvaneshwaran Mani");
		extent.setSystemInfo("Browser", "Chrome");
		


		if(browser.equalsIgnoreCase("chrome"))
		{
			// set the Property

			System.setProperty("webdriver.chrome.driver", driverlocation);

			//Declare Chromedriver

			driver=new ChromeDriver();

		}
		else if(browser.equalsIgnoreCase("firefox"))
		{

			// set the Property

			System.setProperty("webdriver.gecko.driver", driverlocation);

			//Declare FirefoxDriver

			driver=new FirefoxDriver();
		}


		// Maximize the window
		driver.manage().window().maximize();

		//Page timeout

		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		// Webdriver wait 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		// navigate to the Url
		driver.get(url);
		
		




	}

	
	


	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		String methodName=result.getMethod().getMethodName();
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String exceptionMessage= Arrays.toString(result.getThrowable().getStackTrace());
			test.fail("<details><summary><b><font color=red>Exception Occured,click to see details :"
					+"</font></b></summary>" +exceptionMessage.replaceAll(",", "<br>")+"</details> \n");
			
			Utility.captureScreenshot(driver, result.getName());
			String screenshotpath=Utility.getScreenshot(driver, result.getName());
		
			String path=Utility.takeScreenshot(driver, result.getMethod().getMethodName());

			try{

				test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
						MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}
			catch(IOException e){
				test.fail("Test Failed,cannot attach screenshot");


			}
			String logText="<b>Test Method "+ methodName +"Failed</b>";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
			test.log(Status.FAIL, m);
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String logText="<b>Test Method "+ methodName +"Successful</b>";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.log(Status.PASS, m);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			String logText="<b>Test Method "+ methodName +"Skipped</b>";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			test.log(Status.SKIP, m);
		}
		

		
	}
	
	
	/*public void logout()
	{

		PageFactory.initElements(driver, Logout_PAge_Objects.class);

		Logout_PAge_Objects.Logout_Image.click();
		Logout_PAge_Objects.Logout.click();
	}*/

	/*@AfterSuite
	public void logout()
	{
		driver.switchTo().defaultContent();
		PageFactory.initElements(driver, Logout_PAge_Objects.class);
 
		Logout_PAge_Objects.Logout_Image.click();
		Logout_PAge_Objects.Logout.click();



	}*/
	
	



	@AfterSuite
	public void close()
	{
		extent.flush();
	}


	


}
