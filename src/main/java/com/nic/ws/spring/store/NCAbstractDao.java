package com.nic.ws.spring.store;

public class NCAbstractDao {
	
	public static AbstractDao NC_ABS_DB1 = new AbstractDao("DB1");
	public static AbstractDao NC_ABS_DB2 = new AbstractDao("DB2");
	
	private NCAbstractDao() {
	}
	
}
