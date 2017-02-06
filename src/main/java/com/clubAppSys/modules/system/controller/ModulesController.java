package com.clubAppSys.modules.system.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clubAppSys.common.ConstantInfo;
import com.clubAppSys.common.base.BaseDTO;
import com.clubAppSys.modules.club.DTO.ClubUsersDTO;
import com.clubAppSys.modules.club.service.ClubUsersService;
import com.clubAppSys.modules.system.model.Modules;
import com.clubAppSys.modules.system.service.ModulesService;
import com.clubAppSys.modules.user.model.Users;
import com.clubAppSys.utils.SpringContextHolder;

@Controller
@RequestMapping("/modules")
public class ModulesController {

	@Autowired(required = false)
	private ModulesService modulesService;

	@ResponseBody
	@RequestMapping(value = "/getUserModuleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private BaseDTO<Modules> getUserModuleList(HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute(
				ConstantInfo.CURRENT_USER);

		ClubUsersService clubUserservice = SpringContextHolder
				.getBean("ClubUsersService");

		// 获取用户加入的社团
		List<ClubUsersDTO> userClubs = clubUserservice.selectClubByUser(
				user.getId(), ConstantInfo.CLUBUSERS_ALLOW);

		HashSet<Modules> modules = new HashSet<>();

		// 根据获取用户加入社团的角色获取对应的模块
		for (ClubUsersDTO clubUser : userClubs) {
			modules.addAll(modulesService.getModulesByTypeId(clubUser
					.getRoleId()));
		}
		int sysRoleId = user.getRoleId();
		// 根据获取用户系统角色获取对应的模块
		modules.addAll(modulesService.getModulesByTypeId(sysRoleId));

		BaseDTO<Modules> result = new BaseDTO<Modules>();
		if (null != modules && modules.size() != 0) {
			result.setSuccess(true);
			result.setList(new ArrayList<>(modules));
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getModuleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private BaseDTO<Modules> getModuleList(HttpServletRequest request) {

		List<Modules> modules = modulesService.getModulesList();

		BaseDTO<Modules> result = new BaseDTO<Modules>();
		if (null != modules && modules.size() != 0) {
			result.setSuccess(true);
			result.setList(modules);
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/addModule", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private BaseDTO<Modules> addModule(Modules module) {
		boolean success = modulesService.addModule(module);
		BaseDTO<Modules> result = new BaseDTO<Modules>();
		if (success) {
			result.setSuccess(true);
		} else {
			result.setMsg("该角色已存在");
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteModule", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private BaseDTO<Modules> deleteModule(Modules module) {
		boolean success = modulesService.deleteModule(module);
		BaseDTO<Modules> result = new BaseDTO<Modules>();
		if (success) {
			result.setSuccess(true);
		} else {
			result.setMsg("删除角色失败");
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/editModule", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private BaseDTO<Modules> editModule(Modules module) {

		boolean success = modulesService.editModule(module);

		BaseDTO<Modules> result = new BaseDTO<Modules>();
		if (success) {
			result.setSuccess(true);
		} else {
			result.setMsg("添加角色失败");
		}
		return result;
	}

}
