package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaLoginPage {
	
	@FindBy(xpath = "//input[@id='userid']")private WebElement userId;
	@FindBy(xpath = "//input[@id='password']")private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")private WebElement login;
	@FindBy(xpath = "//a[text()='Forgot user ID or password?']")private WebElement forgot;
	@FindBy(xpath = "//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signUp;
	@FindBy(xpath = "(//span[@class='su-message'])[1]") private WebElement userIDError;
	@FindBy(xpath = "//span[text()='Password should be minimum 6 characters.']") private WebElement passwordError;

	
	public ZerodhaLoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterUserId(String user)
	{
		userId.sendKeys(user);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void clickOnForgotPassword()
	{
		forgot.click();
	}
	
	public void clickOnSignUp()
	{
		signUp.click();
	}
	
	public String getUserIDError()
	{
		String a = userIDError.getText();
		return a;
	}
	
	public String getPasswordError()
	{
		String a = passwordError.getText();
		return a;
	}
	
}
