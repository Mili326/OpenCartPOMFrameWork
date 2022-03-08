package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	
	@BeforeClass
	public void verifyaccountsPageSetUp()
	{
		accountsPage =loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test
	public void verifyAccountsPageTitle()
	{
		String homePageTitle= accountsPage.getAccountsPageTitle();
		System.out.println("Accounts page title is :"+ homePageTitle );
		Assert.assertEquals(homePageTitle, Constants.Accounts_PAGE_TITLE);
	}
	
	@Test
	public void verifyHeaderValueTest()
	{
		String headerValue=accountsPage.getHeaderValue();
		System.out.println("Accounts Page header value is:"+ headerValue);
		Assert.assertEquals(headerValue, Constants.Accounts_PAGE_Header);
	}
	@Test
	public void verifyAccountSectionsCountTest()
	{
		Assert.assertTrue(accountsPage.getAccountSectionCount()==Constants.ACCOUNTS_SECTION_COUNT);
	}
	@Test
	public void verifyAccountSectionsListTest()
	{
		Assert.assertEquals(accountsPage.getAccountSectionsList(),Constants.getAccountSectionList());
	}
	
	@Test
	public void verifySearchTest()
	{
		Assert.assertTrue(accountsPage.doSearch("iMac"));
	}
	
/*	@Test
	public void myAccountTextExistsTest()
	{
		Assert.assertTrue(homePage.myAccountTextExists());
		
	}
	@Test
	public void verifyMyOrdersTextExistsTest()
	{
		Assert.assertTrue(homePage.myOrdersTextExists());
	}
	@Test
	public void verifyMyAffliateAccountTextExistsTest()
	{
		Assert.assertTrue(homePage.myAffliateAccountTextExists());
	}
	@Test
	public void verifyNewsLetterTextExists()
	{
		Assert.assertTrue(homePage.newsLetterTextExists());
	}

	@Test
	public void verifyEditAccountLinkExistsTest()
	{
		Assert.assertTrue(accountsPage.editAccountLinkExists());
	}
	
	
	@Test
	public void verifyOrderHistoryLinkExists()
	{
		Assert.assertTrue(accountsPage.myOrdersTextExists());
	}
	@Test
	public void verifyTransactionsLinkExists()
	{
		Assert.assertTrue(accountsPage.transactionsLinkExists());
	}
	*/
}
