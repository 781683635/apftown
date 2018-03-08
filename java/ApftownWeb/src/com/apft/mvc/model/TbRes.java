package com.apft.mvc.model;

import java.util.Date;

public class TbRes {
	private java.lang.String id;
	private java.lang.String title;
	private java.util.Date update_time;
	private java.lang.Double price;
	
	
	public TbRes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TbRes(String id, String title, Date update_time, Double price) {
		super();
		this.id = id;
		this.title = title;
		this.update_time = update_time;
		this.price = price;
	}

	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getTitle() {
		return title;
	}
	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public java.util.Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(java.util.Date update_time) {
		this.update_time = update_time;
	}
	public java.lang.Double getPrice() {
		return price;
	}
	public void setPrice(java.lang.Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TbRes [id=" + id + ", title=" + title + ", update_time="
				+ update_time + ", price=" + price + "]";
	}
	
}
