package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import POJO.Browser;
import POM.ZerodhaLoginPage;
import Utility.Parametrization;
import Utility.ScreenShot;

public class LoginPageTest {
	
	WebDriver driver ;
	
	@BeforeMethod
	public void browser() throws InterruptedException
	{
		driver = Browser.OpenBrowser();
	}
	
	@AfterMethod
	public void proof() throws IOException
	{
		ScreenShot.screenshot(driver);
	}
	
	@Test
	public void loginWithValidCredentialsTest() throws EncryptedDocumentException, IOException
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0,1);
		String password = Parametrization.getData(1,1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
	}
	
	@Test
	public void forgotPasswordLinkTest()
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgotPassword();
	}
	
	@Test
	public void signupLinkTest()
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnSignUp();
	}
	
	@Test
	public void clickOnLoginWithoutUserIDTest() 
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.enterPassword("123456789");
		zerodhaLoginPage.clickOnLogin();
		String text=zerodhaLoginPage.getUserIDError();
		System.out.println(text);
		String expectedText = "User ID should be minimum 6 characters.";
		Assert.assertEquals(text, expectedText);// hard Assertion
		zerodhaLoginPage.clickOnForgotPassword();
		zerodhaLoginPage.clickOnSignUp();
		
	}
	
	@Test
	public void clickOnLoginWithoutPasswordTest() throws InterruptedException 
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.enterUserId("Mahesh");
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(2000);
		String text=zerodhaLoginPage.getPasswordError();
		System.out.println(text);
		String expectedText ="Password should be minimum 69 characters.";
		Assert.assertEquals(text, expectedText);// hard Assertion
		zerodhaLoginPage.clickOnForgotPassword();
		zerodhaLoginPage.clickOnSignUp();
		
	}
	
	@Test
	public void clickOnLoginWithoutTest() throws EncryptedDocumentException, IOException
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnLogin();
		String text=zerodhaLoginPage.getUserIDError();
		System.out.println(text);
		String expectedText = "User ID should be minimum 9 characters.";
		SoftAssert softassert = new SoftAssert ();
		softassert.assertEquals(text, expectedText);// soft Assert
		
		//zerodhaLoginPage.clickOnLogin();
		//zerodhaLoginPage.clickOnSignUp();
		String userName = Parametrization.getData(0, 1);
		String  password = Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		softassert.assertAll();
		zerodhaLoginPage.clickOnLogin();
		//softassert.assertAll();

	}
}
