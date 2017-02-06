package com.clubAppSys.modules.school.mapper;

import java.util.List;

import com.clubAppSys.modules.school.model.School;

public interface SchoolMapper {
	int insert(School record);

	List<School> selectAll();
}