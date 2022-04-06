package com.helper;

import org.openqa.selenium.WebDriver;

import com.configure.Base;

public class AlertHelper {
	WebDriver driver;

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
	}

	public static void acceptAlert() {
		Base.driver.switchTo().alert().accept();
	}

	public static void dismissAlert() {
		Base.driver.switchTo().alert().dismiss();
	}

	public static String getAlertText() {
		return Base.driver.switchTo().alert().getText().trim();
	}
}
