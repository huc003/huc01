package com.huc.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huc.common.constant.Constants;
import com.mchange.v2.log.LogUtils;


public class PropertiesUtils {
	
	private static final Log log = LogFactory.getLog(PropertiesUtils.class);

	public static List<String> blackList = null;

	protected static final String BUNDLE_NAME = "properties.";
	protected static String prefix = (ValidatorUtils
			.isNotEmpty(Constants.ENVIRONMENT)) ? Constants.ENVIRONMENT + "."
			: "";

	private static final String BUNDLE_NAME_LOG = BUNDLE_NAME + prefix + "log";
//	private static final String BUNDLE_NAME_DB = BUNDLE_NAME + prefix + "jdbc";
//	private static final String BUNDLE_NAME_SINA = BUNDLE_NAME + prefix
//			+ "sina";
	private static final String BUNDLE_NAME_REWARD = BUNDLE_NAME + prefix
			+ "reward";
//	private static final String BUNDLE_NAME_REPAY = BUNDLE_NAME + prefix + "repay_handel";
//	private static final String BUNDLE_NAME_ACTIVITY = BUNDLE_NAME + prefix + "activity";
//	private static final String BUNDLE_NAME_WEIXIN = BUNDLE_NAME + prefix + "weixin";
//	private static final String BUNDLE_NAME_REDIS = BUNDLE_NAME + prefix + "redis";
//	private static final String BUNDLE_NAME_OSS = BUNDLE_NAME + prefix + "oss";
	private static final String BUNDLE_NAME_CONFIG = "qttz";
	private static final String BUNDLE_NAME_MSG = "message";

	private static ResourceBundle RESOURCE_BUNDLE_LOG = null;
//	private static ResourceBundle RESOURCE_BUNDLE_DB = null;
//	private static ResourceBundle RESOURCE_BUNDLE_SINA = null;
	private static ResourceBundle RESOURCE_BUNDLE_REWARD = null;
	private static ResourceBundle RESOURCE_BUNDLE_CONFIG = null;
	private static ResourceBundle RESOURCE_BUNDLE_MSG = null;
//	private static ResourceBundle RESOURCE_BUNDLE_REPAY = null;
//	private static ResourceBundle RESOURCE_BUNDLE_ACTIVITY = null;
//	private static ResourceBundle RESOURCE_BUNDLE_WEIXIN = null;
//	private static ResourceBundle RESOURCE_BUNDLE_REDIS = null;
//	private static ResourceBundle RESOURCE_BUNDLE_OSS = null;

	public static void init() {
		RESOURCE_BUNDLE_MSG = ResourceBundle.getBundle(BUNDLE_NAME_MSG);
		RESOURCE_BUNDLE_CONFIG = ResourceBundle.getBundle(BUNDLE_NAME_CONFIG);
		prefix = (ValidatorUtils
				.isNotEmpty(getString(RESOURCE_BUNDLE_CONFIG, "environment"))) ? getString(RESOURCE_BUNDLE_CONFIG, "environment") + "."
				: "";
//		RESOURCE_BUNDLE_REWARD = ResourceBundle.getBundle(BUNDLE_NAME + prefix+ "reward");
//		RESOURCE_BUNDLE_LOG = ResourceBundle.getBundle(BUNDLE_NAME + prefix + "log");
//		RESOURCE_BUNDLE_DB = ResourceBundle.getBundle(BUNDLE_NAME_DB);
//		RESOURCE_BUNDLE_SINA = ResourceBundle.getBundle(BUNDLE_NAME_SINA);
//		RESOURCE_BUNDLE_REPAY = ResourceBundle.getBundle(BUNDLE_NAME_REPAY);
//		RESOURCE_BUNDLE_ACTIVITY = ResourceBundle.getBundle(BUNDLE_NAME_ACTIVITY);
//		RESOURCE_BUNDLE_WEIXIN = ResourceBundle.getBundle(BUNDLE_NAME_WEIXIN);
//		RESOURCE_BUNDLE_REDIS = ResourceBundle.getBundle(BUNDLE_NAME_REDIS);
//		RESOURCE_BUNDLE_OSS = ResourceBundle.getBundle(BUNDLE_NAME_OSS);
		readBlackList();
	}
	private static void readBlackList(){
		blackList = new ArrayList<String>();
		String path = PropertiesUtils.class.getResource("/").getPath()+"blacklist.txt";
		BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String tempString = null;  
            while ((tempString = reader.readLine()) != null) {
               blackList.add(tempString.trim());
            }  
            reader.close();  
        } catch (IOException e) {
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }
	}

	public static void clearCache() {
		ResourceBundle.clearCache();
	}

	public static String getString(ResourceBundle resourceBundle, String key) {

		if (resourceBundle == null) {
			return Constants.UNKNOWN; // 未知错误
		}

		try {
			return StringUtils.getInstance().nullToStrTrim(resourceBundle.getString(key));
		} catch (MissingResourceException e) {
			log.info(CommonUtils.getTraceInfo() +" key:"+key+"\t"+ StringUtils.getInstance().nullToStrTrim(e.getMessage()));
			return Constants.UNKNOWN; // 未知错误
		}
	}

	public static String getLog(String key) {
		return getString(RESOURCE_BUNDLE_LOG, key);
	}


	public static String getReward(String key) {
		return getString(RESOURCE_BUNDLE_REWARD, key);
	}

	public static String getConfig(String key) {
		return getString(RESOURCE_BUNDLE_CONFIG, key);
	}

	public static String getMessage(String key) {
		return getString(RESOURCE_BUNDLE_MSG, key);
	}

}
