package com.configure;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.configure.ConfigManager;

public class ConfigManager {
	static JSONObject configProperties;

	private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);
	
	public static void loadConfig() {
		try {
			configProperties = new JSONObject(new String(Files.readAllBytes(Paths.get("src\\main\\resources\\Config.json"))));

		} catch (Exception e) {
			logger.error("Exception occurred while loading config.properties " + e.getMessage());
		}

	}
	
	public static String getAdminUname() {
		logger.info("fetching explicit wait from configuration file");
		return configProperties.getString("userName");
	}
	
	public static String getAdminPwd() {
		logger.info("fetching explicit wait from configuration file");
		return configProperties.getString("password");
	}
	
	public static int getExplicitWait() {
		logger.info("fetching explicit wait from configuration file");
		return configProperties.getInt("ExplicitWait");
	}
	
	public static int getSmallWait() {
		logger.info("fetching small wait from configuration file");
		return configProperties.getInt("ExplicitWaitSmall");
	}
	
	public static int getMediumWait() {
		logger.info("fetching medium wait from configuration file");
		return configProperties.getInt("ExplicitWaitMedium");
	}
	
	public static int getLongWait() {
		logger.info("fetching long wait from configuration file");
		return configProperties.getInt("ExplicitWaitLong");
	}
	
	public static int getSmallSleepWait() {
		logger.info("fetching small sleep wait");
		return configProperties.getInt("smallSleepWait");
	}
	
	public static int getSmallPlusSleepWait() {
		logger.info("fetching small plus sleep wait");
		return configProperties.getInt("smallPlusSleepWait");
	}
	
	public static int getMediumSleepWait() {
		logger.info("fetching medium sleep wait");
		return configProperties.getInt("mediumSleepWait");
	}
	
	public static int getDefaultWait() {
		return configProperties.getInt("DefaultWait");
	}

	public static int getLongPlusSleepWait() {
		return configProperties.getInt("longPlusSleepWait");
	}

	public static String getUploadExeFileName() {
		return configProperties.getString("uploadExeFileName");
	}

	public static int getSuperLongPlusSleepWait() {
		return configProperties.getInt("superlongPlusSleepWait");
	}
	
	public static String getBaseURL() {
		return configProperties.getJSONObject("pageUrl").getString("baseUrl");
	}
	
}
