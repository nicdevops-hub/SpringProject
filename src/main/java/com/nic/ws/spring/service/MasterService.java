package com.nic.ws.spring.service;

import com.nic.ws.spring.model.iobean.*;
import com.nic.ws.spring.model.iosub.*;


public interface MasterService {

	public Object get_testService();
	public Object post_testService(InputBeanTest readValue);
	
	public void v1nic_v1nic_get_emp_names_service(ResponseBean responseBean);
	public void v1nic_save_emp_details_service(ResponseBean responseBean, Employee_Details inputData);
	public void v1nic_get_emp_details_service(ResponseBean responseBean, Employee_Details inputData);
	public void v1nic_v1nic_get_stu_names_service(ResponseBean responseBean);
	public void v1nic_save_stu_details_service(ResponseBean responseBean, Student_Details inputData);
	public void v1nic_update_stu_details_service(ResponseBean responseBean, Student_Details inputData);
	public void v1nic_delete_stu_details_service(ResponseBean responseBean, Student_Details inputData);
	public void v1nic_v1nic_get_bank_details_service(ResponseBean responseBean);
	public void v1nic_insert_bank_details_service(ResponseBean responseBean, Bank_Details inputData);
	public void v1nic_update_bank_details_service(ResponseBean responseBean, Bank_Details inputData);
	
	//public void v1nic_v1nic_get_state_details_service(ResponseBean responseBean);
	public void v1nic_v1nic_get_state_details_service(ResponseBean responseBean);
	public void v1nic_v1nic_get_user_details_service(ResponseBean responseBean);
	public void v1nic_v1nic_get_job_details_service(ResponseBean responseBean);
	public void v1nic_insert_job_details_service(ResponseBean responseBean, Job_Details inputData);
	public void v1nic_update_job_details_service(ResponseBean responseBean, Job_Details inputdata);
	public void v1nic_delete_job_details_service(ResponseBean responseBean, Job_Details inputData);
	
	//-------------------------sandip-------------------------------------
	public void v1nic_v1nic_get_branch_details_service(ResponseBean responseBean);
	public void v1nic_insert_branch_details_service(ResponseBean responseBean, Branch_Details inputData);
	public void v1nic_update_branch_details_service(ResponseBean responseBean, Branch_Details inputData);
	public void v1nic_delete_branch_details_service(ResponseBean responseBean, Branch_Details data);
	
	
	public void v1nic_v1nic_get_hdc_amount_service(ResponseBean responseBean);


}
