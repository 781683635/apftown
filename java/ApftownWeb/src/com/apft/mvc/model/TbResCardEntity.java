package com.apft.mvc.model;

public class TbResCardEntity {
	private java.lang.String id;
	private java.lang.String resId;
	private java.lang.Integer sortNo;
	private java.lang.String name;
	private java.lang.String type;
	private java.lang.String content;
	
	private TbResEntity tbResEntity;
	
	public TbResEntity getTbResEntity() {
		return tbResEntity;
	}
	public void setTbResEntity(TbResEntity tbResEntity) {
		this.tbResEntity = tbResEntity;
	}
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	public java.lang.String getResId() {
		return resId;
	}
	public void setResId(java.lang.String resId) {
		this.resId = resId;
	}
	public java.lang.Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(java.lang.Integer sortNo) {
		this.sortNo = sortNo;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getContent() {
		return content;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	
	public TbResCardEntity() {
		super();
	}
	
	
	
}
