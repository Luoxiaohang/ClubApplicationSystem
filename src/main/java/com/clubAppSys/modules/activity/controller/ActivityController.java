package com.clubAppSys.modules.activity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clubAppSys.common.ConstantInfo;
import com.clubAppSys.common.base.BaseDTO;
import com.clubAppSys.modules.activity.Dto.ActivitiesDTO;
import com.clubAppSys.modules.activity.model.Activities;
import com.clubAppSys.modules.activity.model.ActivityAndState;
import com.clubAppSys.modules.activity.model.ActivityUsers;
import com.clubAppSys.modules.activity.service.ActivityServiceImpl;
import com.clubAppSys.modules.user.model.Users;

@Controller
@RequestMapping("/Activity")
public class ActivityController {

	@Autowired(required = false)
	private ActivityServiceImpl activityServiceImpl;

	/**
	 * 
	 * @Title: findActivity
	 * @Description: 查询活动
	 * @param @return
	 * @return List<Activities>
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/findActivity", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseDTO<ActivitiesDTO> findActivity() {
		BaseDTO<ActivitiesDTO> result = new BaseDTO<>();
		List<ActivitiesDTO> activities = activityServiceImpl
				.findAllActivities();
		if (activities != null) {
			result.setSuccess(true);
			result.setList(activities);
		} else {
			result.setSuccess(false);
			result.setMsg("获取失败");
		}
		return result;
	}
	
	
	
	
	/**
	 * 
	 * @Title: findActivity
	 * @Description: 查询活动 2.0
	 * @param @return
	 * @return BaseDTO<ActivityAndState>
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/findActivityAndState", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseDTO<ActivityAndState> findActivityAndState(HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute(
				ConstantInfo.CURRENT_USER);
		BaseDTO<ActivityAndState> result = new BaseDTO<>();
		List<ActivityAndState> activityAndState = activityServiceImpl.
				getActivityAndState(user.getId());
		if (activityAndState != null) {
			result.setSuccess(true);
			result.setList(activityAndState);
		} else {
			result.setSuccess(false);
			result.setMsg("获取失败");
		}
		
		return result;
	}
	
	

	/**
	 * 
	 * @Title: updateActivity
	 * @Description: 修改活动 ,Activities的id属性必须有
	 * @param @param activities
	 * @return void
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/updateActivity", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateActivity(Activities activities) {
		if(activities.getId() != null && activities.getClubId() != null && activities.getFoundUserId() != null){
			activityServiceImpl.updateActivity(activities);
			return true;
		}else
			return false;
	}

	/**
	 * 
	 * @Title: createActivity
	 * @Description: 创建活动 ,不需要id,自增长
	 * @param
	 * @return BaseDTO<ActivitiesDTO>
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/createActivity",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseDTO<ActivitiesDTO> createActivity(Activities activities,HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute(
				ConstantInfo.CURRENT_USER);
		activities.setFoundUserId(user.getId());
		BaseDTO<ActivitiesDTO> result = new BaseDTO<>();
		activityServiceImpl.createActivity(activities);
		result.setSuccess(true);
		return result;

	}

	/**
	 * 
	 * @Title: findJoinedActivity
	 * @Description: 已参与活动 ,ActivityUsers中的UsersId必须有.State不需要,Sql语句已写死
	 * @param @param activityUsers
	 * @param @return
	 * @return List<Activities>
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getMyActivity", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ActivitiesDTO> getMyActivity(HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute(
				ConstantInfo.CURRENT_USER);
		List<ActivitiesDTO> list = activityServiceImpl.getMyActivitis(user
				.getId());
		return list;
	}

	@ResponseBody
	@RequestMapping("/findJoinedActivity")
	public List<Activities> findJoinedActivity(ActivityUsers activityUsers) {

		List<Activities> list = activityServiceImpl
				.selectByState(activityUsers);
		return list;
	}

	/**
	 * 
	 * @Title: JoinActivity
	 * @Description: 参与活动 ,必须有activityUsers的Userid和Activityid,state
	 * @param
	 * @return void
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("/JoinActivity")
	public void JoinActivity(ActivityUsers activityUsers) {
		Activities activities = activityServiceImpl
				.findJoinedpeopleNum(activityUsers);
	}

	/**
	 * 
	 * @Title: QuitActivitiy
	 * @Description: 退出活动
	 * @param @param activityUsers
	 * @return void
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("/QuitActivitiy")
	public void QuitActivitiy(ActivityUsers activityUsers) {
		Activities activities = activityServiceImpl.QuitActivity(activityUsers);
		
	}
	
	/**
	 * 
	 * @Title: selectUsersByActivitiyId  
	 * @Description: 通过活动ID查找活动参与人 
	 * @param BaseDTO<Activities>    success为true代表该活动有人    
	 * @return void    
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/selectUsersByActivitiyId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseDTO<Activities> selectUsersByActivitiyId(Activities activities){
		
		BaseDTO<Activities> result = new BaseDTO<>();
		List<ActivityUsers> activityUsers = 
				activityServiceImpl.selectUsersByActivityId(activities);
		if(activityUsers.size()!=0){
			result.setSuccess(true);
		}else
			result.setSuccess(false);
		return result;
	}
	
	
	/**
	 * 
	 * @Title: DeleteActivitiy  
	 * @Description: 删除活动 
	 * @param    Activities
	 * @return BaseDTO<Activities>    
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("/DeleteActivitiy")
	public BaseDTO<Activities> DeleteActivitiy(Activities activities){
		BaseDTO<Activities> result = new BaseDTO<>();
		
		//先删除用户
		activityServiceImpl.deleteByActivityKey(activities);
		
		//再删除活动
		activityServiceImpl.deleteByPrimaryKey(activities);
		result.setSuccess(true);
		return result;
	}
	
	/**
	 * 
	 * @Title: findActivityUser  
	 * @Description: 查找指定活动所有参与人 ,需指定活动编号 id
	 * @param   Activities activities  
	 * @return  BaseDTO<ActivityUsers>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/findActivityUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseDTO<ActivityAndState> findActivityUser(Activities activities){
		List<ActivityAndState> activityUsers = activityServiceImpl.findActivityUser(activities);
		BaseDTO<ActivityAndState> result = new BaseDTO<ActivityAndState>();
		result.setList(activityUsers);
		result.setSuccess(true);
		return result;	
	}
}
