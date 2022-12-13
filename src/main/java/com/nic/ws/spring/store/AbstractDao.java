package com.nic.ws.spring.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


public class AbstractDao{
	
private GetTemplate Template = new GetTemplate();
	
	private String DB_ID;
	private static final Logger logger = LoggerFactory.getLogger(AbstractDao.class);
	
	public JdbcTemplate jdbcTemplate;
	public PlatformTransactionManager tranMngr;
	public TransactionStatus tranStatus;
	
	public AbstractDao(String DB_ID) {
		this.DB_ID = DB_ID;
		this.jdbcTemplate = getJdbcTemplate(this.DB_ID);
		this.tranMngr = getTransactionManager();
		this.tranStatus = getTransactionStatus();
	}
	
	 
	 private JdbcTemplate getJdbcTemplate(String DB_ID)
		{
			return Template.getTemplate(DB_ID);
		}
	 
	 
	 private PlatformTransactionManager getTransactionManager() {
		 return Template.getTransactionManager();
	 }
	 
	 @SuppressWarnings("finally")
	private TransactionStatus getTransactionStatus() {
		 TransactionDefinition def = new DefaultTransactionDefinition();
		 TransactionStatus transactionStatus=null;
		 try {
			 transactionStatus= Template.getTransactionManager().getTransaction(def);
		 }
		 catch(Exception ex) {
			 ex.printStackTrace();
			 logger.error("Database Connection error Network Problem.");
		 }
		 finally {
			 return transactionStatus;
		 }
	 }
	 
	 
	 
}//end of class
