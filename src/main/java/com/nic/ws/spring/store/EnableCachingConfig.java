package com.nic.ws.spring.store;

import java.util.Arrays;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nic.ws.spring.cache.*;;


@Configuration
@EnableCaching
public class EnableCachingConfig {

	@Bean
    public CacheManager cacheManager() {
		//System.out.println("CacheManager");
       SimpleCacheManager cacheManager = new SimpleCacheManager();
       cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("service_cache"),new ConcurrentMapCache("method_cache")));
       return cacheManager;
    }
	
	@Bean
    public CachingService cachingService() {
		//System.out.println("CachingService");
       return new CachingService();
       
    }
	
	@Bean
	public CachingMethods masterCachingMethods() {
		//System.out.println("CachingMethods");
	       return new CachingMethods();
	}
}