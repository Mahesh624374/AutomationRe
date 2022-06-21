package POJO;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	
	public static WebDriver OpenBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS); // Implicit Wait
		return driver;
		
	}
	
}
