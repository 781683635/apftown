package com.apft.utils;

import java.io.BufferedReader;  
import java.io.File;
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apft.mvc.dao.CommDao;


@Component
public class LogParseAct {
	
	@Autowired
	private CommDao dao;
	
	
	/** input format for dates read in from cvs log */
    private static final SimpleDateFormat INPUT_DATE
        = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    /**
     * New formatter used to parse CVS date/timestamp.
     */
    private static final SimpleDateFormat CVS1129_INPUT_DATE =
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.CHINA);

    static {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        INPUT_DATE.setTimeZone(utc);
        CVS1129_INPUT_DATE.setTimeZone(utc);
    }
	
    private Date parseDate(final String date) {
        try {
            return INPUT_DATE.parse(date);
        } catch (ParseException e) {
            try {
                return CVS1129_INPUT_DATE.parse(date);
            } catch (ParseException e2) {
                throw new IllegalStateException("Invalid date format: " + date);
            }
        }
    }
	
    
    private static String _USER_ACT_LABEL = ") - ";
	
	public void doUserAct(){
		try { 
//			String str = '|'+UUIDGenerator.generate() +'|'+ uid+'|'+ip+'|'+type+'|'+act_data+'|'+act_data2+'|'+act_data3+'|'+os+'|'+rid+'|';
			
			StringBuffer strBufHead = new StringBuffer("INSERT INTO tb_user_act_log(");
			
			StringBuffer strBuf = new StringBuffer("create_time)VALUES");
			
			
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    String yesday = sdf.format(new Date(System.currentTimeMillis()-86400000));

			
			String logUrl = "";
			if(SiteOEM.__DEBUG__())
				logUrl = "D:\\soft\\tomcat\\tomcat7\\logs\\";
			else
				logUrl = "C:\\tomcat7\\logs\\";
		    FileInputStream fis = new FileInputStream(logUrl+"apftown_act_log.log."+yesday); 
		    InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); 
		    BufferedReader br = new BufferedReader(isr); 
		    String line = null; 
		    
		    boolean isFirstRec = true;
		    
		    
/*		    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String cfgLastDate = operateLastTime(null);
		    long oldLastDate = 0;
		    if(!StringUtil.isNull(cfgLastDate))
		    	oldLastDate = sdf.parse(cfgLastDate).getTime();
		    	*/
		    Date newLastDate = null;
		    int doneCnt = 0;
		    
		    while ((line = br.readLine()) != null) {
		    	
//		    	2016-10-24 19:48:56 INFO  [http-bio-8080-exec-1] mylogger2.logInfo(10) - |0:0:0:0:0:0:0:1|maidx.do?|Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36|http://localhost:8080/MiningCircle/maidx.do?null|null|pc|
		    	int idx = line.indexOf(_USER_ACT_LABEL);
		    	if (idx>0){
		    		
		    		int endOfDateIndex = line.indexOf("INFO");
		            String strDate = line.substring(0, endOfDateIndex);

		    		Date dt = sdf.parse(strDate);
		    		newLastDate = dt;  
		    		
//					if(StringUtil.isNotEmpty(oldLastDate) && newLastDate.getTime()>oldLastDate  ){//doneDate > olddoneDate
						
						++doneCnt;
						
						String strData = line.substring(idx+_USER_ACT_LABEL.length() );
			    		String [] strDataCol = strData.split("\\|");

			    		if (isFirstRec){
				    		strBuf.append('(');
			    		}else{
				    		strBuf.append(",(");
			    		}
			    		boolean isFirst = true;
			    		for(String str: strDataCol){
			    			if (isFirst){
			    				isFirst = false;
			    			}else
			    				strBuf.append(',');
			    			
			    			String [] strKV = str.split("`=`");
			    			
			    			if (isFirstRec){
			    				strBufHead.append(strKV[0]);
			    				strBufHead.append(',');
			    			}
			    			
			    			if (strKV.length==1||null == strKV[1]||"".equals(strKV[1])){
			    				strBuf.append("null");
			    			}else{
			    				if(strKV[1].length() > 255)
			    					strKV[1] = strKV[1].substring(255);
			    				if(strKV[0].endsWith("id") && strKV[1].length()>=32)
			    					strKV[1] = strKV[1].substring(0, 32);
			    				
			    				strBuf.append('\'');
			    				strKV[1] = strKV[1].replaceAll("'", "\\'");
			    				strKV[1] = strKV[1].replaceAll("\"", "\\\"");
			    				strKV[1] = strKV[1].replaceAll("\\\\", "\\\\\\\\");
			    				strBuf.append(strKV[1]);
			    				strBuf.append('\'');
			    			}
			    		}
			    		
	    				strBuf.append(",\'");
			    		strBuf.append(strDate);
	    				strBuf.append('\'');
			    		
			    		strBuf.append(')');
			    		
			    		if (isFirstRec)
			    			isFirstRec = false;
			    		
			    		
			    		if ((doneCnt%200)==199){
			    			//operateLastTime( sdf.format(newLastDate));
					    	
					    	
					    	String sql  = strBufHead.append(strBuf.toString()).toString();
					    	int retup = dao.update(sql);
					    	

					    	strBufHead = new StringBuffer("INSERT INTO tb_user_act_log(");
			    			strBuf = new StringBuffer("create_time)VALUES");
			    			isFirstRec = true;			    		
			    		}
			    		
//					}
		    	}
		    	
		    	
		    	
		    	
		    } 
		    
		    
		    if((doneCnt%200)!=0) {
		    	
		    	//operateLastTime( sdf.format(newLastDate));
		    	
		    	
		    	String sql  = strBufHead.append(strBuf.toString()).toString();
		    	int retup = dao.update(sql);
		    }
		} catch (Exception e) { 
		    e.printStackTrace(); 
		}		
		
	}
	
	

	

	public static void main(String [] argv){
		//"D:\\apache-tomcat-7.0.53\\webapps\\MiningCircle\\WEB-INF\\classes\\zl_configure.properties"
		new LogParseAct().doUserAct();
		
	}
	
	
	public static String operateLastTime(String lastTime){

		String retLastTime = "";
		
		StringBuffer sbfContent = new StringBuffer();
		
		String url1 = ZLUtils.getWebRootBasePath()+"/classes/zl_configure.properties";
		File file = new File(url1);//"D:\\apache-tomcat-7.0.53\\webapps\\MiningCircle\\WEB-INF\\classes\\zl_configure.properties");
        BufferedReader reader = null;  
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
                if(null !=  tempString && tempString.contains("user_act_log_modifytime")){
                	String[] tempstr = tempString.split("=");
                	
                	//write
                	if(!StringUtil.isNull(lastTime)){
                		
                		sbfContent.append(tempstr[0] + "=" + lastTime);  
                		
                		byte bt[] = new byte[1024];  
                        bt = lastTime.getBytes();
                		FileOutputStream fos = new FileOutputStream(file);  
                        try {  
                            
                        	fos.write(tempString.replaceAll(tempString,sbfContent.toString()).getBytes());
                        	
                            fos.close();  
                        } catch (IOException e) {  
                            e.printStackTrace();  
                        }  
                	}else{
                		
                		// read
                		if(tempstr.length>=1 && !StringUtil.isNull(tempstr[1]))
                			retLastTime = tempstr[1];
                	}
                }else{
                	sbfContent.append(tempString+"\n");
                }
                line++;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
		return retLastTime;
	}
	
	
	
}




