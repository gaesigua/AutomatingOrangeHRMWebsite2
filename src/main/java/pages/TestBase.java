package pages;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
//	1. Let's initialize our driver, so that it can be used inside the other classes here (static). //Here we are initializing the WebDriver; the "driver" is a reference variable or reference object
//     The "WebDriver" is an interface, and we know that we cannot create an object off of an interface;
//     INTERVIEW QUESTION: WHY THE WebDriver IS AN INTERFACE but ChromeDriver a class (DAY 16 SELENIUM MAIN BATCH, 30TH MINUTE)

	
	public static WebDriver driver;
	
//	2. Let's initialize the browser
	
	public static void initDriver() {
		
		driver = new ChromeDriver(); //ChromeDriver() is a class; it implements RemoteWebDriver, and the RemoteWebDriver implements an interface/reference variable called WebDriver
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}
	
	public void takeScreenshot(WebDriver driver) {
	

		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		
		String label = formatter.format(date);

// 3. Let's create an reference variable for the TakesScreenshot interface (it is implemented from the RemoteWebDriver class, that itself is extended from the ChromiumDriver class, that itself is extended from the ChromeDriver class
      //since TakesScreenshot is a reference variable (interface), we cannot just use the new keyword to create its object. instead we use typecasting. 
		
		TakesScreenshot ts = (TakesScreenshot)driver;

		File mySourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(mySourceFile, new File(System.getProperty("user.dir") + "/screenshots/" + label + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
