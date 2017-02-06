package com.clubAppSys.modules.club.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clubAppSys.common.ConstantInfo;
import com.clubAppSys.common.base.BaseDTO;
import com.clubAppSys.modules.club.DTO.ClubDTO;
import com.clubAppSys.modules.club.DTO.ClubUsersDTO;
import com.clubAppSys.modules.club.model.ClubUsers;
import com.clubAppSys.modules.club.service.ClubUsersService;
import com.clubAppSys.modules.user.model.Users;

@Controller
public class ClubUsersController {

	@Autowired(required = false)
	private ClubUsersService clubUsersService;
	
	/**
	 * 根据用户id
	 * 查看某用户加入了那些社团且显示职位
	 * @param userId
	 * @return
	 * 
	 */
	@RequestMapping(value = "/clubUsers/showClubByUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private BaseDTO<ClubUsersDTO> showClubByUser(Integer userId ,Integer state) {
		BaseDTO<ClubUsersDTO> result = new BaseDTO<>();
		List<ClubUsersDTO> list = clubUsersService.selectClubByUser(userId,state);
		if (list != null) {
			result.setSuccess(true);
			result.setList(list);
		} else {
			result.setSuccess(false);
			result.setMsg("查询失败");
		}
		return result;
	}

	/**
	 * 更新社团成员状态
	 * 
	 * @param clubUsers
	 * @return
	 */
	@RequestMapping(value = "/clubUsers/updateClubUsersState", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<ClubUsersDTO> updateClubUsersState(ClubUsers clubUsers) {
		boolean success;
		BaseDTO<ClubUsersDTO> result = new BaseDTO<>();
		try {
			success = clubUsersService.updateClubUsersState(clubUsers);
			result.setSuccess(success);
			if (!success) {
				result.setMsg("申请失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * 某一用户申请加入某一社团
	 * 
	 * @param clubUsers
	 * @return
	 */
	@RequestMapping(value = "/clubUsers/UsersAppClub", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<ClubUsersDTO> UsersAppClub(ClubUsers clubUsers) {
		boolean success;
		BaseDTO<ClubUsersDTO> result = new BaseDTO<>();
		clubUsers.setState(ConstantInfo.CLUBUSERS_APP);
		clubUsers.setJoinTime(new Date());
		clubUsers.setRoleId(ConstantInfo.SYSTEM_ROLE_CLUB_MEMBER);
		try {
			success = clubUsersService.usersAppClub(clubUsers);
			result.setSuccess(success);
			if (!success) {
				result.setMsg("申请失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * 根据社团id显示同一社团所有社团
	 * 
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping(value = "/clubUsers/showClubUsersById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<ClubUsersDTO> showClubUsersById(ClubUsers clubUser) {
		BaseDTO<ClubUsersDTO> result = new BaseDTO<>();
		List<ClubUsersDTO> list = clubUsersService.selectAllClubUsers(clubUser);
		if (list != null) {
			result.setSuccess(true);
			result.setList(list);
		} else {
			result.setSuccess(false);
			result.setMsg("查询失败");
		}
		return result;
	}

	/**
	 * 根据社团成员状态获取我管理的社团成员信息
	 * 
	 * @param request  
	 * @return
	 * 
	 */
	@RequestMapping(value = "/clubUsers/showMyMngClubUsersByState", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<ClubUsersDTO> showMyMngClubUsersByClubIdAndState(
			HttpServletRequest request, ClubUsers clubUser) {
		BaseDTO<ClubUsersDTO> result = new BaseDTO<>();
		Users user = (Users) request.getSession().getAttribute(
				ConstantInfo.CURRENT_USER);
		List<ClubUsersDTO> list = clubUsersService
				.showMyMngClubUsersByClubIdAndState(user.getId(), clubUser);
		if (list != null) {
			result.setSuccess(true);
			result.setList(list);
		} else {
			result.setSuccess(false);
			result.setMsg("查询失败");
		}
		return result;
	}

	/**
	 * 根据id搜索社团成员
	 * 
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping(value = "/clubUsers/searchById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ClubUsersDTO searchClubById(HttpServletRequest request) {
		Integer clubId = 1;
		Integer userId = 1;
		ClubUsersDTO clubUsersDTO = null;

		try {
			clubUsersDTO = clubUsersService.selectById(clubId, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clubUsersDTO;
	}

	/**
	 * 根据名字搜索社团成员
	 * 
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping(value = "/clubUsers/searchByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ClubUsersDTO> searchClubByName(HttpServletRequest request) {
		Integer clubId = 3;
		String nickName = "邓";
		List<ClubUsersDTO> list = null;

		try {
			list = clubUsersService.selectByName(clubId, nickName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据id删除社团成员
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/clubUsers/deleteById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<ClubUsers> deleteById(Integer userId,Integer clubId) {

		boolean success;
		BaseDTO<ClubUsers> result = new BaseDTO<>();
		try {
			success = clubUsersService.deleteClubUserById(userId,clubId);
			result.setSuccess(success);
			if (!success) {
				result.setMsg("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * 根据名字删除社团成员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/clubUsers/deleteByName", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<ClubUsersDTO> deleteByName(ClubUsersDTO clubUsersRecord) {

		boolean success;
		BaseDTO<ClubUsersDTO> result = new BaseDTO<>();
		try {
			success = clubUsersService.deleteClubUserByName(clubUsersRecord);
			result.setSuccess(success);
			if (!success) {
				result.setMsg("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * 添加社团成员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/clubUsers/addClubUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int addClubUser(HttpServletRequest request) {

		String nickName = "邓铃";
		String clubName = "钢琴协会";
		String roleName = "社团管理员";
		Date joinTime = new Date();
		int state = 0;

		try {
			clubUsersService.insert(nickName, clubName, roleName, joinTime,
					state);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	/**
	 * 更新社团成员信息
	 * 职位
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/clubUsers/updateClubUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int updateByKey(HttpServletRequest request) {

		String nickName = "邓铃";
		String clubName = "钢琴协会";
		Date joinTime = new Date();
		int state = 0;
		int roleId = 2;

		try {
			clubUsersService.updateByKey(roleId, joinTime, state, clubName,
					nickName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

}
