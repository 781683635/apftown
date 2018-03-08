package com.apft.weixin.pojo;

import java.io.Serializable;

public class TemplateData implements Serializable{
	public String value; 
	public String color;
    public TemplateData(){
    	
    }
    public TemplateData(String value, String color){
    	this.value = value;
    	this.color = color;
    }
    public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
