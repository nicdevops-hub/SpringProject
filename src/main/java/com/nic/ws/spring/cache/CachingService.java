package com.nic.ws.spring.cache;


import org.springframework.cache.annotation.Cacheable;

import com.nic.ws.spring.model.iobean.InputBeanTest;
import com.nic.ws.spring.service.MasterService;
import com.nic.ws.spring.service.MasterServiceImpl;


public class CachingService {

	public MasterService masterService = new MasterServiceImpl() ;


	@Cacheable(value = { "service_cache" }, key = "#inputBean.getUser_id()", condition="#inputBean.getUser_id().equals(\"5\")")
	public String getTest(InputBeanTest inputBean) {
		System.out.println("execute Service cache");
		if (inputBean.getUser_id().equals("0")) {
			return "Zero";
		} else {
			return "Non Zero";
		}
	}

	
//	@Cacheable(value = { "service_cache" }, key = "#inputBean.getFirm_like()")
//	public Object v1sd_get_spon_firm_listCS(InputBean_v1sd_get_spon_firm_list inputBean) {
//		System.out.println("Inside cacheable service ----"+inputBean.getFirm_like()); 
//	return masterService.v1sd_get_spon_firm_listService(inputBean);
//	}
	
}
