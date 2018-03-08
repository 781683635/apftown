package com.apft.utils;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.util.LinkedHashMap;  
import java.util.Map;  
import java.util.Set;  

import java.io.FileOutputStream;  
import java.io.OutputStream;  
import java.util.HashMap;  



public class IniUtils {  
  
	private String _filename;
	
    protected Map<String, Map<String, String>> sections = new LinkedHashMap<String, Map<String, String>>();  
    private transient String currentSecion;  
    private transient Map<String, String> current;  
      
//    private String[] notes = new String[]{";", "#", "//"};  
    
    
    
///////////////////////////////////////////////////////////////////////////////
	//static Map<String, Map<String, Object>> iniFile = new HashMap<String, Map<String, Object>>();

	public void save(){
		if (_filename == null)
			return;
		StringBuilder sb = new StringBuilder("");
		for (String st : sections.keySet()) {
			sb.append("[").append(st).append("]").append("\r\n");
			Map<String, String> map = sections.get(st);
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				String v = map.get(key);
				if (null != v)
					sb.append(key).append("=").append(map.get(key)).append("\r\n");
			}
			sb.append("\r\n");
		}
		File file = new File(_filename);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			
			OutputStream os = new FileOutputStream(file);
			os.write(sb.toString().getBytes("utf-8"));
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setValue(String st, String key, String value) {
		Map<String, String> sectionMap = sections.get(st);
		if (sectionMap == null) {
			sectionMap = new HashMap<String, String>();
			sections.put(st, sectionMap);
		}
		sectionMap.put(key, value);
	}

/*
public  Object getValue(String section, String key) {  
Object obj = null;  
Map<String, Object> item = iniFile.get(section);  
if (item != null) {  
obj = item.get(key);  
}  
return obj;  

}  
*/


//////////////////////////////////////////////////////////////////////////////    
    
  
    public IniUtils(String filename) throws IOException {  
    	
    	_filename = filename;
    	
        BufferedReader reader = null;  
        try {  
            File file = new File(filename);  
            if(file.exists() && file.isFile()){  
            	
    			FileInputStream fis = new FileInputStream(file);   
    	    	InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
    	    	reader = new BufferedReader(isr);  

                read(reader);  
                reader.close();  
                reader = null;
            }  
        }finally{  
            if(reader != null){  
                reader.close();  
            }  
        }  
    }  
  
    protected void read(BufferedReader reader) throws IOException {  
        String line;  
        while ((line = reader.readLine()) != null) {  
            parseLine(line);  
        }  
    }  
    
    protected void newSections(String currentSecion) {  
        current = new LinkedHashMap<String, String>();  
        sections.put(currentSecion, current); 
    }    
    
  
    protected void parseLine(String line) {  
        line = line.trim();  
        if (line.matches("\\[.*\\]")) {  
            currentSecion = line.replaceFirst("\\[(.*)\\]", "$1");  
            newSections(currentSecion.trim());
        } else if (line.matches(".*=.*") && !line.startsWith("#")) {  
        	
        	if (current == null){
        		newSections("");
        	}
        	/*
            //去掉注释  
            for(String str : notes){  
                int num = line.indexOf(str);  
                if(num != -1){  
                    line = line.substring(0, num);  
                }  
            }  
            */
            int idx = 0;
            do{
                idx = line.indexOf("=", idx);
                if(idx > 0){
                	if (line.charAt(idx-1)=='\\'){
                		idx++;
                		continue;
                	}
                	String key = line.substring(0,idx);
                	key = key.replaceAll("\\\\=", "\\=");
                    current.put(key, line.substring(idx+1));
                    break;
                }  
            	
            }while(idx>0);
        }  
    }  
  
    
    public String getValue(String name){
    	return getValue("", name);
    }
    
    public String getValue(String section, String name) {  
        Map<String, String> sectionmap = sections.get(section);  
  
        if (sectionmap == null) {  
            return null;  
        }  
  
        String value = sectionmap.get(name);  
        return value;  
    }  
      
    public Set<String> sectionKeys(){  
        return sections.keySet();  
    }  
      
    public Map<String, String> getValues(String section){  
        return sections.get(section);  
    }  
  
    public boolean containsKey(String section, String key) {  
        Map<String, String> m = sections.get(section);  
        if(m != null){  
            return m.get(key) == null;  
        }  
        return false;  
    }  
      
    public Map<String, Map<String, String>> getSections(){  
        return sections;  
    }  
  
  public static void main(String[] args) {  
      try {  
    	  IniUtils r = new IniUtils("E:\\just\\mcweb\\src\\RSS.properties");  
    	  
    	  r.setValue("system", "testkey1", null);
    	  r.setValue("system", "testkey1222", "ttt中文1223");
    	  r.setValue("system22", "testkey333", "");
    	  r.setValue("system212", "testkey333", "testva=l33333");
    	  r.save();
    	  
    	  
 
//          Set<String> keys = r.sectionKeys();  
//          for(String k : keys){  
//              Map<String, String> p = r.getValues(k);  
//              for(Map.Entry<String, String> entry : p.entrySet()){  
//              }  
//          }  
          
            
//          Map<String, Map<String, String>> sections = r.getSections();  
//          new IniWriter("C:/Users/dell/Desktop/bb.ini", sections);  
            
            
      } catch (IOException e) {  
          // TODO Auto-generated catch block  
          e.printStackTrace();  
      }  
  }
}  