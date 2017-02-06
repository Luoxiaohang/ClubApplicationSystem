package com.clubAppSys.modules.activity.model;

import org.apache.ibatis.type.Alias;

@Alias("ActivityAndState")
public class ActivityAndState extends Activities{
	private int state;	//当前用户对应活动状态
	private int userId;	//当前用户Id
	private String userNickName;	//当前用户名称
	private String foundUserName;	//创建人名称
	private String clubName;	//社团名称

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}


	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getFoundUserName() {
		return foundUserName;
	}

	public void setFoundUserName(String foundUserName) {
		this.foundUserName = foundUserName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ActivityAndState [state=" + state + ", userId=" + userId
				+ ", userNickName=" + userNickName +",foundUserName="+ foundUserName + ",id=" + getId() + ", theme=" + getTheme() + ", foundtime="
				+ getFoundTime() + ", starttime=" + getStartTime() + ", endtime="
				+ getEndTime() + ", ispublic=" + getIsPublic() + ", founduserid="
				+ getFoundUserId() + ", description=" + getDescription() + ", peoplenum="
				+ getPeopleNum() + ", place=" + getPlace() + ", clubName=" + getClubName()+"clubId="+getClubId()+"]";
	}



	
	
}