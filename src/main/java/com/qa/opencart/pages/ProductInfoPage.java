package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage extends BasePage{


	private ElementUtil elementUtil;
	//Locators
	
	private By productheaderName = By.cssSelector("#content h1");
	private By productMetaData   = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice      = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By quantityInputText = By.id("input-quantity");
	private By addToCartbutton   = By.id("button-cart");
	private By productImages     = By.cssSelector(".thumbnails li img");
	private By successtext		 = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	
	
	//Constructors
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
				
	}
	//Actions
	
	public HashMap<String,String> getProductInformation()
	{
		HashMap<String,String> productInfoMap=new HashMap<>();//Key value pair for Metadata
		productInfoMap.put("productHeaderName",elementUtil.doGetText(productheaderName));// Add ProductHeaderName to hashmap reference 
		
		List<WebElement> productMetaDataList=elementUtil.getElements(productMetaData);  //get all the li(1) :metadata Info in list
		for(WebElement e:productMetaDataList)											//Iterate each element in the list
		{
			productInfoMap.put(e.getText().split(":")[0].trim(),e.getText().split(":")[1].trim());  //Add elements in Hashmap reference and get the key and Value 
			
		}
		
		List<WebElement> productPriceList=elementUtil.getElements(productPrice);//Get the priceList info in List
		productInfoMap.put("price", productPriceList.get(0).getText().trim());  //Add PriceList into Hashmap reference by reading its index at 0th position ,not using for loop
		productInfoMap.put("Ex Tax", productPriceList.get(1).getText().split(":")[1].trim());  //Add PriceList into Hashmap reference by reading its index at 1st position
	
		return productInfoMap;
		
	}
	
	public void selectQuantity(String quantity)
	{
		  elementUtil.getElement(quantityInputText).clear();	
	      elementUtil.doSendKeys(quantityInputText, quantity);  //sendKeys only takes String not Integers
	}
	
	public boolean addToCart()
	{
		elementUtil.doClick(addToCartbutton);
		
		String text=elementUtil.doGetText(successtext);
		if(text.contains("Success"))
		{
			System.out.println("Product is successfully added");
			
		}else
		{
			System.out.println("Product is not added");
		}
		return false;
		
		
	}
	
	public int getProductImages()
	 {
		int productImagesCount= elementUtil.getElements(productImages).size();
		System.out.println("Total product images count:" + productImagesCount);
		return productImagesCount;
		
		
	 }
	public String getProductInfoPageTitle(String productName)
	{
		return elementUtil.waitForTitleIs(productName, 5);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}