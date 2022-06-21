package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaHomePage1 {
	
	@FindBy(xpath="//input[@type='text']")private WebElement Textbox;
	@FindBy(xpath="(//span[text()='TATAMOTORS'])[1]")private WebElement Tatamotors;
	@FindBy(xpath="//button[@data-balloon='Buy']")private WebElement Buy;
	@FindBy(xpath="//button[@class='button-blue buy']")private WebElement HitBuy;
	@FindBy(xpath="//label[@class='su-switch-control']")private WebElement Toggle;
	@FindBy(xpath="(//label[@class='su-radio-label'])[1]")private WebElement BSE;
	@FindBy(xpath="//label[text()='Intraday ']")private WebElement Intraday;
	@FindBy(xpath="(//input[@type='number'])[1]")private WebElement Qty;
	@FindBy(xpath="//label[text()='Market']")private WebElement Market;
	@FindBy(xpath="//label[text()='Limit']")private WebElement Limit;
	@FindBy(xpath="//label[text()='SL']")private WebElement SL;
	@FindBy(xpath="//label[text()='SL-M']")private WebElement SL_M;
	@FindBy(xpath="//input[@label='Trigger price']")private WebElement TriggerPrice;
	@FindBy(xpath="//input[@label='Price']")private WebElement Price;
	@FindBy(xpath="//button[@type='submit']")private WebElement buy;
	@FindBy(xpath="//span[@class='nice-name']")private List<WebElement> WatchList;
	WebDriver driver ;
   public ZerodhaHomePage1(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   public void enterStockName(String Stockname)
   {
	   Textbox.sendKeys(Stockname);
   }
   public void clickOnBuy() 
   {
	   Buy.click();
   }
   public void clickOnStockName() 
   {
	   Tatamotors.click();
   }
   public void clickOnToggle() 
   {
	   Toggle.click();
   }
   public void clickOnBSE() 
   {
	   BSE.click();
   }
   public void clickOnIntraday() 
   {
	   Intraday.click();
   }
   public void clickOnQty() 
   {
	   Qty.clear();
	   Qty.sendKeys("2");
   }
   public void clickOnMarket() 
   {
	   Market.click();
   }
   public void clickOnLimit()
   {
	   Limit.click();
   }
   public void clickOnSL()
   {
	   SL.click();
   }
   public void enterTriggerPrice() throws InterruptedException
   {
	   TriggerPrice.clear();
	   TriggerPrice.clear();
	   Thread.sleep(2000);
	   TriggerPrice.sendKeys("404");
   }
   public void enterBuyPrice() throws InterruptedException
   {
	   Price.clear();
	   Thread.sleep(1000);
	   Price.sendKeys("408");
   }
   public void clickOnbuy() 
   {
	   buy.click();
   }
   public void act(WebDriver driver)
   {
	   Actions action = new Actions(driver);
	   action.moveToElement(Tatamotors) ;                
	   action.perform();
   }
   public void getStock(String a,WebDriver driver) throws InterruptedException
   {
	   int AllStocksInWatchlist = WatchList.size();
	   System.out.println(AllStocksInWatchlist);
	   for(int i = 0;i<AllStocksInWatchlist;i++)
	   {
		  WebElement FindStock = WatchList.get(i);
		  String CurrentStock = FindStock.getText();
		  System.out.println(CurrentStock);
		  if(CurrentStock.equals(a))
		  {
			  Actions action = new Actions(driver);
			   action.moveToElement(FindStock) ;                
			   action.perform();
			   Thread.sleep(1000);
			   HitBuy.click();
		  }
		  else
		  {
			  System.out.println("Please Add This Stock In Watch List");
		  }
	   }
   }

}

