package com.helper;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.configure.ConfigManager;
import com.helper.WaitHelper;

public class WaitHelper {
	
	static WebDriver driver;
	private static Logger logger = LoggerFactory.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		WaitHelper.driver = driver;
	}

	public static void waitForInvisibilityOfElement(WebElement element, int... timeOutInSeconds) {
		try {
			int timeOut = (timeOutInSeconds.length==0)?ConfigManager.getSmallWait():timeOutInSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.invisibilityOf(element));
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("Element not visible for checking invisibility :"+element);
		}
	}
	
	public static void waitForInvisibilityOfElement(By element, int... timeOutInSeconds) {
		try {
			int timeOut = (timeOutInSeconds.length==0)?ConfigManager.getSmallWait():timeOutInSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("Element not visible for checking invisibility :"+element);
		}
	}
	
	public static void waitForVisibilityOfElement(By element, int... timeOutInSeconds) {
		try {
			int timeOut = (timeOutInSeconds.length==0)?ConfigManager.getSmallWait():timeOutInSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("Element not visible for checking invisibility :"+element);
		}
	}

	public static void waitForElementToBeClickable(By element, int... timeOutInSeconds) {
		try {
			int timeOut = (timeOutInSeconds.length==0)?ConfigManager.getSmallWait():timeOutInSeconds[0];
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
            logger.info("Waiting for element to be clickable element: ["+element.toString()+"] for timeout ["+timeOut+
                    "] seconds");
			wait.until(ExpectedConditions.elementToBeClickable(element));
            logger.info("Wait completed and found clickable element: ["+element.toString()+
                    "] for timeout ["+timeOut+
                    "] seconds");
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("Element not visible for checking invisibility :"+element);
		}
	}

	public static void waitForVisibilityOfElement(WebElement element, int... timeOutInSeconds) {
		try {
			int timeOut = (timeOutInSeconds.length==0)?ConfigManager.getSmallWait():timeOutInSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("Element not visible for checking invisibility :"+element);
		}
	}
	
	public static void waitForPresenceOfAlert() {
		WebDriverWait wait = new WebDriverWait(driver, ConfigManager.getMediumWait());
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitForPageToLoad() {
		try {
			logger.info("start of page load");
			JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;
			Function<WebDriver, Boolean> readyState = (WebDriver e) -> (Boolean)jsExecuter
					.executeScript("return (document.readyState == 'complete' && jQuery.active == 0)");
			WebDriverWait wait = new WebDriverWait(driver, ConfigManager.getMediumWait());
			wait.until(readyState);
			logger.info("end of page load");
		} catch (Exception error) {
			logger.error("error in page load");
			error.printStackTrace();
		}
	}
	
	public static void waitForLoaderDisappear(List<WebElement>  elements,int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getSmallWait() : timeOutSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	
	public static void waitForAbsenceOfElements(By elements,int... timeOutSeconds) {
		try {
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getSmallWait() : timeOutSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(elements)));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public static void waitForAbsenceOfElement(By elements,int... timeOutSeconds) {
		try {
		int timeOut = (timeOutSeconds.length == 0) ? ConfigManager.getSmallWait() : timeOutSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(elements)));	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void waitForTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitForInvisibilityOfElement(By element) {
		int noOfElements;
		int count = 0;
		try {
			do {
				noOfElements = driver.findElements(element).size();
				if (noOfElements != 0) {
					waitForTime(ConfigManager.getMediumSleepWait());
				}
				count++;
			} while (noOfElements != 0 && driver.findElement(element).isDisplayed() && count<20);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

    public static void sleep(int sleepTimeMS) {
		try {
			logger.info("Sleeping for ["+sleepTimeMS+"] milli seconds");
			Thread.sleep(sleepTimeMS);

		}
		catch (Exception e){
			e.printStackTrace();
		}
    }

}
