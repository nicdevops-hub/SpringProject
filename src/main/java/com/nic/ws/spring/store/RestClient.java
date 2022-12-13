package com.nic.ws.spring.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;




public class RestClient {

 // private String server = "http://10.173.45.202:8080/niceinvoicews/";
  private String server = "";
  private RestTemplate rest;
  private HttpHeaders headers;
  private HttpStatus status;
  
  private static final Logger logger = LoggerFactory.getLogger(RestClient.class);
  private CommonUtility ComUtil = new CommonUtility();

  public RestClient() {
    this.rest = new RestTemplate();
    this.headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
   // headers.add("Accept", "*/*");
    headers.add("Accept", "application/json");
  }
  
  public RestClient(String server_base_url) {
	    this.server = server_base_url;
	    this.rest = new RestTemplate();
	    this.headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=UTF-8");
	    headers.add("Accept", "application/json; charset=UTF-8");
  }

  public HttpHeaders getHttpHeaders() {
	  return this.headers;
  }
  
  
  public String convert_Utf_16_to_8(String str_Utf_16){
	  String str_Utf_8=null;
	    try {
	    	byte[] arr1 = str_Utf_16.getBytes("UTF-16");
	    	str_Utf_8= new String(arr1,"UTF-8");
	    	str_Utf_8=str_Utf_8.replace((char)arr1[3]+"","*@*");
	    	str_Utf_8=str_Utf_8.replace(str_Utf_8.charAt(0)+"","*@*");
	    	str_Utf_8=str_Utf_8.replace("*@*", "");
			//System.out.println(str_Utf_8);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	    return str_Utf_8;
  }
  
  
  
  public String do_getRequest(String uri) {
	System.out.println("RestClient get request");
    HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
    ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
    System.out.println(":::::"+responseEntity.getBody());
    String resBody=responseEntity.getBody();
    if(responseEntity.getHeaders().getContentType().toString().contains("16")) {
    	resBody=convert_Utf_16_to_8(resBody);
    }
    logger.info("responseEntity: "+ComUtil.jsonFormat(responseEntity));
    
    this.setStatus(responseEntity.getStatusCode());
    return resBody;
  }
  
  
  public String do_getRequest(String uri, MultiValueMap<String, String> params) {
	  System.out.println("client get request");
    
   // MultiValueMap<String, String> params = new LinkedMultiValueMap();
   // params.add("client_id", "101");
   // params.add("client_secret", "aaaaaa");
    HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
    
    ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
    String resBody=responseEntity.getBody();
    if(responseEntity.getHeaders().getContentType().toString().contains("16")) {
    	resBody=convert_Utf_16_to_8(resBody);
    }
    logger.info("responseEntity: "+ComUtil.jsonFormat(responseEntity));
    
    this.setStatus(responseEntity.getStatusCode());
    return resBody;
  }
  
  

  public String do_postRequest(String uri, String json) {
	System.out.println("client post request");
    HttpEntity<String> requestEntity = new HttpEntity<String>(json, this.headers);
    logger.info("requestEntity: "+ComUtil.jsonFormat(requestEntity));
    System.out.println(server + uri);
    logger.info(server + uri);
    
    ResponseEntity<String> responseEntity;
    try {
    responseEntity = rest.exchange(server + uri, HttpMethod.POST, requestEntity, String.class);
    
    String resBody=responseEntity.getBody();
    if(responseEntity.getHeaders().getContentType().toString().contains("16")) {
    	resBody=convert_Utf_16_to_8(resBody);
    }
    logger.info("responseEntity: "+ComUtil.jsonFormat(responseEntity));
    System.out.println();
    this.setStatus(responseEntity.getStatusCode());
    
    return resBody;
    
    }catch(Exception e) {
    	e.printStackTrace();
    }
    
    return null;
    
  }

 
  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  } 
}