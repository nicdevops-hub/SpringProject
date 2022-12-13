package com.nic.ws.spring.store;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

//import com.nic.ws.spring.dao.MasterDaoImpl;

public class NicScheduler {
	
	public static int thread_count=0;
	private static NICThread nicThread=null;
	
	
	public  void runScheduler() {
		if(++thread_count>1) {
			nicThread.cancel();
			thread_count--;
			System.out.println("*************** Previous  NicScheduler Thread has been killed");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.WEDNESDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		calendar.set(Calendar.HOUR_OF_DAY, 13);
		calendar.set(Calendar.MINUTE, 27);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		System.out.println(calendar.getTime().toString());

		Timer time = new Timer(); // Instantiate Timer Object

		// Start running the task on Monday at 15:40:00, period is set to 8 hours
		// if you want to run the task immediately, set the 2nd parameter to 0
		// time.schedule(new IRPThread(), calendar.getTime(),TimeUnit.HOURS.toMillis(8));
		NicScheduler.nicThread= new NICThread();
		time.schedule(nicThread, calendar.getTime(), TimeUnit.MINUTES.toMillis(1));
	}
	
	
//------------------------------------------------------------------------------------------------------
	

	class NICThread extends TimerTask {

		public NICThread() {}

		@Override
		public void run() {
			try {
				System.out.println("NICThread call");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	} 

	

}
