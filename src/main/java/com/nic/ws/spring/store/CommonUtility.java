package com.nic.ws.spring.store;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nic.ws.spring.controller.MasterController;
import com.nic.ws.spring.dao.MasterDaoImpl;
import com.nic.ws.spring.model.iobean.ResponseBean;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;


public class CommonUtility {
	
private static final Logger logger = LoggerFactory.getLogger(MasterDaoImpl.class);
	
	//private static MessageCode MSG = PropStore.MSG;
	//private static KEYSET KEY = PropStore.KEY;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	double start_time = 0;
	double end_time = 0;

	
	// for single data (only 1 column)
	class dataResultSetRowMapper implements RowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			ResultSetMetaData rsmd = rs.getMetaData();
			return rs.getString(rsmd.getColumnName(1));
		}
	}

	// for multiple data (multiple columns)
	class multi_dataResultSetRowMapper implements RowMapper<List<String>> {
		public List<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
			ResultSetMetaData rsmd = rs.getMetaData();
			List<String> data = new ArrayList<String>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				data.add(rs.getString(rsmd.getColumnName(i)));
			}
			return data;
		}
	}

	
	
	
	class ExceptionEmailThread extends Thread {
		private String email;
		private String emailbody;

		public ExceptionEmailThread(String emailbody) {
			this.email = PropStore.KEYS("mail.exception_mail");
			this.emailbody = emailbody;
		}

		@Override
		public void run() {
			try {
				start_time = System.currentTimeMillis();
				EmailUtility.sendExceptionMail(emailbody, email); // To send
				// error
				// report
				end_time = System.currentTimeMillis();
				System.out.println(end_time + " - " + start_time + " = " + ((end_time - start_time) / 1000)
						+ "sec (Email-To " + email + ")");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} // end of Exception Email Thread
	
	
	
	
	
	class GeneralEmailThread extends Thread {
		private String subject;
		private String email_id;
		private String content;
		private int lap = 3;

		public GeneralEmailThread(String subject, String content, String email_id) {
			this.subject = subject;
			this.content = content;
			this.email_id = email_id;
		}

		@Override
		public void run() {
			try {
				start_time = System.currentTimeMillis();
				EmailUtility.sendEmail(subject, content, email_id); // To send
				// mail
				end_time = System.currentTimeMillis();
				logger.info(end_time + " - " + start_time + " = " + ((end_time - start_time) / 1000) + "sec (SUB:"
						+ subject + "--Email-To " + email_id + ")");
				System.out.println(end_time + " - " + start_time + " = " + ((end_time - start_time) / 1000)
						+ "sec (SUB:" + subject + "--Email-To " + email_id + ")");
				// System.out.println(lap/0); to generate exception
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("*-*-*-*-*-*- Somthing went wrong ... Trying to send email again to --->" + email_id
						+ " for SUB:" + subject + "---*-*-*-*-*-*");
				System.out.println("*-*-*-*-*-*- Somthing went wrong ... Trying to send email again to --->" + email_id
						+ " for SUB:" + subject + "---*-*-*-*-*-*");
				if (lap > 0) { // trying to send email again if SMTP connection
					// lost for 3 times
					lap--;
					run();
				}
			}
		}
	} // end of General Email Thread

	
	public String base64_to_string(String inputString) {
		byte[] decodedBytes = Base64.getDecoder().decode(inputString.getBytes());
		System.out.println("decodedBytes " + new String(decodedBytes));
		return new String(decodedBytes);
	}
	
	public String string_to_base64(String inputString) {
		byte[] encodedBytes = Base64.getEncoder().encode(inputString.getBytes());
		System.out.println("encodedBytes " + new String(encodedBytes));
		return new String(encodedBytes);
	}
	
	
	
	public void printObjectDetails(Object obj) {
		System.out.println("Class=>"+obj.getClass().getName());
		System.out.println("Address=>"+System.identityHashCode(obj)+"   HexCode:"+Integer.toHexString(System.identityHashCode(obj)));
	}
	
	
	public void call_ExceptionEmailThread(String emailbody) {
		new ExceptionEmailThread(emailbody).start();
	}
	
	
	public void call_GeneralEmailThread(String subject, String content, String email_id) {
		new GeneralEmailThread(subject, content, email_id).start();
	}
	
	
	public String jsonFormat(Object inputBean) {
		try {
			String inputJson = mapper.writeValueAsString(inputBean);
			return inputJson;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static Timestamp convertStringToTimestamp(String strDate, String dateFormat) {
	    try {
	      DateFormat formatter = new SimpleDateFormat(dateFormat);	// "yyyy-MM-dd hh:mm:ss.SSS"  or "dd/MM/yyyy" etc.
	       // you can change format of date
	      Date date = formatter.parse(strDate);
	      Timestamp timeStampDate = new Timestamp(date.getTime());

	      return timeStampDate;
	    } catch (ParseException e) {
	      System.out.println("Exception :" + e);
	      return null;
	    }
	  }
	
	
	public dataResultSetRowMapper get_dataResultSetRowMapper() {
		return new dataResultSetRowMapper();
	}
	
	
	public multi_dataResultSetRowMapper get_multi_dataResultSetRowMapper() {
		return new multi_dataResultSetRowMapper();
	}

//--------------------------------------------------------------------------	
	
	public void con_entryLog(String Dev , String Service, String requestBody) {
		start_time = System.currentTimeMillis();
		logger.info("%%%%%%%%%%% "+Dev+" - Started "+Service+" %%%%%%%%%%%");
		logger.info("inputBean: " + requestBody);
	}

	
	
	
	public void con_exitLog(String Dev, String URI) {
		end_time = System.currentTimeMillis();
		logger.info("Turn Around Time: " + ((end_time - start_time) / 1000) + "sec");
		ws_track(URI, Dev, ((end_time - start_time) / 1000));
	}

	public void con_error(Exception e) {
		e.printStackTrace();
		logger.error("+++++++++ Wrong Input JSON Format +++++++++");
	}
	
	
	private void ws_track(String ws_name, String by, double response) {
		int i = 0;
		for (i = 0; i < MasterController.web_services.size(); i++) {
			if (MasterController.web_services.get(i).service.equals(ws_name))
				break;
		}

		if (i != MasterController.web_services.size()) {
			int req = MasterController.web_services.get(i).request;
			MasterController.web_services.get(i).by = by;
			MasterController.web_services.get(i).request++;
			MasterController.web_services.get(i).avg_response_time = Math.round((MasterController.web_services.get(i).avg_response_time * req + response) / MasterController.web_services.get(i).request);
			
			//Math.floor(a)
			
			//MasterController.web_services.get(i).avg_response_time = Math.floor((MasterController.web_services.get(i).avg_response_time * req + response) / MasterController.web_services.get(i).request);
		}
	}
	
	
	
	public void dao_error(String daoMetod, Object inputBean, Exception e, ResponseBean response) {
		e.printStackTrace();
		response.setStatMsg("not ok", PropStore.MSG("err.e10"));
		logger.error(daoMetod + " ===== ************** System error Exception *************");
		new ExceptionEmailThread(daoMetod + " ===== ************** System error Exception *************\n"
				+ this.jsonFormat(inputBean)).start();
	}
	
	public List<String> sqlSelectSingle(AbstractDao ABS_DB, String query) {
		System.out.println(query);
		List<String> TableData = ABS_DB.jdbcTemplate.query(query, get_dataResultSetRowMapper());
		return TableData;
	}
	
	
	public List<List<String>> sqlSelectMultiple(AbstractDao ABS_DB, String query) {
		System.out.println(query);
		List<List<String>> TableData = ABS_DB.jdbcTemplate.query(query, get_multi_dataResultSetRowMapper());
		return TableData;
	}
	
	public int sqlInsert(AbstractDao ABS_DB, String query) {
		System.out.println(query);
		return ABS_DB.jdbcTemplate.update(query);
	}
	
	public int sqlUpdate(AbstractDao ABS_DB, String query) {
		System.out.println(query);
		return ABS_DB.jdbcTemplate.update(query);
	}
	
	
	
	public long getDateDifference_days(String from_dt, String to_dt){
		//long diff = 0,diffDays=0;
		int returnInt = 0;
	try{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date date1=formatter.parse(from_dt);
		Date date2=formatter.parse(to_dt);

		java.util.Calendar cal1 = java.util.Calendar.getInstance();
		java.util.Calendar cal2 = java.util.Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		
		while (!cal1.after(cal2)) {
			cal1.add(java.util.Calendar.DAY_OF_MONTH, 1);
			returnInt++;
		}
//		System.out.println("Diff is "+returnInt);
//		diff = date2.getTime() - date1.getTime();
//		long diffSeconds = diff / 1000 % 60;
//		long diffMinutes = diff / (60 * 1000) % 60;
//		long diffHours = diff / (60 * 60 * 1000) % 24;
//		 diffDays = diff / (24 * 60 * 60 * 1000);
//		 System.out.println(diffDays);
//		System.out.print(diffDays + " days, ");
//		System.out.print(diffHours + " hours, ");
//		System.out.print(diffMinutes + " minutes, ");
//		System.out.println(diffSeconds + " seconds.");
		
	}catch(Exception e){
		e.printStackTrace();
	}
		return returnInt;
	}

	
	
	
	
	
}
