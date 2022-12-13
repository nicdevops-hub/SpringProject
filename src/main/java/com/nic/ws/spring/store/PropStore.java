package com.nic.ws.spring.store;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropStore {

	private static Properties KEYS;
	private static Properties MSG;
	private static Properties SDQ;
	
	/*
	static {
		try {
			KEYS = new Properties();
			InputStream is = new FileInputStream(new File("/IFHMS_FMS_RCV_HOME/props/KeySet.properties"));
			KEYS.load(is);

			MSG = new Properties();
			MSG.load(new FileInputStream(new File("/IFHMS_FMS_RCV_HOME/props/FinRcvMsg.properties")));

			SDQ = new Properties();
			SDQ.load(new FileInputStream(new File("/IFHMS_FMS_RCV_HOME/props/FinRcvSql.properties")));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	static {
		try {
			KEYS = new Properties();
			InputStream is = new FileInputStream(new File("/opt/testapi/props/KeySet.properties"));
			KEYS.load(is);

			MSG = new Properties();
			MSG.load(new FileInputStream(new File("/opt/testapi/props/test/demo/TestDemoMsg.properties")));

			SDQ = new Properties();
			SDQ.load(new FileInputStream(new File("/opt/testapi/props/test/demo/TestDemoSql.properties")));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String MSG(String key) {
		return MSG.getProperty(key);
	}

	public static String KEYS(String key) {
		return KEYS.getProperty(key);
	}

	public static String SDQ(String key) {
		return SDQ.getProperty(key);
	}


}
