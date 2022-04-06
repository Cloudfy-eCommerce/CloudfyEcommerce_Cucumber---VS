package com.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.configure.Base;
import com.configure.ConfigManager;

public class DropDownHelper {
	
	private static Logger logger = LoggerFactory.getLogger(CommonHelper.class);

	WebDriver driver;
	Actions action; 
	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
	}

	public static void selectByVisibleText(WebElement drodownElement, String itemToSelect) {
		Select select = new Select(drodownElement);
		select.selectByVisibleText(itemToSelect);
	}
	
	public void selectByValue(WebElement drodownElement, String value) {
		Select select = new Select(drodownElement);
		select.selectByValue(value);
	}
	
	public void selectByIndex(WebElement drodownElement, int indexOfElement) {
		Select select = new Select(drodownElement);
		select.selectByIndex(indexOfElement);
	}
	
	public void clickOnElementFromDropdown(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,ConfigManager.getExplicitWait());
		wait.until(ExpectedConditions.visibilityOf(element));
		action.moveToElement(element).click().build().perform();
	}
	
	public void clickOnElementFromDropdown(By xpath) {
		WebElement element = driver.findElement(xpath);
		clickOnElementFromDropdown(element);
	}
	
	public String getTextFromSelectOption(WebElement element) {
		String text = new Select(element).getFirstSelectedOption().getText();
		return text;
	}

	public void hoverOver(WebElement element) {
		action.clickAndHold(element).build().perform();
	}



	public static void selectfromComboBox(String itemtoselect, By ddtoggle, By searchbox, String elementDyXpath) {
		if (itemtoselect.toLowerCase().trim() == "null" || itemtoselect.toLowerCase().trim() == "") {
			logger.info("Skipping the Action Since input is [" + itemtoselect + "] and element is: " + ddtoggle.toString());
			return;
		}
		if (ddtoggle != null) {
			CommonHelper.clickElement(ddtoggle);
		}
		CommonHelper.sendKeystoElement(searchbox, itemtoselect);
		WebElement element = Base.driver.findElement(CommonHelper.dynamicBy(elementDyXpath, itemtoselect));
		JSHelper.click(element);

	}

}
