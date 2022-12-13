package com.nic.ws.spring.dao;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import com.nic.ws.spring.store.AbstractDao;
import com.nic.ws.spring.store.PropStore;


  


public class MasterDaoCommon {
	
	

	public String getMD5_encryption(String inputString) throws Exception
	{
		String passwordToHash = inputString;
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
		return generatedPassword;
	}
	
	public String agency_code_generate() throws Exception{
		
		
		
		return null;
	}
	
}