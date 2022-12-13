package com.nic.ws.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

//import com.nic.ws.spring.cache.CachingMethods;
import com.nic.ws.spring.model.iobean.InputBeanTest;
import com.nic.ws.spring.model.iobean.ResponseBean;
import com.nic.ws.spring.model.iosub.Bank_Details;
import com.nic.ws.spring.model.iosub.Branch_Details;
import com.nic.ws.spring.model.iosub.Employee_Details;
import com.nic.ws.spring.model.iosub.Hdc_Details;
import com.nic.ws.spring.model.iosub.Job_Details;
import com.nic.ws.spring.model.iosub.OutputData_v1nic_bank_details;
import com.nic.ws.spring.model.iosub.OutputData_v1nic_branch_details;
import com.nic.ws.spring.model.iosub.OutputData_v1nic_emp_details;
import com.nic.ws.spring.model.iosub.OutputData_v1nic_get_job_details;
import com.nic.ws.spring.model.iosub.OutputData_v1nic_get_state_details;
import com.nic.ws.spring.model.iosub.OutputData_v1nic_get_user_details;
import com.nic.ws.spring.model.iosub.OutputData_v1nic_hdc_details;
import com.nic.ws.spring.model.iosub.OutputData_v1nic_stu_details;
import com.nic.ws.spring.model.iosub.State_Details;
import com.nic.ws.spring.model.iosub.Student_Details;
import com.nic.ws.spring.model.iosub.User_Details;
import com.nic.ws.spring.store.AbstractDao;
//import com.nic.ws.spring.store.CacheStore;
import com.nic.ws.spring.store.CommonUtility;
import com.nic.ws.spring.store.NCAbstractDao;
import com.nic.ws.spring.store.PropStore;

@Repository

public class MasterDaoImpl implements MasterDao {

	private static final Logger logger = LoggerFactory.getLogger(MasterDaoImpl.class);

	// private static CachingMethods masCacheMethod = CacheStore.masCacheMethod;

	private CommonUtility ComUtil = new CommonUtility();

	// ==============================================================================

	@Override
	public Object get_testDao() {
		// System.out.println("get_testDao");
		logger.info("get_testDao");
		return null;
	}

	@Override
	public Object post_testDao(InputBeanTest inputBean) {
		try {
			// System.out.println("post_testDao");
		} catch (Exception e) {

		}
		return inputBean;
	}

	@Override
	public void v1nic_v1nic_get_emp_names_dao(ResponseBean responseBean) {

		OutputData_v1nic_emp_details outputData = new OutputData_v1nic_emp_details();

		try {
			//AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
			String query = PropStore.SDQ("sql.get_emp_names");
			logger.info("SQL: " + query);
			List<List<String>> TableData = ComUtil.sqlSelectMultiple(NCAbstractDao.NC_ABS_DB1, query);

			ArrayList<Employee_Details> arlEmployee = new ArrayList<Employee_Details>();
			//ArrayList arlempl = new ArrayList();
			
			if (!TableData.isEmpty()) {

				for (List<String> tuple : TableData) {
					Employee_Details obj = new Employee_Details();
					obj.setEmpl_cd(tuple.get(0));
					obj.setF_name(tuple.get(1));
					obj.setM_name(tuple.get(2));
					obj.setL_name(tuple.get(3));
					//obj.setEmpl_name(tuple.get(1));
					obj.setFath_hus_tag(tuple.get(4));
					obj.setFath_hus_name(tuple.get(5));
					obj.setDept_div_cd(tuple.get(6));
					obj.setBirth_dt(tuple.get(10));
					obj.setRetire_dt(tuple.get(11));
					obj.setPerm_addr1(tuple.get(12));
					obj.setPerm_addr2(tuple.get(13));
					obj.setPerm_addr3(tuple.get(14));
					obj.setPin_cd(tuple.get(15));
					obj.setReligion(tuple.get(16));
					obj.setNation_cd(tuple.get(17));
					obj.setIden_mark(tuple.get(18));
					obj.setCat_cd(tuple.get(19));
					obj.setEx_serv(tuple.get(20));
					obj.setMar_stat(tuple.get(21));
					obj.setSex(tuple.get(22));
					obj.setBlood_grp(tuple.get(23));
					obj.setHindi_yn(tuple.get(24));
					obj.setIs_handicap(tuple.get(25));
					obj.setEntry_by(tuple.get(49));
					obj.setEntry_ts(tuple.get(50));
					obj.setModify_by(tuple.get(51));
					obj.setModify_ts(tuple.get(52));
					obj.setHometown(tuple.get(60));
					obj.setDist_cd(tuple.get(61));
					obj.setState_cd(tuple.get(62));
					obj.setEmail_id(tuple.get(70));
					obj.setDepu_org_name(tuple.get(71));
					obj.setMobile_no(tuple.get(72));
					obj.setPhone_no(tuple.get(73));
					obj.setMarriage_dt(tuple.get(74));
					obj.setEmail_id_per(tuple.get(75));
					obj.setMobile_no_alt(tuple.get(76));
					obj.setAadhar_no(tuple.get(81));			

					arlEmployee.add(obj);
				}
				outputData.setEmpDetails(arlEmployee);
				responseBean.setData(outputData);
				responseBean.setStatus("1");
				responseBean.setMessage("All Employees Are Fetched.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("No Employees Are Found.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Employees Fetch System Exception.");
		}
		NCAbstractDao.NC_ABS_DB1.tranMngr.commit(NCAbstractDao.NC_ABS_DB1.tranStatus);
	}

	
	// Get Student Details
	@Override
	public void v1nic_v1nic_get_stu_names_dao(ResponseBean responseBean) {

		OutputData_v1nic_stu_details outputData = new OutputData_v1nic_stu_details();

		try {
			//AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
			String query = PropStore.SDQ("sql.get_stu_names");
			logger.info("SQL: " + query);
			List<List<String>> TableData = ComUtil.sqlSelectMultiple(NCAbstractDao.NC_ABS_DB1, query);

			ArrayList<Student_Details> arlStudent = new ArrayList<Student_Details>();
			//ArrayList arlempl = new ArrayList();
			
			if (!TableData.isEmpty()) {

				for (List<String> tuple : TableData) {
					Student_Details obj = new Student_Details();
					obj.setId(tuple.get(0));
					obj.setName(tuple.get(1));	
					obj.setAge(tuple.get(2));
					obj.setAddress(tuple.get(3));

					arlStudent.add(obj);
				}
				outputData.setStuDetails(arlStudent);
				responseBean.setData(outputData);
				responseBean.setStatus("1");
				responseBean.setMessage("All Students Are Fetched.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("No Students Are Found.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Students Fetch System Exception.");
		}
		//NCAbstractDao.NC_ABS_DB1.tranMngr.commit(NCAbstractDao.NC_ABS_DB1.tranStatus);
	}
	
	// Insert Student Details
	@Override
	public void v1nic_save_stu_details_dao(ResponseBean responseBean, Student_Details inputData) {

		AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
		try {
			String query = PropStore.SDQ("sql.insert_stu_details");
			query = query.replace("@id@", inputData.getId());
			query = query.replace("@name@", inputData.getName());
			query = query.replace("@age@", inputData.getAge());
			query = query.replace("@address@", inputData.getAddress());
			
			logger.info("SQL: " + query);
			int k = ComUtil.sqlInsert(ABS_DB1, query);

			if (k > 0) {
				responseBean.setStatus("1");
				responseBean.setMessage("Student Details Saved Successfully.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("Student Details Save Failure.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Student Details Save System Exception.");
		}
		ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
	}
	
	
	// Update Student Details
	@Override
	public void v1nic_update_stu_details_dao(ResponseBean responseBean, Student_Details inputData) {

		AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
		try {
			String query = PropStore.SDQ("sql.update_stu_details");
			query = query.replace("@id@", inputData.getId());
			query = query.replace("@name@", inputData.getName());
			query = query.replace("@age@", inputData.getAge());
			query = query.replace("@address@", inputData.getAddress());
			
			logger.info("SQL: " + query);
			int k = ComUtil.sqlInsert(ABS_DB1, query);

			if (k > 0) {
				responseBean.setStatus("1");
				responseBean.setMessage("Student Details Update Successfully.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("Student Details Update Failure.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Student Details Update System Exception.");
		}
		ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
	}
	
	
	// Delete Student Details
	@Override
	public void v1nic_delete_stu_details_dao(ResponseBean responseBean, Student_Details inputData) {

		AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
		try {
			String query = PropStore.SDQ("sql.delete_stu_details");
			query = query.replace("@id@", inputData.getId());
			
			logger.info("SQL: " + query);
			int k = ComUtil.sqlInsert(ABS_DB1, query);

			if (k > 0) {
				responseBean.setStatus("1");
				responseBean.setMessage("Student Details Delete Successfully.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("Student Details Delete Failure.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Student Details Delete System Exception.");
		}
		ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
	}
	
	
	// Get Bank Details
	@Override
	public void v1nic_v1nic_get_bank_details_dao(ResponseBean responseBean) {

		OutputData_v1nic_bank_details outputData = new OutputData_v1nic_bank_details();

		try {
			//AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
			String query = PropStore.SDQ("sql.get_bank_details");
			logger.info("SQL: " + query);
			List<List<String>> TableData = ComUtil.sqlSelectMultiple(NCAbstractDao.NC_ABS_DB1, query);

			ArrayList<Bank_Details> arlBankDetails = new ArrayList<Bank_Details>();
			//ArrayList arlempl = new ArrayList();
			
			if (!TableData.isEmpty()) {

				for (List<String> tuple : TableData) {
					Bank_Details obj = new Bank_Details();
				obj.setBank_cd(tuple.get(0));
				obj.setBank_name(tuple.get(1));
				obj.setBank_type(tuple.get(2));
				obj.setEntry_by(tuple.get(3));
			 	obj.setEntry_ts(tuple.get(4).toString());
			    obj.setModify_by(tuple.get(5));
        		// obj.setModify_ts(tuple.get(6).toString());
			   obj.setActive_yn(tuple.get(7));
			   obj.setPcs_bank_cd(tuple.get(8));
					arlBankDetails.add(obj);
				}
				outputData.setBankDetails(arlBankDetails);
				responseBean.setData(outputData);
				responseBean.setStatus("1");
				responseBean.setMessage("All Banks Are Fetched.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("No Banks Are Found.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Banks Fetch System Exception.");
		}
		//NCAbstractDao.NC_ABS_DB1.tranMngr.commit(NCAbstractDao.NC_ABS_DB1.tranStatus);
	}
	
	
	// Insert Bank Details
	@Override
	public void v1nic_insert_bank_details_dao(ResponseBean responseBean, Bank_Details inputData) {

		AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
		try {
			String query = PropStore.SDQ("sql.insert_bank_details");
			query = query.replace("@bank_cd@", inputData.getBank_cd());
		    query = query.replace("@bank_name@", inputData.getBank_name());
		    query = query.replace("@bank_type@", inputData.getBank_type());
     		query = query.replace("@entry_by@", inputData.getEntry_by());
     		query = query.replace("@active_yn@", inputData.getActive_yn());
     		query = query.replace("@pcs_bank_cd@", inputData.getPcs_bank_cd());
	
			logger.info("SQL: " + query);
			int k = ComUtil.sqlInsert(ABS_DB1, query);

			if (k > 0) {
				responseBean.setStatus("1");
				responseBean.setMessage("Bank Details Saved Successfully.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("Bank Details Save Failure.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Bank Details Save System Exception.");
		}
		ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
	}
	
	
	
	// Update Bank Details(Using PUT)
	@Override
	public void v1nic_update_bank_details_dao(ResponseBean responseBean, Bank_Details inputData) {

		AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
		try {
			String query = PropStore.SDQ("sql.update_bank_details");
			query = query.replace("@bank_cd@", inputData.getBank_cd());
		    query = query.replace("@bank_name@", inputData.getBank_name());
		    query = query.replace("@bank_type@", inputData.getBank_type());
     		query = query.replace("@entry_by@", inputData.getEntry_by());
     		query = query.replace("@modify_by@", inputData.getModify_by());
     		query = query.replace("@active_yn@", inputData.getActive_yn());
     		query = query.replace("@pcs_bank_cd@", inputData.getPcs_bank_cd());
			logger.info("SQL: " + query);
			int k = ComUtil.sqlInsert(ABS_DB1, query);

			if (k > 0) {
				responseBean.setStatus("1");
				responseBean.setMessage("Bank Details Update Successfully.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("Bank Details Update Failure.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Bank Details Update System Exception.");
		}
		ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
	}
	
	@Override
	public void v1nic_save_emp_details_dao(ResponseBean responseBean, Employee_Details inputData) {

		AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
		try {
			String query = PropStore.SDQ("sql.insert_emp_details");
			query = query.replace("@empl_cd@", inputData.getEmpl_cd().substring(0, 4));
			query = query.replace("@f_name@", inputData.getF_name());
			query = query.replace("@m_name@", inputData.getM_name());
			query = query.replace("@l_name@", inputData.getL_name());
			query = query.replace("@fath_hus_name@", inputData.getFath_hus_name());
			query = query.replace("@dept_div_cd@", inputData.getDept_div_cd());
			query = query.replace("@birth_dt@", inputData.getBirth_dt());
			query = query.replace("@retire_dt@", inputData.getRetire_dt());
			query = query.replace("@perm_addr1@", inputData.getPerm_addr1());
			query = query.replace("@perm_addr2@", inputData.getPerm_addr2());
			query = query.replace("@perm_addr3@", inputData.getPerm_addr3());
			query = query.replace("@pin_cd@", inputData.getPin_cd());
			query = query.replace("@religion@", inputData.getReligion());
			query = query.replace("@nation_cd@", inputData.getNation_cd());
			query = query.replace("@iden_mark@", inputData.getIden_mark());
			query = query.replace("@cat_cd@", inputData.getCat_cd());
			query = query.replace("@ex_serv@", inputData.getEx_serv());
			query = query.replace("@mar_stat@", inputData.getMar_stat());
			query = query.replace("@sex@", inputData.getSex());
			query = query.replace("@blood_grp@", inputData.getBlood_grp());
			query = query.replace("@hindi_yn@", inputData.getHindi_yn());
			query = query.replace("@is_handicap@", inputData.getIs_handicap());
			query = query.replace("@entry_by@", inputData.getEntry_by());
			query = query.replace("@entry_ts@", inputData.getEntry_ts());
			query = query.replace("@modify_by@", inputData.getModify_by());
			query = query.replace("@modify_ts@", inputData.getModify_ts());
			query = query.replace("@hometown@", inputData.getHometown());
			query = query.replace("@dist_cd@", inputData.getDist_cd());
			query = query.replace("@state_cd@", inputData.getState_cd());
			query = query.replace("@email_id@", inputData.getEmail_id());
			query = query.replace("@depu_org_name@", inputData.getDepu_org_name());
			query = query.replace("@mobile_no@", inputData.getMobile_no());
			query = query.replace("@phone_no@", inputData.getPhone_no());
			query = query.replace("@marriage_dt@", inputData.getMarriage_dt());
			query = query.replace("@email_id_per@", inputData.getEmail_id_per());
			query = query.replace("@mobile_no_alt@", inputData.getMobile_no_alt());
			query = query.replace("@aadhar_no@", inputData.getAadhar_no());
			
			logger.info("SQL: " + query);
			int k = ComUtil.sqlInsert(ABS_DB1, query);

			if (k > 0) {
				responseBean.setStatus("1");
				responseBean.setMessage("Employee Details Saved Successfully.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("Employee Details Save Failure.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Employee Details Save System Exception.");
		}
		ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
	}

	@Override
	public void v1nic_get_emp_details_dao(ResponseBean responseBean, Employee_Details inputData) {

		OutputData_v1nic_emp_details outputData = new OutputData_v1nic_emp_details();

		try {

			//AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
			String query = PropStore.SDQ("sql.get_emp_details");
			query = query.replace("@empl_cd@", inputData.getEmpl_cd());
			logger.info("SQL: " + query);
			List<List<String>> TableData = ComUtil.sqlSelectMultiple(NCAbstractDao.NC_ABS_DB1, query);

			ArrayList<Employee_Details> arlEmployee = new ArrayList<Employee_Details>();
			if (!TableData.isEmpty()) {

				for (List<String> tuple : TableData) {
					Employee_Details obj = new Employee_Details();
					obj.setEmpl_cd(tuple.get(0));
					//obj.setEmpl_name(tuple.get(1));

					arlEmployee.add(obj);
				}
				outputData.setEmpDetails(arlEmployee);
				responseBean.setData(outputData);
				responseBean.setStatus("1");
				responseBean.setMessage("Employee Details Are Fetched.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("Employee Details Are Not Found.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Employee Details Fetch System Exception.");
		}
		NCAbstractDao.NC_ABS_DB1.tranMngr.commit(NCAbstractDao.NC_ABS_DB1.tranStatus);
	}

	@Override
	public void v1nic_get_state_details_dao(ResponseBean responseBean) {
		OutputData_v1nic_get_state_details outputData = new OutputData_v1nic_get_state_details();

		try {
			//AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
			String query = PropStore.SDQ("sql.get_state_details");
			logger.info("SQL: " + query);
			List<List<String>> TableData = ComUtil.sqlSelectMultiple(NCAbstractDao.NC_ABS_DB1, query);

			ArrayList<State_Details> arlState = new ArrayList<State_Details>();
			//ArrayList arlempl = new ArrayList();
			
			if (!TableData.isEmpty()) {

				for (List<String> tuple : TableData) {
					State_Details obj = new State_Details();
					obj.setState_cd(tuple.get(0));
					obj.setEdi_cd(tuple.get(1));
					obj.setSatate_name(tuple.get(2));
					obj.setEntry_by(tuple.get(3));
					obj.setEntry_ts(tuple.get(4));
					obj.setModify_by(tuple.get(5));
					obj.setModify_ts(tuple.get(6));
					
					arlState.add(obj);
				}
				outputData.setStateDetails(arlState);
				responseBean.setData(outputData);
				responseBean.setStatus("1");
				responseBean.setMessage("All Employees Are Fetched.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("No Employees Are Found.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Employees Fetch System Exception.");
		}
		NCAbstractDao.NC_ABS_DB1.tranMngr.commit(NCAbstractDao.NC_ABS_DB1.tranStatus);
		
	}

	@Override
	public void v1nic_get_user_details_dao(ResponseBean responseBean) {
		OutputData_v1nic_get_user_details outputData = new OutputData_v1nic_get_user_details();

		try {
			//AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
			String query = PropStore.SDQ("sql.get_user_details");
			logger.info("SQL: " + query);
			List<List<String>> TableData = ComUtil.sqlSelectMultiple(NCAbstractDao.NC_ABS_DB1, query);

			ArrayList<User_Details> arlUser = new ArrayList<User_Details>();
			//ArrayList arlempl = new ArrayList();
			
			if (!TableData.isEmpty()) {

				for (List<String> tuple : TableData) {
					User_Details obj = new User_Details();
					obj.setUser_cd(tuple.get(0));
					obj.setUser_pwd(tuple.get(1));
					obj.setUser_name(tuple.get(2));
					obj.setBerth_dt(tuple.get(3));
					obj.setJoin_dt(tuple.get(4));
					obj.setFixed_pwd(tuple.get(5));
					obj.setOther(tuple.get(6));
					obj.setLogin_ts(tuple.get(7));
					obj.setUser_pwd_md5(tuple.get(8));
					obj.setEntry_by(tuple.get(9));
					obj.setEntry_ts(tuple.get(10));
					obj.setModify_by(tuple.get(11));
					obj.setModify_ts(tuple.get(12));
					
					arlUser.add(obj);
				}
				outputData.setUserDetails(arlUser);
				responseBean.setData(outputData);
				responseBean.setStatus("1");
				responseBean.setMessage("All Employees Are Fetched.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("No Employees Are Found.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Employees Fetch System Exception.");
		}
		NCAbstractDao.NC_ABS_DB1.tranMngr.commit(NCAbstractDao.NC_ABS_DB1.tranStatus);
		
	}

	@Override
	public void v1nic_get_job_details_dao(ResponseBean responseBean) {
		OutputData_v1nic_get_job_details outputData = new OutputData_v1nic_get_job_details();

		try {
			//AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
			String query = PropStore.SDQ("sql.get_job_details");
			logger.info("SQL: " + query);
			List<List<String>> TableData = ComUtil.sqlSelectMultiple(NCAbstractDao.NC_ABS_DB1, query);
			logger.info(String.valueOf(TableData));
			ArrayList<Job_Details> arlJob1 = new ArrayList<Job_Details>();
			//ArrayList arlempl = new ArrayList();
			
			if (!TableData.isEmpty()) {
 System.out.println("in");
				for (List<String> tuple : TableData) {
					Job_Details obj = new Job_Details();
					 System.out.println(tuple.get(0));
					obj.setC_seq(tuple.get(0));
					obj.setC_req_no(tuple.get(1));
					obj.setC_jd(tuple.get(2));
					obj.setC_jv(tuple.get(3));
					obj.setC_job_bl(tuple.get(4));
				
					arlJob1.add(obj);
				}
				outputData.setJobDetails(arlJob1);
				System.out.println(outputData.getJobDetails());
				responseBean.setData(outputData);
				responseBean.setStatus("1");
				responseBean.setMessage("All Employees Are Fetched.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("No Employees Are Found.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Employees Fetch System Exception.");
		}
		NCAbstractDao.NC_ABS_DB1.tranMngr.commit(NCAbstractDao.NC_ABS_DB1.tranStatus);
		
	}

	@Override
	public void v1nic_insert_job_details_dao(ResponseBean responseBean, Job_Details inputData) {

		AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
		try {
			//for checking exist or not
			String query = PropStore.SDQ("sql.checkCSeq");
			
			query = query.replace("@c_seq@", inputData.getC_seq());
			List<String> tableData=ComUtil.sqlSelectSingle(NCAbstractDao.NC_ABS_DB1, query);
			System.out.println(tableData.get(0));
			int check=Integer.parseInt(tableData.get(0));
			if(check==0) {
			//insert	
				
				query = PropStore.SDQ("sql.insert_job_details");
				query = query.replace("@c_seq@", inputData.getC_seq());
			    query = query.replace("@c_reg_no@", inputData.getC_req_no());
			    query = query.replace("@c_jd@", inputData.getC_jd());
	     		query = query.replace("@c_jv@", inputData.getC_jv());
	     		query = query.replace("@c_job_bl@", inputData.getC_job_bl());
	     		ComUtil.sqlInsert(ABS_DB1, query);
				responseBean.setStatus("1");
				responseBean.setMessage("Job Details insert Successfully.");
			}
			else {
				//update
				query = PropStore.SDQ("sql.update_job_details");
				query = query.replace("@c_seq@", inputData.getC_seq());
			    query = query.replace("@c_reg_no@", inputData.getC_req_no());
			    query = query.replace("@c_jd@", inputData.getC_jd());
	     		query = query.replace("@c_jv@", inputData.getC_jv());
	     		query = query.replace("@c_job_bl@", inputData.getC_job_bl());
	     		ComUtil.sqlUpdate(ABS_DB1, query);
				responseBean.setStatus("1");
				responseBean.setMessage("Job Details update Successfully.");
			}
			
//			query = PropStore.SDQ("sql.insert_job_details");
//			query = query.replace("@c_seq@", inputData.getC_seq());
//		    query = query.replace("@c_reg_no@", inputData.getC_req_no());
//		    query = query.replace("@c_jd@", inputData.getC_jd());
//     		query = query.replace("@c_jv@", inputData.getC_jv());
//     		query = query.replace("@c_job_bl@", inputData.getC_job_bl());
//	
//			logger.info("SQL: " + query);
//			int k = ComUtil.sqlInsert(ABS_DB1, query);
//
//			if (k > 0) {
//				responseBean.setStatus("1");
//				responseBean.setMessage("Bank Details Saved Successfully.");
//			} else {
//				responseBean.setStatus("0");
//				responseBean.setMessage("Bank Details Save Failure.");
//			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Job Details Save System Exception.");
		}
		ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
	}

	@Override
	public void v1nic_update_job_details_dao(ResponseBean responseBean, Job_Details inputdata) {

		AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
		try {
			
			
			String query = PropStore.SDQ("sql.update_job_details");
			query = query.replace("@c_seq@", inputdata.getC_seq());
		    query = query.replace("@c_reg_no@", inputdata.getC_req_no());
		    query = query.replace("@c_jd@", inputdata.getC_jd());
     		query = query.replace("@c_jv@", inputdata.getC_jv());
     		query = query.replace("@c_job_bl@", inputdata.getC_job_bl());
			logger.info("SQL: " + query);
			int k = ComUtil.sqlInsert(ABS_DB1, query);

			if (k > 0) {
				responseBean.setStatus("1");
				responseBean.setMessage("Job Details Update Successfully.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("Job Details Update Failure.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Job Details Update System Exception.");
		}
		ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
	}

	@Override
	public void v1nic_delete_job_details_dao(ResponseBean responseBean, Job_Details inputData) {

		AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
		try {
			String query = PropStore.SDQ("sql.delete_job_details");
			query = query.replace("@c_seq@", inputData.getC_seq());
			
			logger.info("SQL: " + query);
			int k = ComUtil.sqlInsert(ABS_DB1, query);

			if (k > 0) {
				responseBean.setStatus("1");
				responseBean.setMessage("Job Details Delete Successfully.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("Job Details Delete Failure.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Job Details Delete System Exception.");
		}
		ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
	}
	
	
	//----------------------------------------------sandip--------------------------------------------------

	@Override
	public void v1nic_get_branch_details_dao(ResponseBean responseBean) {
		OutputData_v1nic_branch_details outputData = new OutputData_v1nic_branch_details();

			try {
				//AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
				String query = PropStore.SDQ("sql.get_branch_details");
				logger.info("SQL: " + query);
				List<List<String>> TableData = ComUtil.sqlSelectMultiple(NCAbstractDao.NC_ABS_DB1, query);
				logger.info(String.valueOf(TableData));
				ArrayList<Branch_Details> arlBrn1 = new ArrayList<Branch_Details>();
				//ArrayList arlbrn1 = new ArrayList();
				
				if (!TableData.isEmpty()) {
	 System.out.println("in");
					for (List<String> tuple : TableData) {
						Branch_Details obj = new Branch_Details();
						 System.out.println(tuple.get(0));
						obj.setBranch_cd(tuple.get(0));
						obj.setBank_cd(tuple.get(1));
						obj.setBranch_name(tuple.get(2));
						obj.setBranch_id(tuple.get(3));
					
					
						arlBrn1.add(obj);
					}
					outputData.setBranchDetails(arlBrn1);
					System.out.println(outputData.getBranchDetails());
					responseBean.setData(outputData);
					responseBean.setStatus("1");
					responseBean.setMessage("All Branches Are Fetched.");
				} else {
					responseBean.setStatus("0");
					responseBean.setMessage("No Branches Are Found.");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				responseBean.setStatus("0");
				responseBean.setMessage("Branches Fetch System Exception.");
			}
			NCAbstractDao.NC_ABS_DB1.tranMngr.commit(NCAbstractDao.NC_ABS_DB1.tranStatus);
			
		}

	@Override
	public void v1nic_insert_branch_details_dao(ResponseBean responseBean, Branch_Details inputData) {
		

			AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
			try {
				String query = PropStore.SDQ("sql.insert_branch_details");
				query = query.replace("@branch_cd@", inputData.getBranch_cd());
			    query = query.replace("@bank_cd@", inputData.getBank_cd());
			    query = query.replace("@branch_name@", inputData.getBranch_name());
	     		query = query.replace("@branch_id@", inputData.getBranch_id());
	     
		
				logger.info("SQL: " + query);
				int k = ComUtil.sqlInsert(ABS_DB1, query);

				if (k > 0) {
					responseBean.setStatus("1");
					responseBean.setMessage("Branch Details Saved Successfully.");
				} else {
					responseBean.setStatus("0");
					responseBean.setMessage("Branch Details Save Failure.");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				responseBean.setStatus("0");
				responseBean.setMessage("Branch Details Save System Exception.");
			}
			ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
		}

	// Update Bank Details(Using PUT)
	@Override
	public void v1nic_update_branch_details_dao(ResponseBean responseBean, Branch_Details inputData) {

			//AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
			AbstractDao ABS_DB1 = new AbstractDao("DB1");
			try {
				String query = PropStore.SDQ("sql.update_branch_details");
				query = query.replace("@branch_cd@", inputData.getBranch_cd());
			    query = query.replace("@bank_cd@", inputData.getBank_cd());
			    query = query.replace("@branch_name@", inputData.getBranch_name());
	     		query = query.replace("@branch_id@", inputData.getBranch_id());
				logger.info("SQL: " + query);
				int k = ComUtil.sqlInsert(ABS_DB1, query);

				if (k > 0) {
					responseBean.setStatus("1");
					responseBean.setMessage("Branch Details Update Successfully.");
				} else {
					responseBean.setStatus("0");
					responseBean.setMessage("Branch Details Update Failure.");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				responseBean.setStatus("0");
				responseBean.setMessage("Branch Details Update System Exception.");
			}
			ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
		}
	
	
	@Override
	public void v1nic_delete_branch_details_dao(ResponseBean responseBean, Branch_Details inputData) {

		AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
		try {
			String query = PropStore.SDQ("sql.delete_branch_details");
			query = query.replace("@id@", inputData.getBank_cd());
			
			logger.info("SQL: " + query);
			int k = ComUtil.sqlInsert(ABS_DB1, query);

			if (k > 0) {
				responseBean.setStatus("1");
				responseBean.setMessage("Branch Details Delete Successfully.");
			} else {
				responseBean.setStatus("0");
				responseBean.setMessage("Branch Details Delete Failure.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseBean.setStatus("0");
			responseBean.setMessage("Branch Details Delete System Exception.");
		}
		ABS_DB1.tranMngr.commit(ABS_DB1.tranStatus);
	}
	
	
	@Override
	public void v1nic_get_hdc_amount_dao(ResponseBean responseBean) {
		OutputData_v1nic_hdc_details outputData = new OutputData_v1nic_hdc_details();

			try {
				//AbstractDao ABS_DB1 = NCAbstractDao.NC_ABS_DB1;
				String query = PropStore.SDQ("sql.get_hdc_details");
				logger.info("SQL: " + query);
				List<List<String>> TableData = ComUtil.sqlSelectMultiple(NCAbstractDao.NC_ABS_DB1, query);
				logger.info(String.valueOf(TableData));
				ArrayList<Hdc_Details> arlHdc1 = new ArrayList<Hdc_Details>();
				//ArrayList arlbrn1 = new ArrayList();
				
				if (!TableData.isEmpty()) {
	 System.out.println("in");
					for (List<String> tuple : TableData) {
						Hdc_Details obj = new Hdc_Details();
						 System.out.println(tuple.get(0));
						 obj.setFiscal_year(tuple.get(0)); 
						obj.setContainer_count(tuple.get(3));
						obj.setRev_amount(tuple.get(4));
					
					
						arlHdc1.add(obj);
					}
					outputData.setHdcDetails(arlHdc1);
					System.out.println(outputData.getHdcDetails());
					responseBean.setData(outputData);
					responseBean.setStatus("1");
					responseBean.setMessage("All Hdc Data Are Fetched.");
				} else {
					responseBean.setStatus("0");
					responseBean.setMessage("No Hdc Data Are Found.");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				responseBean.setStatus("0");
				responseBean.setMessage("Hdc Fetch System Exception.");
			}
			NCAbstractDao.NC_ABS_DB1.tranMngr.commit(NCAbstractDao.NC_ABS_DB1.tranStatus);
			
		}

		
	
} // END of class MasterDaoImpl
