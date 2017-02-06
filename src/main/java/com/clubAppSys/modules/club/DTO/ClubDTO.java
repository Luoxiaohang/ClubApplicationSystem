package com.clubAppSys.modules.club.DTO;

import java.util.Date;

/**
 * 
 * 页面上显示的社团属性
 * 
 * @author Charling
 * 
 */
public class ClubDTO {
	//创建者名字
	private String founderName;
	public String getFounderName() {
		return founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	//社团创建者Id
	private Integer founderId;
	// 社团id
	private Integer clubId;
	// 社团名字
	private String clubName;
	// 学校名字
	private String schoolName;
	// 社团描述
	private String description;
	// 社团创建时间
	private String foundTime;
	// 社团状态
	private Integer state;
	// 社团人数
	private Integer peopleNum;

	public Integer getClubId() {
		return clubId;
	}

	public void setClubId(Integer clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getFoundTime() {
		return foundTime;
	}

	public void setFoundTime(String foundTime) {
		this.foundTime = foundTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	public Integer getFounderId() {
		return founderId;
	}

	public void setFounderId(Integer founderId) {
		this.founderId = founderId;
	}

	@Override
	public String toString() {
		return "ClubDTO [founderName=" + founderName + ", founderId="
				+ founderId + ", clubId=" + clubId + ", clubName=" + clubName
				+ ", schoolName=" + schoolName + ", description=" + description
				+ ", foundTime=" + foundTime + ", state=" + state
				+ ", peopleNum=" + peopleNum + "]";
	}

	
	

}
