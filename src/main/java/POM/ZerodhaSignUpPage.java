package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaSignUpPage {
	
	@FindBy(xpath = "//input[@id='user_mobile']")private WebElement mobileNumber;
	@FindBy(xpath = "//button[@id='open_account_proceed_form']")private WebElement Continue;
	@FindBy(xpath = "//a[text()='Want to open an NRI account?']")private WebElement NRIAccount;
	
	public ZerodhaSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterMoblieNumber(String number)
	{
		mobileNumber.sendKeys(number);
	}
	
	public void clickOnContinue()
	{
		Continue.click();
	}
	
	public void clickOnOpenAnNRIAccount()
	{
		NRIAccount.click();
	}

}
