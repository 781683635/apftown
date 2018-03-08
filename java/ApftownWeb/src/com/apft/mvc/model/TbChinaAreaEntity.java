package com.apft.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**   
 * @Title: Entity
 * @Description: 中国地区
 * @author zhangdaihao
 * @date 2014-09-07 10:04:57
 * @version V1.0   
 *
 */
@Entity
@Table(name = "tb_chinaarea", schema = "")
@SuppressWarnings("serial")
public class TbChinaAreaEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**areaname*/
	private java.lang.String areaname;
	/**parentid*/
	private java.lang.String parentid;
	
	
	private java.lang.String areanameEn;
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@Column(name ="ID",nullable=false,length=12)
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
	 *@return: java.lang.String  areaname
	 */
	@Column(name ="AREANAME",nullable=true,length=50)
	public java.lang.String getAreaname(){
		return this.areaname;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  areaname
	 */
	public void setAreaname(java.lang.String areaname){
		this.areaname = areaname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  parentid
	 */
	@Column(name ="PARENTID",nullable=true,length=12)
	public java.lang.String getParentid(){
		return this.parentid;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  parentid
	 */
	public void setParentid(java.lang.String parentid){
		this.parentid = parentid;
	}
	
	
	
	@Column(name ="areaname_en",nullable=true,length=80)
	public java.lang.String getAreanameEn() {
		return areanameEn;
	}
	public void setAreanameEn(java.lang.String areanameEn) {
		this.areanameEn = areanameEn;
	}
	
	
	
	
	
}
