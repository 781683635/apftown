package com.apft.utils;

public class ZLStringUtils {

	static public String Str2Json(String s) 
	{ 
		StringBuffer sb = new StringBuffer ();
		for (int i=0;	i<s.length();	i++) {
			char c = s.charAt(i);
			switch (c) {
			case '\"': 
				sb.append("\\\"");
				break;
			case '\\': 
				sb.append("\\\\");
				break;
			case '/': 
				sb.append("\\/");
				break;
			case '\b': 
				sb.append("\\b");
				break;
			case '\f': 
				sb.append("\\f");
				break;
			case '\n': 
				sb.append("\\n");
				break;
			case '\r': 
				sb.append("\\r");
				break;
			case '\t': 
				sb.append("\\t");
				break;
			default: 
				if (c < 0x20)
					sb.append('?');
				else
					sb.append(c);
			} 
		}
		return sb.toString();
	}	
}
