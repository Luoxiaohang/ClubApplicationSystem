package com.clubAppSys.modules.activity.model;

import org.apache.ibatis.type.Alias;

@Alias("Activities")
public class Activities {
	private Integer id;//活动编号

	private String theme;//活动主题

	private String foundTime;//创建时间

	private String startTime;//开始时间

	private String endTime;//结束时间

	private int isPublic;//判断非社员能否参加

	private Integer foundUserId;//创建人编号

	private String description;//描述

	private Integer peopleNum;//人数

	private String place;//地点

	private Integer clubId;//所属社团编号

	public String getFoundTime() {
		return foundTime;
	}

	public void setFoundTime(String foundTime) {
		this.foundTime = foundTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

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
		this.theme = theme;
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

	public void setFoundUserId(Integer foundUserId) {
		this.foundUserId = foundUserId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		this.place = place;
	}

	public Integer getClubId() {
		return clubId;
	}

	public void setClubId(Integer clubId) {
		this.clubId = clubId;
	}

	

}