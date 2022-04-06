package com.hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.configure.AllObjects;
import com.configure.Base;
import com.configure.ConfigManager;
import com.hooks.AttachHooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AttachHooks {
	
	private static Logger logger = LoggerFactory.getLogger(AttachHooks.class);
	public static WebDriver driver;
	
	@Before
	public void setUp(Scenario scenario) {
		logger.info("Initializing setup");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		driver = Base.configureDriver(dc);
		new AllObjects(driver);
		ConfigManager.loadConfig();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info("Running Scenario:"+scenario.getName());
		driver.get("https://ukfy02.cloudfyprod.com/v3dev4/");
		
	}

    @After
	public void tearDown(Scenario scenario) {
		embedScreenShot(scenario);
		driver.quit();
		logger.info("after tear down");
	}
	

    public void embedScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
