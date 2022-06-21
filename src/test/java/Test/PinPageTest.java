package Test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import POJO.Browser;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parametrization;
import Utility.Report;

@Listeners(TestListeners.class)

public class PinPageTest extends BaseTest {
	
	ExtentReports reports ;
	ExtentTest test ;
	
	//WebDriver driver ;
	
	@BeforeTest
	public void extentReports()
	{
		reports = Report.createReport();
	}
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = Browser.OpenBrowser();
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName());
		}
		else
		{
			test.log(Status.SKIP,result.getName());
		}
	}
	
	@AfterTest
	public void flushResult()
	{
		reports.flush();
	}
	
	@Test
	public void loginToZerodhaWithPinTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		test = reports.createTest("loginToZerodhaWithPinTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0,1);
		String password = Parametrization.getData(1,1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		
		Thread.sleep(2000);
		
		ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver);
		String pin = Parametrization.getData(2,1);
		zerodhaPinPage.enterPin(pin);
		zerodhaPinPage.clickOnContinue();
		
	}
	
	@Test
	public void clickOnForgetPasswordLinkTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		test = reports.createTest("clickOnForgetPasswordLinkTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0,1);
		String password = Parametrization.getData(1,1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		
		Thread.sleep(2000);
		
		ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver);
		zerodhaPinPage.clickOnForgot();
	}
	
	@Test
	public void clickOnSignUpLinkTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		test = reports.createTest("clickOnSignUpLinkTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0,1);
		String password = Parametrization.getData(1,1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		
		Thread.sleep(2000);
		
		ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver);
		zerodhaPinPage.clickOnSignUp();
	}
}
