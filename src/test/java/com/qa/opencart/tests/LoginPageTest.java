package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends BaseTest{
	
	@Epic("USer is able to login with valid username and password")
	@Story("US001: Loginpage title verification")
	@Test(priority=1)
	@Description("verify Login page Title Test")
	@Severity(SeverityLevel.NORMAL)
	public void verifytLoginPageTitleTest()
	{
		String loginPageTitle=loginPage.getLoginPageTitle();
		System.out.println(loginPageTitle);
		Assert.assertEquals(loginPageTitle, Constants.LOGIN_PAGE_TITLE);
		
		}
	@Story("US002: LoginPage Header Value verification")
	@Test(priority=2)
	@Description(" Verify Login Page Header Value Test")
	@Severity(SeverityLevel.NORMAL)
	public void verifyHeaderValueTest()
	{
		String headingLinkText=loginPage.getHeaderValueText();
		System.out.println(headingLinkText);
		Assert.assertEquals(headingLinkText, "Your Store");
	}
	@Story("US003:User is able to search any product")
	@Test(priority=3)
	@Description("Verify search Box Exists test")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySearchBoxExistsTest()
	{
		Assert.assertTrue(loginPage.searchTextboxExists());
	}
	
	@Test(priority=4)
	public void verifyShoppingCartLinkExistsTest()
	{
		Assert.assertTrue(loginPage.shoppingcartLinkExists());
	}
	
	@Test(priority=5)
	public void verifyShoppingCartButtonExistsTest()
	{
		Assert.assertTrue(loginPage.cartbuttonExists());
	}
	
	@Test(priority=6)
	public void verifyNavDesktopsExistsTest()
	{
		Assert.assertTrue(loginPage.navDesktopsExists());
	}
	
	@Test(priority=7)
	public void verifyMp3PlayerLinkExistsTest()
	{
		Assert.assertTrue(loginPage.mp3PlayerLinkExists());
	}
	
	@Test(priority=8)
	@Description("Verify Register link exists")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyRegisterLinkExistsTest()
	{
		loginPage.navigateToRegisterPage();
	}
	
	@Test(priority=9)
	public void verifyNewsLetterLinkExistsTest()
	{
		Assert.assertTrue(loginPage.newsLetterLinkExists());
	}
	
	@Story("US004:Valid user is able to login with valid username and password")
	@Test(priority=10)
	@Description("Verify User login")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyLoginTest()
	{
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	
	
	
	
}
