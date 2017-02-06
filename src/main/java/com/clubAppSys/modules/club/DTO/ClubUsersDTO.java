package com.clubAppSys.modules.club.DTO;

/**
 * 页面上显示的社团成员信息
 * 
 * @author Charling
 * 
 */
public class ClubUsersDTO {
	// 社团id
	private Integer clubId;
	// 社团成员名字
	private String clubUserName;
	// 学校名字
	private String schoolName;
	// 社团简介
	private String description;
	// 社团创建时间
	private String foundTime;

	// 社团成员id
	private Integer clubUserId;

	// 会员所在的社团名字
	private String clubName;
	// 会员的职位
	private String clubUserPosition;
	// 会员的邮箱
	private String mail;
	// 会员的手机号码
	private String phone;
	// 会员加入社团时间
	private String joinTime;
	// 会员的状态码
	private Integer state;

	private Integer roleId;

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

	public Integer getClubUserId() {
		return clubUserId;
	}

	public void setClubUserId(Integer clubUserId) {
		this.clubUserId = clubUserId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getClubUserName() {
		return clubUserName;
	}

	public Integer getClubId() {
		return clubId;
	}

	public void setClubId(Integer clubId) {
		this.clubId = clubId;
	}

	public void setClubUserName(String clubUserName) {
		this.clubUserName = clubUserName;
	}

	public String getClubUserPosition() {
		return clubUserPosition;
	}

	public void setClubUserPosition(String clubUserPosition) {
		this.clubUserPosition = clubUserPosition;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "ClubUsersDTO [clubId=" + clubId + ", clubUserName="
				+ clubUserName + ", schoolName=" + schoolName
				+ ", description=" + description + ", foundTime=" + foundTime
				+ ", clubUserId=" + clubUserId + ", clubName=" + clubName
				+ ", clubUserPosition=" + clubUserPosition + ", mail=" + mail
				+ ", phone=" + phone + ", joinTime=" + joinTime + ", state="
				+ state + ", roleId=" + roleId + "]";
	}

}
