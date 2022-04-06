package com.configure;

import java.util.HashMap;

import com.configure.CommonBean;

public class CommonBean {
	
	private static String userName;
	private static String attachmentFolderName;
	private static String fileNameInAttachmentFolder;
	private static String homePageURL;
	private static HashMap<String,String> roleDisplayNameMap;

	public static String getFileNameInAttachmentFolder() {
		return fileNameInAttachmentFolder;
	}

	public static void setFileNameInAttachmentFolder(String fileNameInAttachmentFolder) {
		CommonBean.fileNameInAttachmentFolder = fileNameInAttachmentFolder;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		CommonBean.userName = userName;
	}

	public static String getAttachmentFolderName() {
		return attachmentFolderName;
	}

	public static void setAttachmentFolderName(String attachmentFolderName) {
		CommonBean.attachmentFolderName = attachmentFolderName;
	}

	public static String getHomePageURL() {
		return homePageURL;
	}

	public static void setHomePageURL(String homePageURL) {
		CommonBean.homePageURL = homePageURL;
	}


	public static HashMap<String, String> getRoleDisplayNameMap() {
		return roleDisplayNameMap;
	}

	public static void setRoleDisplayNameMap(HashMap<String, String> roleDisplayNameMap) {
		CommonBean.roleDisplayNameMap = roleDisplayNameMap;
	}

}
