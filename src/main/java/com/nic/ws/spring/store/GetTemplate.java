package com.nic.ws.spring.store;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;

public class GetTemplate {

	//private static final Logger logger = LoggerFactory.getLogger(GetTemplate.class);

	private JdbcTemplate template;
	private SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

	public JdbcTemplate getTemplate(String DB_ID) {
		String server = "";
		String host = "";
		String port = "";
		String database = "";
		String username = "";
		String password = "";
		/*int id = 0;
		id = Integer.parseInt(DB_ID.substring(2).trim());
		server = PropStore.KEYS("db.server" + id);
		host = PropStore.KEYS("db.host" + id);
		port = PropStore.KEYS("db.port" + id);
		database = PropStore.KEYS("db.database" + id);
		username = PropStore.KEYS("db.username" + id);
		password = PropStore.KEYS("db.password" + id);
		*/
		
		if(DB_ID.equalsIgnoreCase("DB1")){
			server=PropStore.KEYS("db.server1");
			host=PropStore.KEYS("db.host1");
			port=PropStore.KEYS("db.port1");
			database=PropStore.KEYS("db.database1");
			username=PropStore.KEYS("db.username1");
			password=PropStore.KEYS("db.password1");
		}
		else if(DB_ID.equalsIgnoreCase("DB2")){
			server=PropStore.KEYS("db.server2");
			host=PropStore.KEYS("db.host2");
			port=PropStore.KEYS("db.port2");
			database=PropStore.KEYS("db.database2");
			username=PropStore.KEYS("db.username2");
			password=PropStore.KEYS("db.password2");
		}

		try {

			if (server.equalsIgnoreCase("mysql")) {
				// dataSource.setDriver(new com.mysql.jdbc.Driver());
				// dataSource.setUrl("jdbc:mysql://"+host+":"+port+"/"+database);

			} else if (server.equalsIgnoreCase("oracle")) {
				dataSource.setDriver(new oracle.jdbc.driver.OracleDriver());
				dataSource.setUrl("jdbc:oracle:thin:@" + host + ":" + port + ":" + database);

			} else if (server.equalsIgnoreCase("postgresql")) {
				dataSource.setDriver(new org.postgresql.Driver());
				dataSource.setUrl("jdbc:postgresql://" + host + ":" + port + "/" + database);

			} else if (server.equalsIgnoreCase("db2")) {
				// dataSource.setDriver(new com.ibm.db2.jcc.DB2Driver());
				dataSource.setUrl("jdbc:db2://" + host + ":" + port + "/" + database);

			}

			dataSource.setUsername(username);
			dataSource.setPassword(password);

			this.template = new JdbcTemplate(dataSource);

			return template;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public PlatformTransactionManager getTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}
