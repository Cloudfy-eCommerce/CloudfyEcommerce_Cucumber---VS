package com.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.configure.Base;

public class JSHelper {
	
	WebDriver driver;
	private static Logger logger = LoggerFactory.getLogger(CommonHelper.class);

	public JSHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor) Base.driver;
		js.executeScript("window.scrollBy(0,-(document.body.scrollHeight))");
	}
	
	public static void scrollPageBy() {
		JavascriptExecutor js = (JavascriptExecutor) Base.driver;
		js.executeScript("window.scrollBy(0,250)");
	}

	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) Base.driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

	public static void click(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) Base.driver;
		logger.info("Clicking element "+element.toString());
		js.executeScript("arguments[0].click();", element);
		logger.info("Clicked element "+element.toString());
	}

	public static void scrollAndClick(WebElement element ) {
		JavascriptExecutor js = (JavascriptExecutor) Base.driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		js.executeScript("arguments[0].click();", element);
	}

	public static String getText(WebElement element) {
		return (String)((JavascriptExecutor) Base.driver).executeScript("return arguments[0].innerHTML;",element);
	}

	public static String getTextFromNode(String xpath) {
		Object load= ((JavascriptExecutor) Base.driver).executeScript("var value = document.evaluate(\""+xpath+"\",document, null, XPathResult.STRING_TYPE, null ); return value.stringValue;");
		return load.toString();
	}

}
