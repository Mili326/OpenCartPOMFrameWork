package com.qa.opencart.tests;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoTest extends BaseTest {
	
	@BeforeClass
	public void verifyProductInfoPageSetUp()
	{
		accountsPage =loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	@Test(priority=2)
	public void verifyProductInfoPageTest()
	{
		//Assert.assertTrue(accountsPage.doSearch("Macbook"));
		//productInfoPage=accountsPage.getProductResults("MacBook Pro");
		
		Assert.assertTrue(productInfoPage.getProductImages()==4);
		
		Map<String,String> productinfoMap = productInfoPage.getProductInformation();
		System.out.println(productinfoMap);
		Assert.assertEquals(productinfoMap.get("Brand"),"Apple");
		Assert.assertEquals(productinfoMap.get("price"),"$2,000.00");
		Assert.assertEquals(productinfoMap.get("Ex Tax"),"$2,000.00");
		Assert.assertEquals(productinfoMap.get("productHeaderName"),"MacBook Pro");
		Assert.assertEquals(productinfoMap.get("Product Code"),"Product 18");
		Assert.assertEquals(productinfoMap.get("Reward Points"),"800");
		
	}
	
	@Test(priority=1)
	public void verifyProductPageTitleTest_MacBook_Pro()
	{
		accountsPage.doSearch("Macbook");
		productInfoPage=accountsPage.getProductResults("MacBook Pro");
		
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("MacBook Pro"),"MacBook Pro");
		
	}
	
		@Test(priority=3)
	 public void verifySelectQuantityTest()
	 {
		
		productInfoPage.selectQuantity("2");
	 }
	
	@Test(priority=4)
	public void verifyAddToCartTest()
	{
		Assert.assertTrue(productInfoPage.addToCart());
	}
	
	
	
	
	
	
	
	

}
