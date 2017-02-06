package com.clubAppSys.modules.club.model;

import java.util.Date;
import org.apache.ibatis.type.Alias;

import com.clubAppSys.modules.school.model.School;

/**
 * 社团实体类， club表对应的实体
 * 
 * @author Charling
 * 
 */

@Alias("Club")
public class Club {
	//社团创建者Id
	private Integer founderId;
	public Integer getFounderId() {
		return founderId;
	}

	public void setFounderId(Integer founderId) {
		this.founderId = founderId;
	}

	//社团id
	private Integer id;
	//社团名字
	private String name;
	//学校id
	private Integer schoolId;
	//社团介绍
	private String description;
	//社团创建时间
	private Date foundTime;
	//社团状态	
	private Integer state;
	
/*	//引入school
	private School school;
	
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFoundTime() {
		return foundTime;
	}

	public void setFoundTime(Date foundTime) {
		this.foundTime = foundTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Club [founderId=" + founderId + ", id=" + id + ", name=" + name
				+ ", schoolId=" + schoolId + ", description=" + description
				+ ", foundTime=" + foundTime + ", state=" + state + "]";
	}

	

}