package com.clubAppSys.modules.activity.model;

import org.apache.ibatis.type.Alias;

@Alias("ActivityUsers")
public class ActivityUsers {
	private Integer id;//

	private Integer activityId;//活动编号

	private Integer userId;//参与人编号

	private Integer state;//状态

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ActivityUsers [id=" + id + ", activityId=" + activityId
				+ ", userId=" + userId + ", state=" + state + "]";
	}

}