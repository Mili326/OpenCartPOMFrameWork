package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String LOGIN_PAGE_TITLE="Account Login";
	public static final String Accounts_PAGE_TITLE="My Account";
	public static final String Accounts_PAGE_Header="Your Store";
	public static final int ACCOUNTS_SECTION_COUNT=4;
	public static final String TEST_DATA_SHEET_PATH="./src/main/java/com/qa/opencart/testdata/DataProvider.xlsx";
	public static final String REGISTER_SHEET_NAME="Sheet1";
	public static final String ACCOUNT_SUCCESS_MSG="Account Has Been Created";
	public static List<String> getAccountSectionList()
	{
		List<String> accountSectionList=new ArrayList<String>();
		accountSectionList.add("My Account");
		accountSectionList.add("My Orders");
		accountSectionList.add("My Affiliate Account");
		accountSectionList.add("Newsletter");
		return accountSectionList;
	}
	
	
	
	
	
}
