package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaForgotIDAndPasswordPage;
import POM.ZerodhaLoginPage;
import Utility.Parametrization;

public class ForgotIDAndPasswordPageTest {
	
	WebDriver driver ;
	
	@BeforeMethod
	public void openBroeser() throws InterruptedException
	{
		driver = Browser.OpenBrowser();
	}
	
	@Test
	public void clickOnIRememberMyUserIDRadioButtonTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgotPassword();
		
		Thread.sleep(2000);
		
		ZerodhaForgotIDAndPasswordPage zerodhaForgotIDAndPasswordPage = new ZerodhaForgotIDAndPasswordPage(driver);
		zerodhaForgotIDAndPasswordPage.clickOnIRememberMyUserId();
		Thread.sleep(2000);
		String userId = Parametrization.getData(3,1);
		zerodhaForgotIDAndPasswordPage.enterUserId(userId);
		Thread.sleep(2000);
		String pan = Parametrization.getData(4,1);
		zerodhaForgotIDAndPasswordPage.enterPan(pan);
		Thread.sleep(2000);
		zerodhaForgotIDAndPasswordPage.clickOnEmailRadioButton();
		String email = Parametrization.getData(5,1);
		zerodhaForgotIDAndPasswordPage.enterEmail(email);
		Thread.sleep(2000);
		zerodhaForgotIDAndPasswordPage.clickOnResetButton();
		Thread.sleep(2000);
		zerodhaForgotIDAndPasswordPage.clickOnBackToLogin();
	}
	
	@Test
	public void clickOnIForgotMyUserIdRadioButtonTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgotPassword();
		
		Thread.sleep(2000);
		
		ZerodhaForgotIDAndPasswordPage zerodhaForgotIDAndPasswordPage = new ZerodhaForgotIDAndPasswordPage(driver);
		zerodhaForgotIDAndPasswordPage.ClickOnIForgotMyUserId();
		String pan = Parametrization.getData(4,1);
		zerodhaForgotIDAndPasswordPage.enterPan(pan);
		Thread.sleep(2000);
		zerodhaForgotIDAndPasswordPage.clickOnSmsRadioButton();
		String number = Parametrization.getData(6,1);
		zerodhaForgotIDAndPasswordPage.enterMobileNumber(number);
		Thread.sleep(2000);
		zerodhaForgotIDAndPasswordPage.clickOnResetButton();
		Thread.sleep(2000);
		zerodhaForgotIDAndPasswordPage.clickOnBackToLogin();
		
	}
	
	@Test
	public void fakeLogin()
	{
		System.out.println("Some one trying to login using fake credentials");
	}
	
}
