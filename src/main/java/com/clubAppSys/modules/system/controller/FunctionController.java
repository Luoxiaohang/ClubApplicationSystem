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
import com.clubAppSys.modules.system.model.Function;
import com.clubAppSys.modules.system.service.FunctionService;
import com.clubAppSys.modules.user.model.Users;
import com.clubAppSys.utils.SpringContextHolder;

@Controller
@RequestMapping("/function")
public class FunctionController {

	@Autowired(required = false)
	private FunctionService functionService;

	@ResponseBody
	@RequestMapping(value = "/getModuleFunctionList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private List<Function> getChildFunctionList(HttpServletRequest request,
			int moduleId, boolean root, boolean getAll) {
		HashSet<Function> functions = new HashSet<>();
		if (getAll) {
			functions.addAll(functionService.getFunctionsByModuleId(moduleId));
		} else {
			Users user = (Users) request.getSession().getAttribute(
					ConstantInfo.CURRENT_USER);

			ClubUsersService clubUserservice = SpringContextHolder
					.getBean("ClubUsersService");

			// 获取用户加入的社团
			List<ClubUsersDTO> userClubs = clubUserservice.selectClubByUser(
					user.getId(), ConstantInfo.CLUBUSERS_ALLOW);

			// 根据获取用户加入社团的角色获取对应的功能
			for (ClubUsersDTO clubUser : userClubs) {
				functions.addAll(functionService.getFunctionsByModuleIdRoleId(
						moduleId, clubUser.getRoleId()));
			}

			functions.addAll(functionService.getFunctionsByModuleIdRoleId(
					moduleId, user.getRoleId()));
		}

		ArrayList<Function> result = new ArrayList<>(functions);
		if (root) {
			Function f = new Function();
			f.setId(-1);
			f.setText("无");
			result.add(0, f);
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getFunctionList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private BaseDTO<Function> getFunctionList(HttpServletRequest request) {
		BaseDTO<Function> dto = new BaseDTO<Function>();
		List<Function> functions = functionService.getFunctionList();
		dto.setList(functions);
		dto.setSuccess(true);
		return dto;
	}

	@ResponseBody
	@RequestMapping(value = "/addSysFunction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private BaseDTO<Function> addSysFunction(Function fun) {
		boolean success = functionService.addSysFunction(fun);
		BaseDTO<Function> result = new BaseDTO<>();
		result.setSuccess(success);
		if (!success) {
			result.setMsg("添加失败");
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/delSysFunction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private BaseDTO<Function> deleteSysFunction(Function fun) {
		boolean success;
		BaseDTO<Function> result = new BaseDTO<>();

		try {
			success = functionService.deleteSysFunction(fun);
			result.setSuccess(success);
			if (!success) {
				result.setMsg("删除失败");
			}
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMsg("请先从角色管理中删除角色对应的功能");
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/editSysFunction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private boolean editSysFunction(Function function) {
		boolean success = functionService.editSysFunction(function);
		return success;
	}
}
