package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	public static void screenshot(WebDriver driver, String name) throws IOException
	{
	    String DT = ScreenShot.date();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Automation\\Test ScreenShots\\"+name+ DT+".jpg");
		FileHandler.copy(source, destination);
		
	}
	
	static int a = 1 ;
	public static void screenshot(WebDriver driver) throws IOException 
	{
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Automation\\"+a+".png");
		FileHandler.copy(source, destination);
		a++ ;
	}
	
	public static String date()
	{
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		String DT = dtf.format(ldt);
		return DT;
	}
}
