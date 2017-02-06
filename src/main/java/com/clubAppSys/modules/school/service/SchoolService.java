package com.clubAppSys.modules.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clubAppSys.modules.school.mapper.SchoolMapper;
import com.clubAppSys.modules.school.model.School;

@Service("schoolService")
@Transactional
public class SchoolService {

	@Autowired
	SchoolMapper mapper;

	public SchoolMapper getMapper() {
		return this.mapper;
	}

	public List<School> getAllSchool() {
		// TODO Auto-generated method stub
		return getMapper().selectAll();
	}

}
