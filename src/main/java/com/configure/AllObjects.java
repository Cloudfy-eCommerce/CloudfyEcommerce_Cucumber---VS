package com.configure;

import org.openqa.selenium.WebDriver;

import com.helper.AlertHelper;
import com.helper.DropDownHelper;
import com.helper.JSHelper;
import com.helper.CommonHelper;
import com.helper.WaitHelper;

public class AllObjects {
	
	public static WaitHelper waitHelper;
	public static AlertHelper alertHelper;
	public static DropDownHelper dropDownHelper;
	public static CommonHelper commonHelper;
	public static JSHelper jsHelper;
	public AllObjects(WebDriver driver) {
	 waitHelper = new WaitHelper(driver);
	 alertHelper = new AlertHelper(driver);
	 dropDownHelper = new DropDownHelper(driver);
	 jsHelper = new JSHelper(driver);
	 commonHelper = new CommonHelper();
	}
}
