package com.apft.mvc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @Title: Entity
 * @Description: 网站用户表
 * @author zhangdaihao
 * @date 2014-09-27 08:14:00
 * @version V1.0
 * 
 */
@Entity
@Table(name = "tb_user_email_chk", schema = "")
@SuppressWarnings("serial")
public class TbUserEmailChkEntity implements java.io.Serializable {
	/** id */
	private java.lang.String id;
	
	/** user_id */
	private java.lang.String userId;
	
	private java.lang.Integer userCat;
	
	/** user_name */
	private java.lang.String userName;
	
	
	/** user_email */
	private java.lang.String userEmail;
	
	private java.lang.String userFrom;
	private java.lang.String website;
	private java.lang.String userPwd;
	
	/** act */
	private java.lang.String act;
	
	/** t */
	private java.lang.String t;
	
	/** c */
	private java.lang.String c;
	
	/** status */
	private java.lang.Integer status;
	
	/** insert_time */
	private java.util.Date insertTime;
	
	
	@Id
	//@GeneratedValue(generator = "paymentableGenerator")
	//@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "id",  nullable = false,length = 32)
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	@Column(name = "user_id", length = 32)
	public java.lang.String getUserId() {
		return userId;
	}
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	/**
	 * 方法: 取得java.lang.String
	 * @return: java.lang.String userRegEmail
	 */
	@Column(name = "user_name",nullable=true, length = 32)
	public java.lang.String getUserName() {
		return this.userName;
	}
	/**
	 * 方法: 设置java.lang.String
	 * @param: java.lang.String userRegEmail
	 */
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	
	
	/**
	 * 方法: 取得java.lang.String
	 * @return: java.lang.String userRegEmail
	 */
	@Column(name = "user_email", length = 32)
	public java.lang.String getUserEmail() {
		return this.userEmail;
	}
	/**
	 * 方法: 设置java.lang.String
	 * @param: java.lang.String userRegEmail
	 */
	public void setUserEmail(java.lang.String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
	@Column(name = "user_cat")
	public java.lang.Integer getUserCat() {
		return this.userCat;
	}
	public void setUserCat(java.lang.Integer userCat) {
		this.userCat = userCat;
	}
	
	@Column(name = "user_from")
	public java.lang.String getUserFrom() {
		return this.userFrom;
	}
	public void setUserFrom(java.lang.String userFrom) {
		this.userFrom = userFrom;
	}
	
	@Column(name = "user_pwd")
	public java.lang.String getUserPwd() {
		return this.userPwd;
	}
	public void setUserPwd(java.lang.String userPwd) {
		this.userPwd = userPwd;
	}
	
	@Column(name = "website")
	public java.lang.String getWebsite() {
		return this.website;
	}
	public void setWebsite(java.lang.String website) {
		this.website = website;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Column(name = "act", length = 80)
	public java.lang.String getAct() {
		return this.act;
	}
	public void setAct(java.lang.String act) {
		this.act = act;
	}
	
	@Column(name = "t", length = 100)
	public java.lang.String getT() {
		return this.t;
	}
	public void setT(java.lang.String t) {
		this.t = t;
	}
	
	@Column(name = "c", length = 100)
	public java.lang.String getC() {
		return this.c;
	}
	public void setC(java.lang.String c) {
		this.c = c;
	}
	
	@Column(name = "status", nullable = false)
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	
	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date insertTime
	 */
	@Column(name = "INSERT_TIME", nullable = false)
	public java.util.Date getInsertTime() {
		return this.insertTime;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date insertTime
	 */
	public void setInsertTime(java.util.Date insertTime) {
		this.insertTime = insertTime;
	}

	
}
