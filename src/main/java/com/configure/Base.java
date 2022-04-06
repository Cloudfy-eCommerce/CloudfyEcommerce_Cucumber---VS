package com.configure;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.configure.Base;


public class Base {
	public static WebDriver driver;
	private static Logger logger = LoggerFactory.getLogger(Base.class);
	private static List<String> tabs;
	
	@SuppressWarnings("deprecation")
	public static WebDriver configureDriver(DesiredCapabilities dc) {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/chromedriver_win32/chromedriver.exe");        
		driver = new ChromeDriver(dc); 
		//driver = new ChromeDriver(dc);
		return driver;
	}
	
	public static boolean isElementVisible(WebElement element, int... timeOutSeconds) {
		try {
			int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];

			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			element = wait.until(ExpectedConditions.visibilityOf(element));
			if (element != null) {
				logger.info("WebElement:" + element + " is present on the page");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("WebElement:" + element + " is not present on the page");
		}
		return false;
	}

	public static boolean isElementVisible(By locator, int... timeOutSeconds) {
		try {
			int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			if (element != null) {
				logger.info("Element is visible on page located by locator:" + locator);
				return true;
			}
		} catch (Exception e) {
			logger.info("Element not present using locator:" + locator);

		}
		return false;
	}

	public static boolean isElementPresent(By element, int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getSmallWait() : timeOutSeconds[0];
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			if (wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(element))))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static WebElement findElement(By locator, int... timeOutSeconds) {
		WebElement element = null;
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		logger.info("Located element using locator:" + locator);
		return element;
	}

	public static List<WebElement> findElements(By locator, int... timeOutSeconds) {
		try {
			int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			logger.info("Located webelements:" + elements.toString() + " using locator:" + locator);
			return elements;
		} catch (Exception e){
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void click(WebElement element, int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void click(By locator, int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public static String getText(WebElement element, String text, int... timeOutSeconds) {
		
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		try {
		String elementText;
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		elementText = element.getText();
		logger.info("Fetched the text:" + elementText + " from element:" + element);
		return elementText.trim();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getText(WebElement element, int... timeOutSeconds) {
		String elementText = null;
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		try {
			if (isElementVisible(element, timeOut)) {
				elementText = element.getText();
				logger.info("Fetched the text:" + elementText + " from element:" + element);
			} else
				logger.error("Element:" + element + " not visible.");
			return elementText.trim();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getText(By element, int... timeOutSeconds) {
		return getText(findElement(element), timeOutSeconds);
	}

	public static String getTextFromInputBox(WebElement element, int... timeOutSeconds) {
		String elementText = null;
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		try {
			if (isElementVisible(element, timeOut)) {
				elementText = element.getAttribute("value");
				logger.info("Fetched the text:" + elementText + " from element:" + element);
			} else
				logger.error("Element:" + element + " not visible.");
			return elementText.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getTextFromInputBox(By element, int... timeOutSeconds) {
		String elementText = null;
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		try {
			if (isElementVisible(element, timeOut)) {
				elementText = findElement(element).getAttribute("value");
				logger.info("Fetched the text:" + elementText + " from element:" + element);
			} else
				logger.error("Element:" + element + " not visible.");
			return elementText.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void sendKeys(By locator, String value, int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		WebElement element = findElement(locator, timeOut);
		sendKeys(element, value, timeOutSeconds);
		logger.info("Entering value:" + value + " in field located by locator:" + locator);
	}

	public static void sendKeys(WebElement element, String value, int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		if (isElementVisible(element, timeOut)) {
			element.clear();
			element.sendKeys(value);
			logger.info("Entering value:" + value + " in field located by webelement:" + element);
		} else
			logger.error("Element:" + element + " not visible.");
	}

	public static void sendKeysWithoutClearing(By elementByxpath, String value, int... timeOutSeconds) {
		WebElement element = findElement(elementByxpath,timeOutSeconds);
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		if (isElementVisible(element, timeOut)) {
			element.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),value);
			logger.info("Entering value:" + value + " in field located by webelement:" + element);
		} else
			logger.error("Element:" + element + " not visible.");
	}

	public static void sendKeysWithoutClearing(WebElement element, String value, int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		if (isElementVisible(element, timeOut)) {
			element.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),value);
			logger.info("Entering value:" + value + " in field located by webelement:" + element);
		} else
			logger.error("Element:" + element + " not visible.");
	}
	
	public static void doubleClick(WebElement element) {
		if(isElementVisible(element)) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
		}
	}

	public static void switchToNextTab(){
		tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public static void switchToLastTab() {
		driver.switchTo().window(tabs.get(0));
	}
	
	public static void switchToFrame(int no) {
		
		
		driver.switchTo().frame(no);
	}
	
	public static void switchToFrame(WebElement element) {
		
		
		driver.switchTo().frame(element);
	}

	public static void switchToFrame(String name) {
	
	driver.switchTo().frame(name);
	}
	
	public static void switchToDefaultContent() {
		
		driver.switchTo().defaultContent();
	}
	
	public static void doubleClick(By element) {
		doubleClick(findElement(element));
	}

	public static void clearInputBox(WebElement element) {
		element.clear();
	}

	public static void navigate(String url) {
		driver.navigate().to(url);
	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static void pressEnterKey(WebElement element){
		element.sendKeys(Keys.RETURN);
	}

	@SuppressWarnings("unchecked")
	public static void waitUntilElementNotDisplayed(WebElement webElement,int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getDefaultWait() : timeOutSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		@SuppressWarnings("rawtypes")
		ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					webElement.isDisplayed();
					return false;
				}
				catch (NoSuchElementException e ) {
					return true;
				}
				catch (StaleElementReferenceException f) {
					return true;
				}
			}
		};
		wait.until(elementIsDisplayed);
	}

	public  static void refresh() {
		driver.navigate().to(getCurrentUrl());
	}

}
