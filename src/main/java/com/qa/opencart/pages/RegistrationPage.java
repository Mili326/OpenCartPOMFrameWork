package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage extends BasePage{

	ElementUtil elementUtil;
	
	//Locators
	private By firstName =By.id("input-firstname");
	private By lastName  =By.id("input-lastname");
	private By email     =By.id("input-email");
	private By telephone =By.id("input-telephone");
	private By password  =By.id("input-password");
	private By confirmPassword=By.id("input-confirm");
	private By subscribeYes=By.cssSelector(".radio-inline input:nth-of-type(1)");
	private By subscribeNo=By.xpath("//label[@class='radio-inline'][2]/input");
	private By privacyPolicycheckbox=By.name("agree");
	private By continueButton=By.xpath("//input[@type='submit' and @value='Continue']");
	private By accountSuccessMesg= By.cssSelector("#content h1");	
	private By logoutLink=By.linkText("Logout");
	private By registerLink=By.linkText("Register");
	
	//Constructors
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	//Actions
	
	public boolean accountRegistration(String firstnm,String lastnm, String eMail, String telePhone,String passWord,String subScribe)
	{
		elementUtil.doSendKeys(firstName, firstnm);
		elementUtil.doSendKeys(lastName,  lastnm);
		elementUtil.doSendKeys(email,     eMail);
		elementUtil.doSendKeys(telephone, telePhone);
		elementUtil.doSendKeys(password, passWord);
		elementUtil.doSendKeys(confirmPassword, passWord);
		if(subScribe.equals("Yes"))
		{
			elementUtil.doClick(subscribeYes);
		}
			else {
					elementUtil.doClick(subscribeNo);
		      	 }
		
		elementUtil.doClick(privacyPolicycheckbox);
		elementUtil.doClick(continueButton); 
		String successTextMsg=elementUtil.doGetText(accountSuccessMesg);
		if(successTextMsg.contains(Constants.ACCOUNT_SUCCESS_MSG))
		{
			
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			
			return true;
		}
		return false;
					
			
			
					
					
					
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
