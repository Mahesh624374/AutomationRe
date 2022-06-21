package Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POJO.Browser;
import POM.ZerodhaLoginPage;
import POM.ZerodhaSignUpPage;
import Utility.Parametrization;

public class SignUpPageTest {
	
	WebDriver driver ;
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = Browser.OpenBrowser();
	}
	
	@Test
	public void continueWithMobileNumberTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnSignUp();
		
		Thread.sleep(2000);
		
		Set<String> addresses = driver.getWindowHandles();
		System.out.println(addresses);
		Iterator<String> a = addresses.iterator();
		
		Thread.sleep(2000);
	
		while(a.hasNext())
		{
			String address = a.next();
			driver.switchTo().window(address);
			
			Thread.sleep(2000);

			String currentTitle = driver.getTitle();
			System.out.println(currentTitle);

			if(currentTitle.equals("Signup and open a Zerodha trading and demat account online and start investing – Zerodha"))
			{
				ZerodhaSignUpPage zerodhaSignUpPage = new ZerodhaSignUpPage(driver);
				String number = Parametrization.getData(6,1);
				zerodhaSignUpPage.enterMoblieNumber(number);
				
				Thread.sleep(2000);

				System.out.println(number);
				zerodhaSignUpPage.clickOnContinue();
			}
		}
		
		
	}
	
	@Test
	public void clickOnWantToOpenNRIAccountLinkTest() throws InterruptedException
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnSignUp();
		
		Set<String> a = driver.getWindowHandles();
		Iterator<String> b = a.iterator();
		
		while(b.hasNext())
		{
			String c = b.next();
			driver.switchTo().window(c);
			String currentTitle = driver.getTitle();
			
			if(currentTitle.equals("Signup and open a Zerodha trading and demat account online and start investing – Zerodha"))
			{
				ZerodhaSignUpPage zerodhaSignUpPage = new ZerodhaSignUpPage(driver);
				zerodhaSignUpPage.clickOnOpenAnNRIAccount();
			}
		}
		
	}

}
