package com.apft.mvc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



/**
 * @Title: Entity
 * @Description: 网站用户表
 * @author zhangdaihao
 * @date 2014-09-27 08:14:00
 * @version V1.0
 * 
 */
@Entity
@Table(name = "tb_user_sub", schema = "")
@SuppressWarnings("serial")
public class TbUserSubEntity implements java.io.Serializable {
	/** id */
	private java.lang.String id;
	
	private java.lang.String userId;
	
	/** userName */
	private java.lang.String userName;
	/** userMobile */
	private java.lang.String userMobile;
	/** userEmail */
	private java.lang.String userEmail;
	/** userPwd */
	private java.lang.String userPwd;


	private java.lang.String userJob;
	private java.lang.String userDeparment;
	
	
	/** userType */
	private java.lang.Integer userType;
	
	private java.lang.String userStatus;
	
	
	private java.lang.String userRealName;
	private java.lang.String userCardImg;
	private java.lang.String userImg;
	
	
	/** userLastSignin */
	private java.util.Date userLastSignin;
	//用户介绍
	private java.lang.String remark;
	
	/** insertTime */
	private java.util.Date insertTime;
	
		
	@Transient
	public String getName(){
		if (userName != null && userName.length()>0){
			return userName;
		}else if (userMobile != null && userMobile.length()>0){
			return userMobile;
		}else if (userEmail != null && userEmail.length()>0){
			return userEmail;
		}
		return id;
	}
	
	

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String id
	 */

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@Column(name = "ID", nullable = false, length = 32)
	public java.lang.String getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String id
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String userName
	 */
	@Column(name = "USER_NAME", nullable = true, length = 32)
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String userMobile
	 */
	@Column(name = "USER_MOBILE", nullable = true, length = 32)
	public java.lang.String getUserMobile() {
		return this.userMobile;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String userMobile
	 */
	public void setUserMobile(java.lang.String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String userEmail
	 */
	@Column(name = "USER__EMAIL", nullable = true, length = 32)
	public java.lang.String getUserEmail() {
		return this.userEmail;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String userEmail
	 */
	public void setUserEmail(java.lang.String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String userPwd
	 */
	@Column(name = "USER_PWD", nullable = true, length = 48)
	public java.lang.String getUserPwd() {
		return this.userPwd;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String userPwd
	 */
	public void setUserPwd(java.lang.String userPwd) {
		this.userPwd = userPwd;
	}

	@Column(name = "USER_JOB")
	public java.lang.String getUserJob() {
		return this.userJob;
	}
	public void setUserJob(java.lang.String userJob) {
		this.userJob = userJob;
	}
	
	@Column(name = "USER_DEPARTMENT" )
	public java.lang.String getUserDeparment() {
		return this.userDeparment;
	}
	public void setUserDeparment(java.lang.String userDeparment) {
		this.userDeparment = userDeparment;
	}
	
	@Column(name = "USER_CART_IMG", nullable = true, length = 32)
	public java.lang.String getUserCardImg() {
		return this.userCardImg;
	}
	public void setUserCardImg(java.lang.String userCardImg) {
		this.userCardImg = userCardImg;
	}
	

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer userType
	 */
	@Column(name = "USER_TYPE", nullable = true, precision = 10, scale = 0)
	public java.lang.Integer getUserType() {
		return this.userType;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer userType
	 */
	public void setUserType(java.lang.Integer userType) {
		this.userType = userType;
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

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date userLastSignin
	 */
	@Column(name = "USER_LAST_SIGNIN", nullable = true)
	public java.util.Date getUserLastSignin() {
		return this.userLastSignin;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date userLastSignin
	 */
	public void setUserLastSignin(java.util.Date userLastSignin) {
		this.userLastSignin = userLastSignin;
	} 



	@Column(name = "user_real_name", nullable = true, length = 32)
	public java.lang.String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(java.lang.String userRealName) {
		this.userRealName = userRealName;
	}

	@Column(name = "user_id", nullable = true, length = 32)
	public java.lang.String getUserId() {
		return userId;
	}

	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	@Column(name = "user_img", nullable = true, length = 500)
	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	
	@Column(name = "user_status", nullable = true, length = 32)
	public java.lang.String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(java.lang.String userStatus) {
		this.userStatus = userStatus;
	}
	@Column(name = "remark", nullable = true, length = 500)
	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	
	
	
	@Override
	public String toString() {
		return "TbUserEntity [id=" + id + ", userName=" + userName + ", userMobile=" + userMobile + ", userEmail=" + userEmail + ", userPwd=" + userPwd 
				+ ", userStatus=" + userStatus + ", userType=" + userType + ", userType=" + userType + ", userRealName=" + userRealName + ", userId=" + userId + ", userStatus=" + userStatus + ", remark=" + remark + ", insertTime=" + insertTime
				+ ", userLastSignin=" + userLastSignin + ", userImg=" + userImg +"]";
	}
	
}
