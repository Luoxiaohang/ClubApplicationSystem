package com.clubAppSys.modules.club.controller;

import java.util.Date;
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
import com.clubAppSys.modules.club.DTO.ClubDTO;
import com.clubAppSys.modules.club.model.Club;
import com.clubAppSys.modules.club.service.ClubService;
import com.clubAppSys.modules.user.model.Users;

@Controller
public class ClubController {

	@Autowired(required = false)
	private ClubService clubService;

	/**
	 * 根据用户id 查看某用户加入了那些社团
	 * 
	 * @param userId
	 * @return
	 * 
	 */
	@RequestMapping(value = "/club/showClubByUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private BaseDTO<ClubDTO> showClubByUser(Integer userId, Integer state) {
		BaseDTO<ClubDTO> result = new BaseDTO<>();
		List<ClubDTO> list = clubService.selectClubByUser(userId, state);
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
	 * 显示所有社团
	 * 
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping(value = "/club/showAllClub", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private BaseDTO<ClubDTO> showAllClub(int start, int limit, int state) {
		BaseDTO<ClubDTO> result = new BaseDTO<>();

		int totalCount = clubService.getTotalCount();
		result.setTotalCount(totalCount);

		//System.out.println(start + "   " + limit);
		List<ClubDTO> list = clubService.selectAll(start, limit, state);
		//System.out.println(list.toString());
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
	 * 根据id搜索社团
	 * 
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping(value = "/club/searchClubById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ClubDTO searchClubById(Integer clubId) {
		ClubDTO clubDTO = null;
		// int id = 13;
		try {
			clubDTO = clubService.selectByPrimaryKey(clubId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clubDTO;
	}

	/**
	 * 根据名字搜索社团
	 * 
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping(value = "/club/searchClubByName", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<ClubDTO> searchClubByName(String clubName) {
		// System.out.println("clubName:"+clubName);
		BaseDTO<ClubDTO> result = new BaseDTO<>();
		List<ClubDTO> list = clubService.selectByName(clubName);
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
	 * 根据id删除社团
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/club/deleteClubById ", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<ClubDTO> deleteClubById(Integer clubId) {
		boolean success;
		BaseDTO<ClubDTO> result = new BaseDTO<>();

		try {
			success = clubService.deleteByPrimaryKey(clubId);
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
	 * 根据名字删除社团
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/club/deleteClubByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int deleteClubByName(String clubName) {

		try {
			clubService.deleteByName(clubName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	/**
	 * 添加社团
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/club/addClub", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<Club> addClub(HttpServletRequest request, Club club) {
		boolean success;
		Users users = (Users) request.getSession().getAttribute(
				ConstantInfo.CURRENT_USER);
		club.setFounderId(users.getId());
		club.setFoundTime(new Date());
		club.setSchoolId(users.getSchoolId());
		club.setState(ConstantInfo.CLUB_STATE_APP);
		BaseDTO<Club> result = new BaseDTO<>();
		try {
			success = clubService.insert(club);
			result.setSuccess(success);
			if (!success) {
				result.setMsg("添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 根据id更新社团信息
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/club/updateClubById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<Club> updateById(Club club) {
		System.out.println(club.getId());
		club.setState(ConstantInfo.CLUB_STATE_APP_ALLOW);
		BaseDTO<Club> result = new BaseDTO<>();
		try {
			boolean success = clubService.updateByPrimaryKey(club);
			result.setSuccess(true);
			if (!success) {
				result.setMsg("更新失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("更新失败");
		}
		return result;
	}

	/**
	 * 根据id更新社团状态,用于通过社团创建申请
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/club/updateClubStateById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseDTO<Club> updateClubStateById(Integer state, Integer id) {
		BaseDTO<Club> result = new BaseDTO<>();
		try {
			boolean success = clubService.updateStateByPrimaryKey(state, id);
			result.setSuccess(true);
			if (!success) {
				result.setMsg("更新失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("更新失败");
		}
		return result;
	}

}
