package com.qa.opencart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static String highlight;
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	/**
	 * This method initializes the browser on the basis of given browser
	 * @param browser
	 * @return This returns WebDriver driver
	 */
	public WebDriver init_driver(String browser)
	{
		System.out.println("Browser name is:" + browser);
		
		highlight=prop.getProperty("highlight");
		optionsManager=new OptionsManager(prop);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			if(Boolean.parseBoolean(prop.getProperty("remote")))
			{
						init_remoteDriver(browser);
			}
			else {
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));				//1.Set method 
			}
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			if(Boolean.parseBoolean(prop.getProperty("remote")))
			{
						init_remoteDriver(browser);
			}
			else {
			tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));				//1.Set method 
			}
			
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			//driver=new SafariDriver();
			tldriver.set(new SafariDriver());
		}
		else {
				System.out.println("Please pass the correct browser:"+ browser);
			}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
			//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			return getDriver();
	}
	private void init_remoteDriver(String browser) {
		System.out.println("Running test on Remote Grid: "+ browser);
		
		if(browser.equals("chrome"))
		{
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, optionsManager.getChromeOptions());
			try {
					tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
				} 
			catch (MalformedURLException e) {
			
												e.printStackTrace();
											}
		}
		if(browser.equals("firefox"))
		{
			DesiredCapabilities cap=DesiredCapabilities.firefox();
			cap.setCapability(ChromeOptions.CAPABILITY, optionsManager.getFirefoxOptions());
			try {
					tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
				} 
			catch (MalformedURLException e) {
			
												e.printStackTrace();
											}
		}
	}
	/*
	 * get driver using threadlocal
	 */
	 public static synchronized WebDriver getDriver()   //2.Get method
	 	{
				return tldriver.get();
			
	 	}
	/**
	 * 
	 * This method is used to laod the properties from config.properties file
	 * @return It returns Properties prop reference
	 */
	public Properties init_prop()
	{	
		prop=new Properties();
	
		try {
			FileInputStream ip=new FileInputStream("./src/main/java/com/qa/opencart/config/config.properties");
			prop.load(ip);
			}
				
		catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
		}
	/*
	 * This methos is used to take the screenshot
	 * It will return the path of screenshot
	 */
	@Attachment
	 public String getScreenshot()
	 {
		 File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		 String path=System.getProperty("user.dir") + "/screenshots/ " + System.currentTimeMillis() + ".png";
		 File dest=new File(path);	
		 
		 try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return path;
				 
				 
	 }
	
	
}
