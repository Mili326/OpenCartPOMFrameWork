package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage extends BasePage{

	
	private ElementUtil elementUtil;
	private By headerValue =By.linkText("Your Store");
	private By accountSectionHeaders=By.cssSelector("div#content h2");
/*	private By myAccounttext=By.xpath("//h2[text()='My Account']");
	private By myOrdersText=By.xpath("//h2[text()='My Orders']");
	private By myAffliateAccountText=By.xpath("//h2[text()='My Affiliate Account']");
	private By newsLetterText= By.xpath("//h2[text()='Newsletter']");
	*/
	private By editAccountLink=By.linkText("Edit Account");
	private By orderHistoryLink=By.linkText("Order History");
	private By transactionsLink=By.linkText("Transactions");
	private By searchText=By.cssSelector("div#search input[name='search']");
	private By searchButton=By.cssSelector("div#search button[type='button']");
	private By searchItemResult= By.cssSelector(".product-layout .product-thumb");
	private By productSearchResult=By.cssSelector(".product-thumb h4 a");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String getAccountsPageTitle()
	{
		return elementUtil.waitForTitleIs(Constants.Accounts_PAGE_TITLE, 10);
	}
	
	public String getHeaderValue()
	{
		if(elementUtil.doPresenceOfElementLocated(headerValue,10) != null);
		{
			return 	elementUtil.doGetText(headerValue);
		}
			//return null;
	}
	
	public int getAccountSectionCount()
	{
		
		return elementUtil.getElements(accountSectionHeaders).size();
		
	}
	
	public List<String> getAccountSectionsList()
	{	List<String> accountsList=new ArrayList<>();
		List<WebElement> accSectionList=elementUtil.getElements(accountSectionHeaders);
		for(WebElement e: accSectionList) {
			System.out.println(e.getText());
			accountsList.add(e.getText());
		}
		return accountsList;
	}
	
	public boolean doSearch(String productName)
	{
	
		elementUtil.doSendKeys(searchText, productName);
		
		elementUtil.doClick(searchButton);
		
		if(elementUtil.getElements(searchItemResult).size()>0 )
		{
			return true;
		}
		return false;
		
	}
	
	public ProductInfoPage getProductResults(String productName)
	{
		List<WebElement> productResultList = elementUtil.getElements(productSearchResult);
		System.out.println("Total number of Items displayed:" + productResultList.size() );
		for(WebElement e: productResultList)
		{
			if(e.getText().equals(productName))
			{   e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	
/*	public boolean myOrdersTextExists()
	{
		return driver.findElement(myOrdersText).isDisplayed();
	}
	public boolean myAffliateAccountTextExists()
	{
		return driver.findElement(myAffliateAccountText).isDisplayed();
	}
	
	public boolean newsLetterTextExists()
	{
		 return driver.findElement(newsLetterText).isDisplayed();
	}
	*/
	public boolean editAccountLinkExists()
	{
		return driver.findElement(editAccountLink).isDisplayed();
	}
	
	public boolean orderHistoryLinkExists()
	{
		return driver.findElement(orderHistoryLink).isDisplayed();
	}
	public boolean transactionsLinkExists()
	{
		return driver.findElement(transactionsLink).isDisplayed();
	}
	
}
