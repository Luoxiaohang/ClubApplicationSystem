package com.clubAppSys.modules.club.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 社团成员实体类，club_users表对应的实体
 * @author Charling
 *
 */

@Alias("ClubUsers")
public class ClubUsers {
	//表主键id
	private Integer id;
	//外键用户id
	private Integer userId;
	
	//外键社团id
	private Integer clubId;
	//角色id
	private Integer roleId;

	//加入时间
	private Date joinTime;

	//状态
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getClubId() {
		return clubId;
	}

	public void setClubId(Integer clubId) {
		this.clubId = clubId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ClubUsers [id=" + id + ", userId=" + userId + ", clubId="
				+ clubId + ", roleId=" + roleId + ", joinTime=" + joinTime
				+ ", state=" + state + "]";
	}

}