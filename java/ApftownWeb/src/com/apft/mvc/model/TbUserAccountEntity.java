package com.apft.mvc.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 用户账户
 * @author zhangdaihao
 * @date 2014-09-07 10:09:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "tb_user_account", schema = "")
@SuppressWarnings("serial")
public class TbUserAccountEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**id*/
	private java.lang.String userId;
	/**cashBalance*/
	private java.lang.Double cashBalance;
	/**availableBalance*/
	private java.lang.Double availableBalance;
	/**freezingBalance*/
	private java.lang.Double freezingBalance;
	/**investBalance*/
	private java.lang.Double investBalance;
	/**loanBalance*/
	private java.lang.Double loanBalance;
	/**principalAmt*/
	private java.lang.Double principalAmt;
	/**interestAmt*/
	private java.lang.Double interestAmt;
	/**byClaimsAmt*/
	private java.lang.Double byClaimsAmt;
	/**dividendAmt*/
	private java.lang.Double dividendAmt;
	/**otherAmt*/
	private java.lang.Double otherAmt;
	/**feesAmt*/
	private java.lang.Double feesAmt;
	/**rechargeAmt*/
	private java.lang.Double rechargeAmt;
	/**withdrawAmt*/
	private java.lang.Double withdrawAmt;
	/**帐户状态: 1:可用 0 ：锁定*/
	private java.lang.Integer status;
	/**创建时间*/
	private java.util.Date createTime;
	/**创建人id*/
	private java.lang.String creator;
	/**操作时间*/
	private java.util.Date operTime;
	/**操作人id*/
	private java.lang.String operator;
	/**备注*/
	private java.lang.String remark;
	/**平台咨询服务费*/
	private java.lang.Double platformFee;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@Column(name ="ID",nullable=false,length=32)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Column(name ="USER_ID",nullable=false,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  cashBalance
	 */
	@Column(name ="CASH_BALANCE",nullable=true,precision=13,scale=2)
	public java.lang.Double getCashBalance(){
		return this.cashBalance;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  cashBalance
	 */
	public void setCashBalance(java.lang.Double cashBalance){
		this.cashBalance = cashBalance;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  availableBalance
	 */
	@Column(name ="AVAILABLE_BALANCE",nullable=true,precision=13,scale=2)
	public java.lang.Double getAvailableBalance(){
		return this.availableBalance;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  availableBalance
	 */
	public void setAvailableBalance(java.lang.Double availableBalance){
		this.availableBalance = availableBalance;
	}

	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  investBalance
	 */
	@Column(name ="INVEST_BALANCE",nullable=true,precision=13,scale=2)
	public java.lang.Double getInvestBalance(){
		return this.investBalance;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  investBalance
	 */
	public void setInvestBalance(java.lang.Double investBalance){
		this.investBalance = investBalance;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  loanBalance
	 */
	@Column(name ="LOAN_BALANCE",nullable=true,precision=13,scale=2)
	public java.lang.Double getLoanBalance(){
		return this.loanBalance;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  loanBalance
	 */
	public void setLoanBalance(java.lang.Double loanBalance){
		this.loanBalance = loanBalance;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  freezingBalance
	 */
	@Column(name ="FREEZING_BALANCE",nullable=true,precision=13,scale=2)
	public java.lang.Double getFreezingBalance(){
		return this.freezingBalance;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  freezingBalance
	 */
	public void setFreezingBalance(java.lang.Double freezingBalance){
		this.freezingBalance = freezingBalance;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  principalAmt
	 */
	@Column(name ="PRINCIPAL_AMT",nullable=true,precision=13,scale=2)
	public java.lang.Double getPrincipalAmt(){
		return this.principalAmt;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  principalAmt
	 */
	public void setPrincipalAmt(java.lang.Double principalAmt){
		this.principalAmt = principalAmt;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  interestAmt
	 */
	@Column(name ="INTEREST_AMT",nullable=true,precision=13,scale=2)
	public java.lang.Double getInterestAmt(){
		return this.interestAmt;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  interestAmt
	 */
	public void setInterestAmt(java.lang.Double interestAmt){
		this.interestAmt = interestAmt;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  byClaimsAmt
	 */
	@Column(name ="BY_CLAIMS_AMT",nullable=true,precision=13,scale=2)
	public java.lang.Double getByClaimsAmt(){
		return this.byClaimsAmt;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  byClaimsAmt
	 */
	public void setByClaimsAmt(java.lang.Double byClaimsAmt){
		this.byClaimsAmt = byClaimsAmt;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  dividendAmt
	 */
	@Column(name ="DIVIDEND_AMT",nullable=true,precision=13,scale=2)
	public java.lang.Double getDividendAmt(){
		return this.dividendAmt;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  dividendAmt
	 */
	public void setDividendAmt(java.lang.Double dividendAmt){
		this.dividendAmt = dividendAmt;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  otherAmt
	 */
	@Column(name ="OTHER_AMT",nullable=true,precision=13,scale=2)
	public java.lang.Double getOtherAmt(){
		return this.otherAmt;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  otherAmt
	 */
	public void setOtherAmt(java.lang.Double otherAmt){
		this.otherAmt = otherAmt;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  feesAmt
	 */
	@Column(name ="FEES_AMT",nullable=true,precision=13,scale=2)
	public java.lang.Double getFeesAmt(){
		return this.feesAmt;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  feesAmt
	 */
	public void setFeesAmt(java.lang.Double feesAmt){
		this.feesAmt = feesAmt;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  rechargeAmt
	 */
	@Column(name ="RECHARGE_AMT",nullable=true,precision=13,scale=2)
	public java.lang.Double getRechargeAmt(){
		return this.rechargeAmt;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  rechargeAmt
	 */
	public void setRechargeAmt(java.lang.Double rechargeAmt){
		this.rechargeAmt = rechargeAmt;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  withdrawAmt
	 */
	@Column(name ="WITHDRAW_AMT",nullable=true,precision=13,scale=2)
	public java.lang.Double getWithdrawAmt(){
		return this.withdrawAmt;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  withdrawAmt
	 */
	public void setWithdrawAmt(java.lang.Double withdrawAmt){
		this.withdrawAmt = withdrawAmt;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  帐户状态: 1:可用 0 ：锁定
	 */
	@Column(name ="STATUS",nullable=true,precision=3,scale=0)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  帐户状态: 1:可用 0 ：锁定
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=false)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人id
	 */
	@Column(name ="CREATOR",nullable=true,length=32)
	public java.lang.String getCreator(){
		return this.creator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人id
	 */
	public void setCreator(java.lang.String creator){
		this.creator = creator;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  操作时间
	 */
	@Column(name ="OPER_TIME",nullable=true)
	public java.util.Date getOperTime(){
		return this.operTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  操作时间
	 */
	public void setOperTime(java.util.Date operTime){
		this.operTime = operTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作人id
	 */
	@Column(name ="OPERATOR",nullable=true,length=32)
	public java.lang.String getOperator(){
		return this.operator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作人id
	 */
	public void setOperator(java.lang.String operator){
		this.operator = operator;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=200)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  平台咨询服务费
	 */
	@Column(name ="PLATFORM_FEE",nullable=true,precision=13,scale=2)
	public java.lang.Double getPlatformFee(){
		return this.platformFee;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  平台咨询服务费
	 */
	public void setPlatformFee(java.lang.Double platformFee){
		this.platformFee = platformFee;
	}
}
