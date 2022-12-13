package com.nic.ws.spring.dao;

import com.nic.ws.spring.model.iobean.*;
import com.nic.ws.spring.model.iosub.*;

public interface MasterDao {

	public Object get_testDao();
	public Object post_testDao(InputBeanTest inputBean);
	public void v1nic_v1nic_get_emp_names_dao(ResponseBean responseBean);
	public void v1nic_save_emp_details_dao(ResponseBean responseBean, Employee_Details inputData);
	public void v1nic_get_emp_details_dao(ResponseBean responseBean, Employee_Details inputData);
	//public void v1nic_get_stu_details_dao(ResponseBean responseBean, Employee_Details inputData);
	void v1nic_v1nic_get_stu_names_dao(ResponseBean responseBean);
	public void v1nic_save_stu_details_dao(ResponseBean responseBean, Student_Details inputData);
	public void v1nic_update_stu_details_dao(ResponseBean responseBean, Student_Details inputData);
	public void v1nic_delete_stu_details_dao(ResponseBean responseBean, Student_Details inputData);
	
	public void v1nic_v1nic_get_bank_details_dao(ResponseBean responseBean);
	public void v1nic_insert_bank_details_dao(ResponseBean responseBean, Bank_Details inputData);
	public void v1nic_update_bank_details_dao(ResponseBean responseBean, Bank_Details inputData);
	public void v1nic_get_state_details_dao(ResponseBean responseBean);
	public void v1nic_get_user_details_dao(ResponseBean responseBean);
	public void v1nic_get_job_details_dao(ResponseBean responseBean);
	public void v1nic_insert_job_details_dao(ResponseBean responseBean, Job_Details inputData);
	public void v1nic_update_job_details_dao(ResponseBean responseBean, Job_Details inputdata);
	public void v1nic_delete_job_details_dao(ResponseBean responseBean, Job_Details inputData);
	public void v1nic_get_branch_details_dao(ResponseBean responseBean);
	public void v1nic_insert_branch_details_dao(ResponseBean responseBean, Branch_Details inputData);
	public void v1nic_update_branch_details_dao(ResponseBean responseBean, Branch_Details inputData);
	public void v1nic_delete_branch_details_dao(ResponseBean responseBean, Branch_Details inputData);
	public void v1nic_get_hdc_amount_dao(ResponseBean responseBean);
} // END of Interface
