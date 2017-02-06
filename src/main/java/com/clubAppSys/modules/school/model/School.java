package com.clubAppSys.modules.school.model;

import org.apache.ibatis.type.Alias;

@Alias("School")
public class School {
	private Integer id;

	private String name;

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
		this.name = name == null ? null : name.trim();
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + "]";
	}

}