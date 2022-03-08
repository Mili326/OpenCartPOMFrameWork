package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{

	private ElementUtil elementUtil;
	
	//1.By locators /ObjectRepository (OR)
	private By myaccountLink=By.xpath("//span[text()='My Account']");
	private By loginLink=By.linkText("Login");
	private By emaildIDText= By.name("email");
	private By passwordtext=By.name("password");
	private By loginButton=By.xpath("//input[@class='btn btn-primary']");
	private By headerLink= By.linkText("Your Store");
	private By searchtext=By.name("search");
	private By shoppingcartLink=By.linkText("Shopping Cart");
	private By cartButton=By.xpath("//span[@id='cart-total']");
	private By navDesktop=By.linkText("Desktops");
	private By mp3Player=By.linkText("MP3 Players");
	private By registerLink=By.linkText("Register");
	private By newsLetter=By.linkText("Newsletter");
	//2.Constructor of LoginPage
	
	public LoginPage(WebDriver driver)//This driver can take browser values from BasePage
	{
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//3.Page actions :Features (Behaviour) of page in the form of methods
	
	//1.Get Login page title
	@Step("Action to get Login Page Title")
	public String getLoginPageTitle()
	{		
		   return  elementUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE,10);
	}
	
	//2. Page HeaderValue Your Store exists
	@Step("Action to get LoginPage header value")
	public String getHeaderValueText()
	{
		if(elementUtil.doPresenceOfElementLocated(headerLink, 10) != null)
		{
			return  elementUtil.doGetText(headerLink);
		}	return null;
    }
	
	//3.Search textbox is present
	@Step("Action for searchbox to be displayed")
	public boolean searchTextboxExists()
	{
		return driver.findElement(searchtext).isDisplayed();
	}
		
	//4.Shopping cart link is present
	public boolean shoppingcartLinkExists()
	{
		return driver.findElement(shoppingcartLink).isDisplayed();
	}
	//5.Cart button is present
	public boolean cartbuttonExists()
	{
		return driver.findElement(cartButton).isDisplayed();
	}
	//6. Desktops link is present	
	public boolean navDesktopsExists()
	{
		return driver.findElement(navDesktop).isDisplayed();
		
	}
	
	//7. MP3Player link is present
	public boolean mp3PlayerLinkExists()
	{
		return driver.findElement(mp3Player).isDisplayed();
	}
	
	//8.Register Link is present
	@Step("Action to naviagte to Register Page by registerlink")
	public RegistrationPage navigateToRegisterPage()
	{
		 elementUtil.doClick(registerLink);
		 return new RegistrationPage(driver);
		 
	}
	
	//9.NewsLetter Link is present
	public boolean newsLetterLinkExists()
	{
		return driver.findElement(newsLetter).isDisplayed();
	}
	
		
	//10. user is able to login
	@Step("Action to login with Username {0} and passowrd {1}") //0 ,1 parameters
	public AccountsPage doLogin(String un, String pwd)
	{			
				//driver.findElement(myaccountLink).click();
				//driver.findElement(loginLink).click();
				System.out.println("Login with username:"+ un + " and password "+ pwd );
				
				elementUtil.doSendKeys(emaildIDText, un);
				elementUtil.doSendKeys(passwordtext, pwd);
				elementUtil.doClick(loginButton);
						
				return new AccountsPage(driver);
			
		}
}
