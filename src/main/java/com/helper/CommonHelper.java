package com.helper;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.configure.AppPropertyReader;
import com.configure.Base;
import com.configure.ConfigManager;

public class CommonHelper {
	
	WebDriver driver= Base.driver;

	private static Logger logger = LoggerFactory.getLogger(CommonHelper.class);
	
	Actions actions = new Actions(driver);
	
	public static void moveMouseToElement(By element) {
		
	}

	public static void selectByVisibleText(By ddTableFilter, String table) {
		Select select=new Select(Base.driver.findElement(ddTableFilter));
		select.selectByVisibleText(table);

	}

	public static String getSelectedOption(By ddTableFilter) {
		Select select=new Select(Base.driver.findElement(ddTableFilter));
		return select.getFirstSelectedOption().getText();
	}

	public static void acceptAlert() {

	}
	
	public static Double convertStringAmountToDouble(By Amount) {
		WebElement Ele = Base.driver.findElement(Amount);
		String str = Ele.getText();
		logger.info("Fetched amount as string " +str);
		String numberOnly= str.replaceAll("[^0-9.]", "");
		logger.info("Fetched amount as string only numbers " +numberOnly);
		
		Double amt= Double.parseDouble(numberOnly);
		logger.info("Fetched Amount " +amt);
		return amt;
	}
	
	public static String[] StringValueSeparator(String CombinedString) {
		
		if (CombinedString.contains(";")) {
			String[] arr=CombinedString.split(";");
			return arr;
			//String Prod1 = arr[0];
			//String Prod2 = arr[1];
			
		} 
		else {
		    throw new IllegalArgumentException("String " + CombinedString + " does not contain ;");
		}
		
	}

	public List<Integer> randomNumber(int lowerbound, int upperbound, int numcount) {
		List<Integer> random = new ArrayList<Integer>();
		final int[] ints = new Random().ints(lowerbound, upperbound + 1).distinct().limit(numcount).toArray();
		for (int i = 0; i < ints.length; i++) {
			random.add(ints[i]);
		}
		logger.info(random.toString());
		return random;
	}
	
	public String randomString(int count,boolean letters,boolean numbers) {
		String randomString = RandomStringUtils.random(count, letters, numbers);
		return randomString;
	}
	
	public String getCurrentDate() {
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    Date now = new Date();
		    String strDate = sdf.format(now);
		    return strDate;
		
	}



//	public boolean verifyWithCurrentDate(String actualDate) {
//		try{
//			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//			if(sdf.parse(getCurrentDate()).equals(sdf.parse(actualDate)))
//				return true;
//		} catch (Exception e) {
//			logger.error("Error in parsing the actual date:"+actualDate);
//			e.printStackTrace();
//		}
//		return false;
//	}
//
	public boolean verifyDates(String dateActual,String dateExpected) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			if (sdf.parse(dateActual).equals(sdf.parse(dateExpected)))
				return true;
		} catch (Exception e) {
			logger.error("Error in parsing the actualDate:" + dateActual+" and dateExpected:"+dateExpected);
			e.printStackTrace();
		}
		return false;
	}

	public boolean verifyWithCurrentDate(String actualDate) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			if(sdf.parse(getCurrentDate()).equals(sdf.parse(actualDate)))
				return true;
		} catch (Exception e) {
			logger.error("Error in parsing the actual date:"+actualDate);
			e.printStackTrace();
		}
		return false;
	}


/*
	public void uploadFile(String fileName) {
		try {
			String folderPath = System.getProperty("user.dir")+"\\src\\main\\resources\\TestFiles";
			String exeFileName = ConfigManager.getUploadExeFileName();
			folderPath = System.getProperty("user.dir")+ "\\"+ exeFileName +" "+ folderPath;
			Runtime.getRuntime().exec(folderPath);
			Thread.sleep(4000);
			fileName = fileName.replaceAll(";","\"\" \"\"");
			String exeFilePath = System.getProperty("user.dir")+ "\\"+ exeFileName +" \" \"\"" + fileName+"\"\"\"";
			Runtime.getRuntime().exec(exeFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public boolean compareDouble(double d1, double d2){
		DecimalFormat df = new DecimalFormat("0.00");
		int compareResult = Double.compare(Double.parseDouble(df.format(d1)),Double.parseDouble(df.format(d2)));
		if(compareResult==0)
			return true;
		else
			return false;
	}

	public int compareAndReturnStatus(double d1, double d2){
		DecimalFormat df = new DecimalFormat("0.00");
		int compareResult = Double.compare(Double.parseDouble(df.format(d1)),Double.parseDouble(df.format(d2)));
		return compareResult;
	}

	public static String dynamicXpath(String originalXpath, String replaceValue)  {
		return originalXpath.replace("${Value}", replaceValue);
	}

	public static String dynamicXpath2(String originalXpath, String replaceValue1, String replaceValue2) {
		return originalXpath.replace("${Value1}", replaceValue1).replace("${Value2}", replaceValue2);
	}


	public static String dynamicXpath3(String originalXpath, String replaceValue1, String replaceValue2, String replaceValue3) {
		return originalXpath.replace("${Value1}", replaceValue1).replace("${Value2}", replaceValue2).replace("${Value3}", replaceValue3);
}
	public static AppPropertyReader getAppProperty() {
		return new AppPropertyReader();
	}

	public static ConfigManager getConfigProperty() {
		return new ConfigManager();
	}

	public static By dynamicBy(String originalXpath, String replaceValue)  {
		return By.xpath(originalXpath.replace("${Value}", replaceValue));
	}

	public static void clickElement(By by){
		WaitHelper.waitForElementToBeClickable(by,ConfigManager.getSuperLongPlusSleepWait());
		logger.info("Clicking element "+by.toString());
		Base.driver.findElement(by).click();
		logger.info("Clicked element "+by.toString());
	}

	public static void sendKeystoElement(By by,String inputdata){
		WaitHelper.waitForElementToBeClickable(by,ConfigManager.getMediumSleepWait());
		logger.info("Entering ["+inputdata+"] to textbox "+by.toString());
		Base.driver.findElement(by).clear();
		Base.driver.findElement(by).sendKeys(inputdata);
		logger.info("Entered ["+inputdata+"] to textbox "+by.toString());
	}

	public static void navigateUrl(String url){
		Base.driver.navigate().to(url);
	}

	public static void switchtoFrame(String idorName){
		Base.driver.switchTo().frame(idorName);
	}

	public static int getElementCount(String elementXpath) throws InterruptedException {
		Base.driver.findElement(By.xpath(elementXpath));
		By by=By.xpath(elementXpath);
		WaitHelper.waitForElementToBeClickable(by);
		Thread.sleep(5000);
		//new
		return Base.driver.findElements(by).size();
	}

	public static Boolean isElementDisplayed(By by){

		try {
			WaitHelper.waitForVisibilityOfElement(by);
			Boolean isdisplayed=Base.driver.findElement(by).isDisplayed();
			logger.info("Element displayed "+by.toString());
			return isdisplayed;
		}
		catch (Exception e){

			logger.info(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public static Boolean isElementNotDisplayed(By by){

		Boolean isNotdisplayed=null;

		try {
			WaitHelper.sleep(ConfigManager.getLongPlusSleepWait());
			isNotdisplayed=!(Base.driver.findElement(by).isDisplayed());
			logger.info("TRY - "+isNotdisplayed);

		}
		catch (org.openqa.selenium.NoSuchElementException e){

			logger.info(e.getMessage());
			//e.printStackTrace();
			isNotdisplayed= true;
			logger.info("CATCH - "+isNotdisplayed);
		}
		return isNotdisplayed;
	}

}
