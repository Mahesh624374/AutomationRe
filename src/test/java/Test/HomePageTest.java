package Test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POJO.Browser;
import POM.ZerodhaHomePage;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parametrization;

public class HomePageTest {
	
WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
		driver = Browser.OpenBrowser();
	}
	@Test
	public void loginToZerodhaWithPinTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0, 1);
		String  password = Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(2000);
		
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);
		String pin =  Parametrization.getData(2, 1);
		System.out.println(pin);
		zerodhaPinPage.enterPin(pin);
		zerodhaPinPage.clickOnContinue();
		Thread.sleep(2000);
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		String Stockname = "TATAMOTORS";
		zerodhaHomePage.enterStockName(Stockname);
		Thread.sleep(2000);
	//	zerodhaHomePage.clickOnStockName();
	//	Actions action = new Actions (driver);
	//	WebElement Stock = driver.findElement(By.xpath("(//span[text()='TATAMOTORS'])[1]"));
	//	action.moveToElement(Stock) ;                
	//	action.perform();
		zerodhaHomePage.act(driver);
		Thread.sleep(2000);
		zerodhaHomePage.clickOnBuy();
		Thread.sleep(2000);
		zerodhaHomePage.clickOnToggle();
		Thread.sleep(2000);
		zerodhaHomePage.clickOnToggle();
		Thread.sleep(2000);
		zerodhaHomePage.clickOnBSE();
		zerodhaHomePage.clickOnIntraday();
		zerodhaHomePage.clickOnQty();
	//	zerodhaHomePage.clickOnMarket();
	//	zerodhaHomePage.clickOnLimit();
		zerodhaHomePage.clickOnSL();
		Thread.sleep(2000);
		zerodhaHomePage.enterBuyPrice();
		Thread.sleep(2000);
		zerodhaHomePage.enterTriggerPrice();
		Thread.sleep(2000);
		zerodhaHomePage.clickOnbuy();
}

}
