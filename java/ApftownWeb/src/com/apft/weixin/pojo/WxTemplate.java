package com.apft.weixin.pojo;

import java.util.HashMap;
import java.util.Map;
/**
 * 微信模板类
 * 
 */
public class WxTemplate {

	/**
	 * 模板消息id
	 */
	public String template_id;
	/**
	 * 用户openId
	 */
	public String touser;
    /**
     * URL置空，则在发送后，点击模板消息会进入一个空白页面（ios），或无法点击（android）
     */
	public String url;
    /**
     * 标题颜色
     */
	public String topcolor;
    /**
     * 详细内容
     */
	public Map<String,TemplateData> data ;
    /**
     * new的时候触发器生成一个Map存放内容
     * */
    public WxTemplate() {
		data = new HashMap<String, TemplateData>();
	}
    /**
     * 给发送信息的内容属性配键，值，颜色
     * */
    public void put(String Key,Object value,String color){
    	TemplateData comm = new TemplateData();
    	comm.setColor(color);
    	comm.setValue(value+"");
    	data.put(Key, comm);
    }
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopcolor() {
		return topcolor;
	}
	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}
	public Map<String, TemplateData> getData() {
		return data;
	}
	public void setData(Map<String, TemplateData> data) {
		this.data = data;
	}
    
    @Override
    public String toString() {
    	return super.toString();
    }
    
}
