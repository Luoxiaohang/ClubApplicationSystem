package com.clubAppSys.modules.activity.Dto;

import java.util.Date;

public class ActivitiesDTO {
	private Integer id;// 活动编号

	private String theme;// 活动主题

	private String foundTime;// 创建时间

	private String startTime;// 开始时间

	private String endTime;// 结束时间

	private int isPublic;// 判断非社员能否参加

	private Integer foundUserId;// 创建人编号

	private String description;// 描述

	private Integer peopleNum;// 人数

	private String place;// 地点

	private String clubName;// 所属社团编号

	private int state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme == null ? null : theme.trim();
	}

	


	public void setFoundTime(String foundTime) {
		this.foundTime = foundTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}

	public Integer getFoundUserId() {
		return foundUserId;
	}

	public void setFoundUserId(Integer founduserid) {
		this.foundUserId = founduserid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place == null ? null : place.trim();
	}


	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "MyActivitiesDTO [id=" + id + ", theme=" + theme
				+ ", foundTime=" + foundTime + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", isPublic=" + isPublic
				+ ", foundUserId=" + foundUserId + ", description="
				+ description + ", peopleNum=" + peopleNum + ", place=" + place
				+ ", clubName=" + clubName + ", state=" + state + "]";
	}

}