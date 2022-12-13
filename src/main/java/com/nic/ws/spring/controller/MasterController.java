package com.nic.ws.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nic.ws.spring.cache.CachingService;
import com.nic.ws.spring.model.core.*;
import com.nic.ws.spring.model.iobean.*;
import com.nic.ws.spring.service.MasterService;
//import com.nic.ws.spring.service.MasterServiceImpl;
import com.nic.ws.spring.store.CacheStore;
import com.nic.ws.spring.store.CommonUtility;

@SuppressWarnings("finally")
@Controller
public class MasterController {

	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);

	private CommonUtility ComUtil = new CommonUtility();

	private ObjectMapper mapper = new ObjectMapper();
	double start_time = 0.0;
	double end_time = 0.0;

	@Autowired
	MasterService masterService;

	CachingService cachingService = CacheStore.cachingService;

	public static List<String> service_name = Arrays.asList(
			// --------- SDCODE -----------------------------------
			"/v1nic_item_type_list",
			"/v1nic_item_group_list",
			"/v1nic_item_save",
			"/v1nic_agency_party_type",
			"/v1nic_agency_name",
			"v1nic_agency_state",
			"v1nic_agency_details",
			"v1nic_agency_save",
			"v1nic_agency_update",
			"v1nic_agency_bank",
			"v1nic_group_details",
			"v1nic_group_save",
			"v1nic_group_uppdate",
			"getEmpl_getDetls",
			"/");

	public static List<WS> web_services = new ArrayList<WS>();

	MasterController() {
		for (String ws_name : service_name) {
			WS ws_obj = new WS();
			ws_obj.service = ws_name;
			web_services.add(ws_obj);
		}
	}

	@RequestMapping(value = MasterURIConstants.WEB_SERVICE_RESPONSE, method = RequestMethod.GET, produces = "application/json", headers = {
	"Accept=application/json" })
	public @ResponseBody String web_service_response() {
		logger.info("%%%%%%%%%%% SD - Started WEB_SERVICE_RESPONSE %%%%%%%%%%%");
		start_time = System.currentTimeMillis();
		String output = "<body> <table border='1px' style='border-collapse: collapse;' cellspacing='10' cellpadding='10' > <thead style='margin:10px; font-weight:bold;color:blue'> <tr style='text-align:center;height:30px;'><td>Sl No. </td><td>Service Name </td><td>By </td> <td>Total Request </td> <td>Avg. Response Time</td> </tr> </thead> <tbody >";
		String temp = "<tr style='color:#FF4500' > <td style='text-align:left;' >@sl_no@</td><td style='text-align:left;' >@Service_Name@</td> <td style='text-align:center;' >@By@</td> <td style='text-align:center;'>@Total_Request@</td> <td>@Avg_Response_Time@</td> </tr>";
		String ws_row = "";
		try {
			int count = 0;
			for (WS ws_obj : web_services) {
				if (ws_obj.request > 0) {
					ws_row = temp;
					ws_row = ws_row.replace("@sl_no@", "" + ++count);
					ws_row = ws_row.replace("@Service_Name@", "" + ws_obj.service);
					ws_row = ws_row.replace("@By@", "" + ws_obj.by);
					ws_row = ws_row.replace("@Total_Request@", "" + ws_obj.request);
					ws_row = ws_row.replace("@Avg_Response_Time@", "" + ws_obj.avg_response_time);
					output = output + ws_row;
				}
			}
			if (count == 0) {
				output = output + "<tr><td colspan=5 style='text-align:center;'>Till now no request for any web service</td> </tr>";
			}

			output = output + " </tbody > </table> </body>";

		} catch (Exception e) {
			e.printStackTrace();
		}
		end_time = System.currentTimeMillis();
		logger.info("Turn Around Time: " + ((end_time - start_time) / 1000) + "sec");
		return output;

	}

	// -------------------------------------- Services Against Requested URI
	// ------------------------------------------------------------------------
	// =========================================================================================================================================
	
	
	@RequestMapping(value = MasterURIConstants.GET_TEST, method = RequestMethod.GET, produces = "application/json", headers = { "Accept=application/json" })
	public @ResponseBody Object v1sd_get_test() {
		ComUtil.con_entryLog("SD", "GET_TEST", "");
		Object outputBean = null;
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		ComUtil.con_exitLog("SD", "/get_test");
		return outputBean;
	}

	@RequestMapping(value = MasterURIConstants.POST_TEST, method = RequestMethod.POST, produces = "application/json", headers = { "Accept=application/json" })
	public @ResponseBody Object post_test(@RequestBody String body) {
		ComUtil.con_entryLog("SD", "POST_TEST", body);
		Object outputBean = null;
		try {
			//outputBean = new IrpAuthResBean();
			//outputBean = rc.do_getRequest("test.json");
			outputBean = masterService.post_testService(this.mapper.readValue(body, InputBeanTest.class));
		} catch (Exception e) {
			ComUtil.con_error(e);
		}
		ComUtil.con_exitLog("SD", "/post_test");
		return outputBean;
	}

	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * [SDCODE]
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 
	 */

	@RequestMapping(value = "/report", method = RequestMethod.GET, produces = "application/json", headers = { "Accept=application/json" })
	public String report() {
		ComUtil.con_entryLog( "NIC", "IRPREPORT_START", null);
		return "home";
	}

	@RequestMapping(value = MasterURIConstants.GET_EMP_NAMES, method = RequestMethod.GET, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_get_emp_names() {
		ComUtil.con_entryLog( "NIC", "GET_EMP_NAMES", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			masterService.v1nic_v1nic_get_emp_names_service(responseBean);
		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/getEmpNames");
			return responseBean; 
		}
	}
	@RequestMapping(value = MasterURIConstants.GET_STATE_DETAILS, method = RequestMethod.GET, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_get_state_details() {
		ComUtil.con_entryLog( "NIC", "GET_STATE_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			masterService.v1nic_v1nic_get_state_details_service(responseBean);
		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/getEmpNames");
			return responseBean; 
		}
	}
	
	@RequestMapping(value = MasterURIConstants.GET_USER_DETAILS, method = RequestMethod.GET, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_get_user_details() {
		ComUtil.con_entryLog( "NIC", "GET_USER_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			masterService.v1nic_v1nic_get_user_details_service(responseBean);
		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/getUserDetails");
			return responseBean; 
		}
	}
	
	@RequestMapping(value = MasterURIConstants.GET_JOB_DETAILS, method = RequestMethod.GET, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_get_job_details() {
		ComUtil.con_entryLog( "NIC", "GET_JOB_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			masterService.v1nic_v1nic_get_job_details_service(responseBean);
		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/getJobDetails");
			return responseBean; 
		}
	}
	
	
	
	@RequestMapping(value = MasterURIConstants.GET_STU_NAMES, method = RequestMethod.GET, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_get_student_names() {
		ComUtil.con_entryLog( "NIC", "GET_STU_NAMES", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			masterService.v1nic_v1nic_get_stu_names_service(responseBean);
		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/getStuNames");
			return responseBean; 
		}
	}
	
	@RequestMapping(value = MasterURIConstants.SAVE_STU_DETAILS, method = RequestMethod.POST, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_save_stu_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "SAVE_STU_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_stu_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_stu_details.class);
			masterService.v1nic_save_stu_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/saveStuDetails");
			return responseBean;
		}
	}
	
	@RequestMapping(value = MasterURIConstants.UPDATE_STU_DETAILS, method = RequestMethod.POST, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_update_stu_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "UPDATE_STU_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_stu_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_stu_details.class);
			masterService.v1nic_update_stu_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/updateStuDetails");
			return responseBean;
		}
	}
  
	@RequestMapping(value = MasterURIConstants.DELETE_STU_DETAILS, method = RequestMethod.POST, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_delete_stu_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "DELETE_STU_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_stu_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_stu_details.class);
			masterService.v1nic_delete_stu_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/deleteStuDetails");
			return responseBean;
		}
	}
	
	
	@RequestMapping(value = MasterURIConstants.GET_BANK_DETAILS, method = RequestMethod.GET, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_get_bank_names() {
		ComUtil.con_entryLog( "NIC", "GET_BANK_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			masterService.v1nic_v1nic_get_bank_details_service(responseBean);
		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/getBankDetails");
			return responseBean; 
		}
	}
	
	
	@RequestMapping(value = MasterURIConstants.INSERT_BANK_DETAILS, method = RequestMethod.POST, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_save_bank_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "INSERT_BANK_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_bank_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_bank_details.class);
			masterService.v1nic_insert_bank_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/insertBankDetails");
			return responseBean;
		}
	}
	
	@RequestMapping(value = MasterURIConstants.INSERT_JOB_DETAILS, method = RequestMethod.POST, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_save_job_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "INSERT_JOB_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_job_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_job_details.class);
			masterService.v1nic_insert_job_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/insertJobDetails");
			return responseBean;
		}
	}
	
	@RequestMapping(value = MasterURIConstants.UPDATE_JOB_DETAILS, method = RequestMethod.PUT, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_update_job_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "UPDATE_JOB_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_job_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_job_details.class);
			masterService.v1nic_update_job_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/updateJobDetails");
			return responseBean;
		}
	}
	
	@RequestMapping(value = MasterURIConstants.DELETE_JOB_DETAILS, method = RequestMethod.POST, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_delete_job_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "DELETE_JOB_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_job_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_job_details.class);
			masterService.v1nic_delete_job_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/deleteJobDetails");
			return responseBean;
		}
	}
	
	
	@RequestMapping(value = MasterURIConstants.UPDATE_BANK_DETAILS, method = RequestMethod.PUT, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_update_bank_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "UPDATE_BANK_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_bank_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_bank_details.class);
			masterService.v1nic_update_bank_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/updateBankDetails");
			return responseBean;
		}
	}
	
	@RequestMapping(value = MasterURIConstants.UPDATE_BANK_DETAILS, method = RequestMethod.PATCH, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_update_patch_bank_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "UPDATE_BANK_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_bank_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_bank_details.class);
			masterService.v1nic_update_bank_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/updateBankDetails");
			return responseBean;
		}
	}


	@RequestMapping(value = MasterURIConstants.SAVE_EMP_DETAILS, method = RequestMethod.POST, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_save_emp_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "SAVE_EMP_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_emp_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_emp_details.class);
			masterService.v1nic_save_emp_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/saveEmpDetails");
			return responseBean;
		}
	}

	@RequestMapping(value = MasterURIConstants.GET_EMP_DETAILS, method = RequestMethod.POST, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_get_emp_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "GET_EMP_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_get_emp_details inputBean = this.mapper.readValue(body, InputBean_v1nic_get_emp_details.class);
			masterService.v1nic_get_emp_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/getEmpDetails");
			return responseBean;
		}
	}
	
	//-----------------------------------sandip----------------------------------------------
	@RequestMapping(value = MasterURIConstants.GET_BRANCH_DETAILS, method = RequestMethod.GET, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_get_branch_names() {
		ComUtil.con_entryLog( "NIC", "GET_BRANCH_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			masterService.v1nic_v1nic_get_branch_details_service(responseBean);
		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/getBranchDetails");
			return responseBean; 
		}
	}
	
	
	@RequestMapping(value = MasterURIConstants.INSERT_BRANCH_DETAILS, method = RequestMethod.POST, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_save_branch_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "INSERT_BRANCH_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_branch_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_branch_details.class);
			masterService.v1nic_insert_branch_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/insertBranchDetails");
			return responseBean;
		}
	}
	
	@RequestMapping(value = MasterURIConstants.UPDATE_BRANCH_DETAILS, method = RequestMethod.PUT, produces = "application/json", headers = {"Accept=application/json"})
	public @ResponseBody ResponseBean v1nic_update_branch_details(@RequestBody String body) {
		ComUtil.con_entryLog( "NIC", "UPDATE_BRANCH_DETAILS", "");
		ResponseBean responseBean = new ResponseBean();
		try {
			InputBean_v1nic_save_branch_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_branch_details.class);
			masterService.v1nic_update_branch_details_service(responseBean,inputBean.getData());

		} catch (Exception e) {
			ComUtil.con_error(e);
		} finally {
			ComUtil.con_exitLog("NIC","/updateBranchDetails");
			return responseBean;
		}
	}
	
	
	 
		@RequestMapping(value = MasterURIConstants.DELETE_BRANCH_DETAILS, method = RequestMethod.POST, produces = "application/json", headers = {"Accept=application/json"})
		public @ResponseBody ResponseBean v1nic_delete_branch_details(@RequestBody String body) {
			ComUtil.con_entryLog( "NIC", "DELETE_BRANCH_DETAILS", "");
			ResponseBean responseBean = new ResponseBean();
			try {
				InputBean_v1nic_save_branch_details inputBean = this.mapper.readValue(body, InputBean_v1nic_save_branch_details.class);
				masterService.v1nic_delete_branch_details_service(responseBean,inputBean.getData());

			} catch (Exception e) {
				ComUtil.con_error(e);
			} finally {
				ComUtil.con_exitLog("NIC","/deleteBranchDetails");
				return responseBean;
			}
		}
		
		
		@RequestMapping(value = MasterURIConstants.GET_HDC_DETAILS, method = RequestMethod.GET, produces = "application/json", headers = {"Accept=application/json"})
		public @ResponseBody ResponseBean v1nic_get_hdc_amount() {
			ComUtil.con_entryLog( "NIC", "GET_BRANCH_DETAILS", "");
			ResponseBean responseBean = new ResponseBean();
			try {
				masterService.v1nic_v1nic_get_hdc_amount_service(responseBean);
			} catch (Exception e) {
				ComUtil.con_error(e);
			} finally {
				ComUtil.con_exitLog("NIC","/getBranchDetails");
				return responseBean; 
			}
		}
	

}// end of class MasterController
