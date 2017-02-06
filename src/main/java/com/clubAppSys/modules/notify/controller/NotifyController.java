package com.clubAppSys.modules.notify.controller;

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
import com.clubAppSys.modules.notify.model.ActivityNotify;
import com.clubAppSys.modules.notify.model.ClubNotify;
import com.clubAppSys.modules.notify.service.ActivityNotifyService;
import com.clubAppSys.modules.notify.service.ClubNotifyService;
import com.clubAppSys.modules.user.model.Users;

@Controller
@RequestMapping("/Notify")
public class NotifyController {

	@Autowired(required = false)
	ActivityNotifyService activityNotifyService;

	@Autowired(required = false)
	ClubNotifyService clubNotifyService;

	@RequestMapping(value = "/getActivityNotify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<ActivityNotify> getActivityNotify(HttpServletRequest request) {
		BaseDTO<ActivityNotify> result = new BaseDTO<>();
		Users user = (Users) request.getSession().getAttribute(
				ConstantInfo.CURRENT_USER);
		List<ActivityNotify> notifies = activityNotifyService
				.getActivityNotify(user.getId(), user.getRoleId());
		if (notifies != null) {
			result.setList(notifies);
			result.setSuccess(true);
		} else {
			result.setMsg("获取活动通知失败");
		}
		return result;
	}

	@RequestMapping(value = "/getClubNotify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<ClubNotify> getClubNotify(HttpServletRequest request) {
		BaseDTO<ClubNotify> result = new BaseDTO<>();
		Users user = (Users) request.getSession().getAttribute(
				ConstantInfo.CURRENT_USER);

		List<ClubNotify> notifies = clubNotifyService.getNotifyByUserRoleAndId(
				user.getId(), user.getRoleId());

		if (notifies != null) {
			result.setList(notifies);
			result.setSuccess(true);
		} else {
			result.setMsg("获取社团通知失败");
		}
		return result;
	}
}
