package com.clubAppSys.modules.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clubAppSys.common.base.BaseDTO;
import com.clubAppSys.modules.school.model.School;
import com.clubAppSys.modules.school.service.SchoolService;

@Controller
@RequestMapping("/School")
public class SchoolController {
	@Autowired(required = false)
	private SchoolService schoolService;

	@ResponseBody
	@RequestMapping(value = "/getSchoolList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private BaseDTO<School> getChildFunctionList() {
		BaseDTO<School> result = new BaseDTO<>();
		List<School> schools = schoolService.getAllSchool();
		if (schools != null) {
			result.setSuccess(true);
			result.setList(schools);
		} else {
			result.setMsg("查询失败");
		}
		return result;
	}
}
