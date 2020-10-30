package screenShot_Source;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility
{


	public static void captureScreenshot(WebDriver driver,String screenshotName)
	{
		try {
			String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot screenshot=(TakesScreenshot) driver;

			File source=screenshot.getScreenshotAs(OutputType.FILE);

			FileHandler.copy(source, new File("./screnn/"+screenshotName+ dateName +".png"));

			System.out.println("taken screenshot");
		}
		catch (Exception e) 
		{
			System.out.println("exception while taking a screenshot"+e.getMessage());

		} 

	}
	
	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException{

		//	Date :

		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		
		// taking screenshot 

		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);

		String destination=System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";

		System.out.println(destination);
		File finaldestination=new File(destination);
		/*FileHandler.copy(source, finaldestination);*/
		FileUtils.copyFile(source, finaldestination);
		return destination;


		
	}	
	
	public static String takeScreenshot(WebDriver driver,String methodName)
	{
		String fileName=getScreenshotName(methodName);
		String directory=System.getProperty("user.dir")+"/screenshots/";
		new File(directory).mkdirs();
		String path=directory+fileName;
		
		try{
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("************************************************");
			System.out.println("Screenshot stored at:" + path);
			System.out.println("************************************************");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return path;
	}
	
	public static String getScreenshotName(String methodName){
		Date d=new Date();
		String fileName=methodName + "_" + d.toString().replace(":", "_").replace(":", "_")+".png";
		return fileName;
	}
	
	


	
}
