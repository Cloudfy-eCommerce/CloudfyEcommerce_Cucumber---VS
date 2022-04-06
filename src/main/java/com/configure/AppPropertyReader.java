package com.configure;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.configure.AppPropertyReader;

public class AppPropertyReader {
	private static final Logger logger = LoggerFactory.getLogger(AppPropertyReader.class);
	static JSONObject appProperty;

	public AppPropertyReader() {
		try {
			appProperty = new JSONObject(
					new String(Files.readAllBytes(Paths.get("src\\main\\resources\\AppRepository.json"))));
		} catch (Exception e) {
			logger.error("Exception occurred while loading ValidationMessage.properties " + e.getMessage());
		}

	}
}
