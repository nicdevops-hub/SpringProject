package com.nic.ws.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.ws.spring.dao.MasterDao;
import com.nic.ws.spring.dao.MasterDaoImpl;
import com.nic.ws.spring.model.iobean.*;
import com.nic.ws.spring.model.iosub.*;

@Service

public class MasterServiceImpl implements MasterService {
	
	@Autowired
	private MasterDao masterDao;

	@Override
	public Object get_testService() {
		return masterDao.get_testDao();
	}

	@Override
	public Object post_testService(InputBeanTest inputbean) {
		return masterDao.post_testDao(inputbean);
	}

	@Override
	public void v1nic_v1nic_get_emp_names_service(ResponseBean responseBean) {
		masterDao.v1nic_v1nic_get_emp_names_dao(responseBean);
	}
	public void v1nic_v1nic_get_stu_names_service(ResponseBean responseBean) {
		masterDao.v1nic_v1nic_get_stu_names_dao(responseBean);
	}

	@Override
	public void v1nic_save_emp_details_service(ResponseBean responseBean, Employee_Details inputData) {
		masterDao.v1nic_save_emp_details_dao(responseBean, inputData);
	}

	@Override
	public void v1nic_get_emp_details_service(ResponseBean responseBean, Employee_Details inputData) {
		masterDao.v1nic_get_emp_details_dao(responseBean, inputData);
	}
    
	@Override
	public void v1nic_save_stu_details_service(ResponseBean responseBean, Student_Details inputData) {
		masterDao.v1nic_save_stu_details_dao(responseBean, inputData);
	}
	@Override
	public void v1nic_update_stu_details_service(ResponseBean responseBean, Student_Details inputData) {
		masterDao.v1nic_update_stu_details_dao(responseBean, inputData);
	}
	@Override
	public void v1nic_delete_stu_details_service(ResponseBean responseBean, Student_Details inputData) {
		masterDao.v1nic_delete_stu_details_dao(responseBean, inputData);
	}
	@Override
	public void v1nic_v1nic_get_bank_details_service(ResponseBean responseBean) {
		masterDao.v1nic_v1nic_get_bank_details_dao(responseBean);
	}
	@Override
	public void v1nic_insert_bank_details_service(ResponseBean responseBean, Bank_Details inputData) {
		masterDao.v1nic_insert_bank_details_dao(responseBean, inputData);
	}
	@Override
	public void v1nic_update_bank_details_service(ResponseBean responseBean, Bank_Details inputData) {
		masterDao.v1nic_update_bank_details_dao(responseBean, inputData);
	}

	@Override
	public void v1nic_v1nic_get_state_details_service(ResponseBean responseBean) {
		
		masterDao.v1nic_get_state_details_dao(responseBean);
	}

	@Override
	public void v1nic_v1nic_get_user_details_service(ResponseBean responseBean) {
		masterDao.v1nic_get_user_details_dao(responseBean);
		
	}

	@Override
	public void v1nic_v1nic_get_job_details_service(ResponseBean responseBean) {
		masterDao.v1nic_get_job_details_dao(responseBean);
		
	}

	@Override
	public void v1nic_insert_job_details_service(ResponseBean responseBean, Job_Details inputData) {
		masterDao.v1nic_insert_job_details_dao(responseBean, inputData);
		
	}

	@Override
	public void v1nic_update_job_details_service(ResponseBean responseBean, Job_Details inputdata) {
		masterDao.v1nic_update_job_details_dao(responseBean, inputdata);
		
	}

	@Override
	public void v1nic_delete_job_details_service(ResponseBean responseBean, Job_Details inputData) {
		masterDao.v1nic_delete_job_details_dao(responseBean, inputData);
		
	}

	@Override
	public void v1nic_v1nic_get_branch_details_service(ResponseBean responseBean) {
		masterDao.v1nic_get_branch_details_dao(responseBean);
		
	}

	@Override
	public void v1nic_insert_branch_details_service(ResponseBean responseBean, Branch_Details inputData) {
		// TODO Auto-generated method stub
		masterDao.v1nic_insert_branch_details_dao(responseBean, inputData);
		
	}

	@Override
	public void v1nic_update_branch_details_service(ResponseBean responseBean, Branch_Details inputData) {
		masterDao.v1nic_update_branch_details_dao(responseBean, inputData);
		
	}
	
	@Override
	public void v1nic_delete_branch_details_service(ResponseBean responseBean, Branch_Details inputData) {
		masterDao.v1nic_delete_branch_details_dao(responseBean, inputData);
	}

	@Override
	public void v1nic_v1nic_get_hdc_amount_service(ResponseBean responseBean) {
		masterDao.v1nic_get_hdc_amount_dao(responseBean);
		
	}


}