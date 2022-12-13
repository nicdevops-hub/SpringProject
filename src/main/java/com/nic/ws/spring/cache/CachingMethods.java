package com.nic.ws.spring.cache;

import java.util.List;
import org.springframework.cache.annotation.Cacheable;

import com.nic.ws.spring.store.AbstractDao;
import com.nic.ws.spring.store.CommonUtility;

public class CachingMethods {

	private CommonUtility ComUtil = new CommonUtility();

	@Cacheable(value = { "method_cache" }, key = "#query")
	public List<String> sqlSelectSingle(AbstractDao ABS_DB, String query) {
		System.out.println("inside Cachable method");
		System.out.println(query);
		List<String> TableData = ABS_DB.jdbcTemplate.query(query, ComUtil.get_dataResultSetRowMapper());
		return TableData;
	}

	@Cacheable(value = { "method_cache" }, key = "#query")
	public List<List<String>> sqlSelectMultiple(AbstractDao ABS_DB, String query) {
		System.out.println("Inside Cacheable method");
		System.out.println(query);
		List<List<String>> TableData = ABS_DB.jdbcTemplate.query(query, ComUtil.get_multi_dataResultSetRowMapper());
		return TableData;
	}
}
