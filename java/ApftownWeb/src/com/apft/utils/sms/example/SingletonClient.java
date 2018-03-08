package com.apft.utils.sms.example;


import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;




public class SingletonClient {
	private static Client client=null;
	private SingletonClient(){
	}
	public synchronized static Client getClient(String softwareSerialNo,String key){
		if(client==null){
			try {
				client=new Client(softwareSerialNo,key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	public synchronized static Client getClient(){
		ResourceBundle bundle=PropertyResourceBundle.getBundle("config");
		if(client==null){
			try {
				String a = bundle.getString("softwareSerialNo");
				String b = bundle.getString("key");
				client=new com.apft.utils.sms.example.Client(a,b);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	
	
}
