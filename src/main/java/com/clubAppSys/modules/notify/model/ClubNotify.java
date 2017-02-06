package com.clubAppSys.modules.notify.model;

import org.apache.ibatis.type.Alias;

@Alias("ClubNotify")
public class ClubNotify {

	private int id;

	private String clubName;

	private String userName;

	private int state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "ClubNotify [id=" + id + ", clubName=" + clubName
				+ ", userName=" + userName + ", state=" + state + "]";
	}

}
