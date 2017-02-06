package com.clubAppSys.modules.notify.model;

import org.apache.ibatis.type.Alias;

@Alias("ActivityNotify")
public class ActivityNotify {
	private int id;

	private String theme;

	private String userName;

	private String clubName;

	private int state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	@Override
	public String toString() {
		return "ActivityNotify [id=" + id + ", theme=" + theme + ", userName="
				+ userName + ", clubName=" + clubName + ", state=" + state
				+ "]";
	}

}
