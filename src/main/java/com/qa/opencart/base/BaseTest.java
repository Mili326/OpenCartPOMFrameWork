package com.qa.opencart.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;

public class BaseTest {
	/**
	 * make connection with config.properties file and get Browser name and Url
	 * Launch the browser
	 * Launch the url
	 */
	public BasePage basePage;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public ProductInfoPage productInfoPage;
	public RegistrationPage registerPage;
	public Properties prop;
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName)   //this browserName is coming from xml
	{
		basePage=new BasePage();
		prop=basePage.init_prop(); //make connection with config.properties file and get browser name
		String browser=prop.getProperty("browser");
		if(browserName!=null)
		{
			browser=browserName;
		}
				
		driver=basePage.init_driver(browser);//Then initiliase the driver with browser name and check which browser matches
		loginPage=new LoginPage(driver);
		String url=prop.getProperty("url");
		driver.get(url); //get url
		
	}
				
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}
	
}

