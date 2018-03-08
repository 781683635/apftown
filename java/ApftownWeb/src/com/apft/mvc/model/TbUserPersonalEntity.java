package com.apft.mvc.model;

import java.math.BigDecimal;

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
@Table(name = "tb_user", schema = "")
@SuppressWarnings("serial")
public class TbUserPersonalEntity implements java.io.Serializable {
	/** id */
	private java.lang.String id;
	/** userName */
	private java.lang.String userName;
	/** userRegMobile */
	private java.lang.String userRegMobile;
	/** userRegEmail */
	private java.lang.String userRegEmail;
	/** userPwd */
	private java.lang.String userPwd;
//	/** userPwd2 */
//	private java.lang.String userPwd2;
	/** creditClassid */
	//user_money
	private java.lang.String userMoney;
	
	private java.lang.String creditClassid;
	/** creditStatus */
	private BigDecimal creditStatus;
	/** userType */
	private java.lang.Integer userType;
	
	
	private java.lang.Integer userCat;
	
//	private java.lang.String userCode; 
//	
	/** userFrom */
	private java.lang.String userFrom;
	
	private Integer userMultiName;
	
	private java.lang.String userRealName;
	
	private java.lang.String userId;
	//[5-8]矿业易合作伙伴会员类型审核
	private java.lang.String userStatus;
	
	//用户介绍
	private java.lang.String userIntroduction;
	
	//user_nick
	private java.lang.String userNick;
	
	private java.lang.String userDealer;
	
	
	private java.lang.String website;
	
	private java.lang.Integer cat;
	
	private java.lang.String role;
	
	@Transient
	public String getRegName(){
		if (userName != null && userName.length()>0){
			return userName;
		}else if (userRegMobile != null && userRegMobile.length()>0){
			return userRegMobile;
		}else if (userRegEmail != null && userRegEmail.length()>0){
			return userRegEmail;
		}
		return id;
	}
	
	@Transient
	public String getSMSName(){
		/*real_name | mobile | user_name | nick | user_reg_mail*/
	
		if(userRealName != null && userRealName.length() > 0){
			return userRealName;
		}else if (userRegMobile != null && userRegMobile.length()>0){
			return userRegMobile;
		}else if (userName != null && userName.length()>0){
			return userName;
		}else if (userNick != null && userNick.length()>0){
			return userNick;
		}else if (userRegEmail != null && userRegEmail.length()>0){
			return userRegEmail;
		}
		return id;
	}
//	
//	  user_real_name varchar(100) COMMENT '真名|企业名',
//	  user_id varchar(100) COMMENT '身份证|企业组织机构代码', 
	/** insertTime */
	private java.util.Date insertTime;
	/** userLastSignin */
	private java.util.Date userLastSignin;
	
	
	
	
    //这里由于数据库触发器的原因，不设置"nullable"属性
//	@Column(name = "USER_CODE")
//	public java.lang.String getUserCode() {
//		return userCode;
//	}
//
//	public void setUserCode(java.lang.String userCode) {
//		this.userCode = userCode;
//	}

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

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String userName
	 */
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String userRegMobile
	 */
	@Column(name = "USER_REG_MOBILE", nullable = true, length = 32)
	public java.lang.String getUserRegMobile() {
		return this.userRegMobile;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String userRegMobile
	 */
	public void setUserRegMobile(java.lang.String userRegMobile) {
		this.userRegMobile = userRegMobile;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String userRegEmail
	 */
	@Column(name = "USER_REG_EMAIL", nullable = true, length = 32)
	public java.lang.String getUserRegEmail() {
		return this.userRegEmail;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String userRegEmail
	 */
	public void setUserRegEmail(java.lang.String userRegEmail) {
		this.userRegEmail = userRegEmail;
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

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String creditClassid
	 */
	@Column(name = "CREDIT_CLASSID", nullable = true, length = 16)
	public java.lang.String getCreditClassid() {
		return this.creditClassid;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String creditClassid
	 */
	public void setCreditClassid(java.lang.String creditClassid) {
		this.creditClassid = creditClassid;
	}

	/**
	 * 方法: 取得BigDecimal
	 * 
	 * @return: BigDecimal creditStatus
	 */
	@Column(name = "CREDIT_STATUS", nullable = true, precision = 32, scale = 0)
	public BigDecimal getCreditStatus() {
		return this.creditStatus;
	}

	/**
	 * 方法: 设置BigDecimal
	 * 
	 * @param: BigDecimal creditStatus
	 */
	public void setCreditStatus(BigDecimal creditStatus) {
		this.creditStatus = creditStatus;
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
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String userFrom
	 */
	@Column(name = "USER_FROM", nullable = true, length = 40)
	public java.lang.String getUserFrom() {
		return this.userFrom;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String userFrom
	 */
	public void setUserFrom(java.lang.String userFrom) {
		this.userFrom = userFrom;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String userFrom
	 */
	@Column(name = "USER_MULTI_NAME", nullable = true, precision = 10, scale = 0)
	public Integer getUserMultiName() {
		return this.userMultiName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String userFrom
	 */
	public void setUserMultiName(Integer userMultiName) {
		this.userMultiName = userMultiName;
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
	
	@Column(name = "user_money", nullable = true, length = 64)
	public java.lang.String getUserMoney() {
		return userMoney;
	} 
	public void setUserMoney(java.lang.String userMoney) {
		this.userMoney = userMoney;
	}

	
	
	@Column(name = "user_cat", nullable = true, precision = 10, scale = 0)
	public java.lang.Integer getUserCat() {
		return userCat;
	}

	public void setUserCat(java.lang.Integer userCat) {
		this.userCat = userCat;
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
	private String userImg;
	
	@Column(name = "user_status", nullable = true, length = 32)
	public java.lang.String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(java.lang.String userStatus) {
		this.userStatus = userStatus;
	}
	@Column(name = "user_introduction", nullable = true, length = 500)
	public java.lang.String getUserIntroduction() {
		return userIntroduction;
	}

	public void setUserIntroduction(java.lang.String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}

	
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String userRegEmail
	 */
	@Column(name = "USER_NICK", nullable = true, length = 80)
	public java.lang.String getUserNick() {
		return this.userNick;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String userRegEmail
	 */
	public void setUserNick(java.lang.String userNick) {
		this.userNick = userNick;
	}
	
	@Column(name="USER_DEALER",nullable=true)
	public java.lang.String getUserDealer(){
		return this.userDealer;
	}
	public void setUserDealer(java.lang.String userDealer){
		this.userDealer=userDealer;
	}

	@Column(name="website",nullable=true)
	public java.lang.String getWebsite(){
		return this.website;
	}
	public void setWebsite(java.lang.String website){
		this.website=website;
	}

	public java.lang.Integer getCat() {
		return cat;
	}

	public void setCat(java.lang.Integer cat) {
		this.cat = cat;
	}

	public java.lang.String getRole() {
		return role;
	}

	public void setRole(java.lang.String role) {
		this.role = role;
	}

	
	
}
