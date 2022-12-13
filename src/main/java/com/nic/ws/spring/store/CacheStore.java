package com.nic.ws.spring.store;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nic.ws.spring.cache.*;


public class CacheStore {
	
	public  static  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	public static CachingService cachingService;
	public static  CachingMethods masCacheMethod;
	
	
	static {
		ctx.register(EnableCachingConfig.class);
		ctx.refresh();
		CacheStore.cachingService = ctx.getBean(CachingService.class);
		CacheStore.masCacheMethod = ctx.getBean(CachingMethods.class);
	}


	

}
