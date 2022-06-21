package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaPinPage {
	
	@FindBy(xpath = "//input[@type='password']")private WebElement pin;
	@FindBy(xpath = "//button[@type='submit']")private WebElement submit;
	@FindBy(xpath = "//a[text()='Forgot 2FA?']")private WebElement forgot;
	@FindBy(xpath = "//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signUp;
	
	public ZerodhaPinPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterPin(String PinNumber)
	{
		pin.sendKeys(PinNumber);
	}
	
/*	
	public void enterPin(String PinNumber,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));//Explicit wait
		wait.until(ExpectedConditions.visibilityOf(pin));//will recheck the element in 500ms
		pin.sendKeys(PinNumber);
	}
		
	public void enterPin(String PinNumber,WebDriver driver) //Fluent wait
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(5000));//total wait time
		wait.pollingEvery(Duration.ofMillis(50));//polling time or recheking time
		wait.ignoring(Exception.class);// exception ignore
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(PinNumber);			
	}
*/	
	public void clickOnContinue()
	{
		submit.click();
	}
	
	public void clickOnForgot()
	{
		forgot.click();
	}
	
	public void clickOnSignUp()
	{
		signUp.click();
	}
}
