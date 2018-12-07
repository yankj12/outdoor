package com.yan.outdoor.schema;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OutdoorActivity")
public class OutdoorActivity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    private String id;
    
	/**
	 * 活动标题
	 */
    private String title;

    /**
     * 年度
     */
    private String year;
    
    /**
     * 活动时间
     */
    private String activityTime;
    
    /**
     * 集合地点
     */
    private String meetAddress;
    
    /**
     * 集合时间
     */
    private String meetTime;
    
    /**
     * 交通方式
     */
    private String trafficType;
    
    /**
     * 难度系数
     */
    private String difficultyIndex;
    
    /**
     * 活动信息及活动行程
     */
    private String info;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 有效状态
     */
    private String validStatus;
    
    /**
     * 插入时间
     */
    private Date insertTime;
    
    /**
     * 修改时间
     */
    private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public String getMeetAddress() {
		return meetAddress;
	}

	public void setMeetAddress(String meetAddress) {
		this.meetAddress = meetAddress;
	}

	public String getMeetTime() {
		return meetTime;
	}

	public void setMeetTime(String meetTime) {
		this.meetTime = meetTime;
	}

	public String getTrafficType() {
		return trafficType;
	}

	public void setTrafficType(String trafficType) {
		this.trafficType = trafficType;
	}

	public String getDifficultyIndex() {
		return difficultyIndex;
	}

	public void setDifficultyIndex(String difficultyIndex) {
		this.difficultyIndex = difficultyIndex;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
