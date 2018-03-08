package com.apft.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;  
import java.util.Map;  
  
public class MYSQLEncoder {      
      
    private static Map<String,String> referencesMap = new HashMap<String,String>();      
     
    static{      
        referencesMap.put("'","\\'");      
        referencesMap.put("\"","\\\"");      
        referencesMap.put("\\","\\\\");      
              
        referencesMap.put(" ","\\ ");      
        referencesMap.put("\0","\\\0");      
        referencesMap.put("\b","\\\b");      
        referencesMap.put(" ","\\ ");      
        referencesMap.put("\t","\\\t");      
        referencesMap.put("\f","\\\f");      
    }
    
    
    public static String encpdeUtf8Mb4(String s){
    	boolean isMB4 = false;
    	byte b_text[] = s.getBytes();
    	for (int i = 0; i < b_text.length; i++){
    		if((b_text[i] & 0xF8)== 0xF0){
    			for (int j = 0; j < 4; j++) { 
    				b_text[i+j]=0x20; 
    				if (!isMB4) isMB4 = true;
    			}
    			i+=3;
    		}
    	}
    	try {
    		if (isMB4)
    			return new String(b_text, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return s;
    }
    
    
    //escape sql tag with the source code.      
    public static String encode(String source) {      
        if (source == null)      
            return "";      
              
        StringBuffer sbuffer = new StringBuffer(source.length());      
              
        for (int i = 0; i < source.length(); i++) {      
            String c = source.substring(i,i+1);      
                  
                  
            if (referencesMap.get(c) != null) {      
                sbuffer.append(referencesMap.get(c));      
            } else {      
                sbuffer.append(c);      
            }      
        }      
        return sbuffer.toString();      
    }      
          
    public static void main(String[] args){      
    	System.out.print(encpdeUtf8Mb4("A🦋a"));
    	
        String tt = encode("They'are \"ok\". \\a");      
    }      
}    


