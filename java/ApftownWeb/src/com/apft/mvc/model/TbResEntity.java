package com.apft.mvc.model;

import java.util.List;



public class TbResEntity {
	private java.lang.String id;
	private java.lang.Integer no;
	private java.lang.String  catId;
	private java.lang.String type;
	private java.lang.Double originalPrice;
	private java.lang.String title;
	private java.lang.String title2;
	private java.lang.String vfrom;
	private java.lang.String img;
	private java.lang.String resUrl;
	private java.lang.Double price;
	private java.lang.String ext;
	private java.lang.String length;
	private java.lang.String author;
	private java.lang.String director;
	private java.lang.String vdesc;
	private java.lang.String vtext;
	private java.lang.Integer viewTimes;
	private java.util.Date  insertTime;
	private java.lang.String userId;
	private java.lang.Integer status;
	private java.lang.Integer updateStatus;
	private java.util.Date updateTime;
	private java.util.Date verifyDate;
	private java.lang.String verifyUserId;
	private java.lang.String verifyResultMsg;
	private java.lang.Integer ioStatus;
	private java.lang.Double totalQuantity;
	private java.lang.Double soldQuantity;
	private java.lang.String specification;
	private java.lang.String mineral;
	private java.lang.String industry;
	private java.lang.String location;
	private java.lang.Double minQuantity;
	private java.lang.String delivery;
	private java.lang.String payment;
	private java.lang.Integer dealDay;
	private java.util.Date endTime;
	private java.lang.String lang;
	private java.lang.String keyword;
	private java.lang.String sortno;
	private java.lang.Double fee;
	private java.lang.Double searchkey;
	private java.lang.String catEx;
	private java.lang.Integer code;
	private java.lang.String codeName;
	private java.lang.Integer lg;
	private List<TbResCardEntity> tbResCardEntity;
	private List<TbResPropLnEntity> TbResPropLnEntity;
	
	public List<TbResCardEntity> getTbResCardEntity() {
		return tbResCardEntity;
	}
	public void setTbResCardEntity(List<TbResCardEntity> tbResCardEntity) {
		this.tbResCardEntity = tbResCardEntity;
	}
	public TbResEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.Integer getNo() {
		return no;
	}
	public void setNo(java.lang.Integer no) {
		this.no = no;
	}
	public java.lang.String getCatId() {
		return catId;
	}
	public void setCatId(java.lang.String catId) {
		this.catId = catId;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.Double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(java.lang.Double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public java.lang.String getTitle() {
		return title;
	}
	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public java.lang.String getTitle2() {
		return title2;
	}
	public void setTitle2(java.lang.String title2) {
		this.title2 = title2;
	}
	public java.lang.String getVfrom() {
		return vfrom;
	}
	public void setVfrom(java.lang.String vfrom) {
		this.vfrom = vfrom;
	}
	public java.lang.String getImg() {
		return img;
	}
	public void setImg(java.lang.String img) {
		this.img = img;
	}
	public java.lang.String getResUrl() {
		return resUrl;
	}
	public void setResUrl(java.lang.String resUrl) {
		this.resUrl = resUrl;
	}
	public java.lang.Double getPrice() {
		return price;
	}
	public void setPrice(java.lang.Double price) {
		this.price = price;
	}
	public java.lang.String getExt() {
		return ext;
	}
	public void setExt(java.lang.String ext) {
		this.ext = ext;
	}
	public java.lang.String getLength() {
		return length;
	}
	public void setLength(java.lang.String length) {
		this.length = length;
	}
	public java.lang.String getAuthor() {
		return author;
	}
	public void setAuthor(java.lang.String author) {
		this.author = author;
	}
	public java.lang.String getDirector() {
		return director;
	}
	public void setDirector(java.lang.String director) {
		this.director = director;
	}
	public java.lang.String getVdesc() {
		return vdesc;
	}
	public void setVdesc(java.lang.String vdesc) {
		this.vdesc = vdesc;
	}
	public java.lang.String getVtext() {
		return vtext;
	}
	public void setVtext(java.lang.String vtext) {
		this.vtext = vtext;
	}
	public java.lang.Integer getViewTimes() {
		return viewTimes;
	}
	public void setViewTimes(java.lang.Integer viewTimes) {
		this.viewTimes = viewTimes;
	}
	public java.util.Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(java.util.Date insertTime) {
		this.insertTime = insertTime;
	}
	public java.lang.String getUserId() {
		return userId;
	}
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.Integer getUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(java.lang.Integer updateStatus) {
		this.updateStatus = updateStatus;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	public java.util.Date getVerifyDate() {
		return verifyDate;
	}
	public void setVerifyDate(java.util.Date verifyDate) {
		this.verifyDate = verifyDate;
	}
	public java.lang.String getVerifyUserId() {
		return verifyUserId;
	}
	public void setVerifyUserId(java.lang.String verifyUserId) {
		this.verifyUserId = verifyUserId;
	}
	public java.lang.String getVerifyResultMsg() {
		return verifyResultMsg;
	}
	public void setVerifyResultMsg(java.lang.String verifyResultMsg) {
		this.verifyResultMsg = verifyResultMsg;
	}
	public java.lang.Integer getIoStatus() {
		return ioStatus;
	}
	public void setIoStatus(java.lang.Integer ioStatus) {
		this.ioStatus = ioStatus;
	}
	public java.lang.Double getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(java.lang.Double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public java.lang.Double getSoldQuantity() {
		return soldQuantity;
	}
	public void setSoldQuantity(java.lang.Double soldQuantity) {
		this.soldQuantity = soldQuantity;
	}
	public java.lang.String getSpecification() {
		return specification;
	}
	public void setSpecification(java.lang.String specification) {
		this.specification = specification;
	}
	public java.lang.String getMineral() {
		return mineral;
	}
	public void setMineral(java.lang.String mineral) {
		this.mineral = mineral;
	}
	public java.lang.String getIndustry() {
		return industry;
	}
	public void setIndustry(java.lang.String industry) {
		this.industry = industry;
	}
	public java.lang.String getLocation() {
		return location;
	}
	public void setLocation(java.lang.String location) {
		this.location = location;
	}
	public java.lang.Double getMinQuantity() {
		return minQuantity;
	}
	public void setMinQuantity(java.lang.Double minQuantity) {
		this.minQuantity = minQuantity;
	}
	public java.lang.String getDelivery() {
		return delivery;
	}
	public void setDelivery(java.lang.String delivery) {
		this.delivery = delivery;
	}
	public java.lang.String getPayment() {
		return payment;
	}
	public void setPayment(java.lang.String payment) {
		this.payment = payment;
	}
	public java.lang.Integer getDealDay() {
		return dealDay;
	}
	public void setDealDay(java.lang.Integer dealDay) {
		this.dealDay = dealDay;
	}
	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	public java.lang.String getLang() {
		return lang;
	}
	public void setLang(java.lang.String lang) {
		this.lang = lang;
	}
	public java.lang.String getKeyword() {
		return keyword;
	}
	public void setKeyword(java.lang.String keyword) {
		this.keyword = keyword;
	}
	public java.lang.String getSortno() {
		return sortno;
	}
	public void setSortno(java.lang.String sortno) {
		this.sortno = sortno;
	}
	public java.lang.Double getFee() {
		return fee;
	}
	public void setFee(java.lang.Double fee) {
		this.fee = fee;
	}
	public java.lang.Double getSearchkey() {
		return searchkey;
	}
	public void setSearchkey(java.lang.Double searchkey) {
		this.searchkey = searchkey;
	}
	public java.lang.String getCatEx() {
		return catEx;
	}
	public void setCatEx(java.lang.String catEx) {
		this.catEx = catEx;
	}
	public List<TbResPropLnEntity> getTbResPropLnEntity() {
		return TbResPropLnEntity;
	}
	public void setTbResPropLnEntity(List<TbResPropLnEntity> tbResPropLnEntity) {
		TbResPropLnEntity = tbResPropLnEntity;
	}
	public java.lang.Integer getCode() {
		return code;
	}
	public void setCode(java.lang.Integer code) {
		this.code = code;
	}
	public java.lang.String getCodeName() {
		return codeName;
	}
	public void setCodeName(java.lang.String codeName) {
		this.codeName = codeName;
	}
	public java.lang.Integer getLg() {
		return lg;
	}
	public void setLg(java.lang.Integer lg) {
		this.lg = lg;
	}
   
	
}
