package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaForgotIDAndPasswordPage {
	
	@FindBy(xpath = "(//label[@class='su-radio-label'])[1]")private WebElement rememberUserId;
	@FindBy(xpath = "(//label[@class='su-radio-label'])[2]")private WebElement forgotUserId;
	@FindBy(xpath = "//input[@placeholder='User ID']")private WebElement userId;
	@FindBy(xpath = "//input[@placeholder='PAN']")private WebElement PAN;
	@FindBy(xpath = "(//label[@class='su-radio-label'])[3]")private WebElement eMail;
	@FindBy(xpath = "(//label[@class='su-radio-label'])[4]")private WebElement SMS;
	@FindBy(xpath = "//input[@placeholder='E-mail (as on account)']")private WebElement emailAccount;
	@FindBy(xpath = "//input[@placeholder='Mobile number (as on account)']")private WebElement mobileNumber;
	@FindBy(xpath = "//input[@placeholder='Captcha']")private WebElement captcha;
	@FindBy(xpath = "//button[@class='button-orange wide']")private WebElement reset;
	@FindBy(xpath = "//a[@class='text-xsmall text-light reset-account-button']")private WebElement backToLogin;
	@FindBy(xpath = "//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signUp;

	public ZerodhaForgotIDAndPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnIRememberMyUserId()
	{
		rememberUserId.click();
	}
	public void ClickOnIForgotMyUserId()
	{
		forgotUserId.click();
	}
	public void enterUserId(String userid)
	{
	     userId.sendKeys(userid);
	}
	public void enterPan(String pannumber)
	{
		PAN.sendKeys(pannumber);
	}
	public void clickOnEmailRadioButton()
	{
		eMail.click();
	}
	public void clickOnSmsRadioButton()
	{
		SMS.click();
	}
	public void enterMobileNumber(String number)
	{
		mobileNumber.sendKeys(number);
	}
	public void enterEmail(String emailaddress)
	{
		emailAccount.sendKeys(emailaddress);
	}
	public void captcha(String Captcha)
	{
		captcha.sendKeys(Captcha);
	}
	public void clickOnResetButton()
	{
		reset.click();
	}
	public void clickOnBackToLogin()
	{
		backToLogin.click();
	}

	public void clickOnSignUp()
	{
		signUp.click();
	}
}
