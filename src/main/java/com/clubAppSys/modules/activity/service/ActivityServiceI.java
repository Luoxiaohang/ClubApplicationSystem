package com.clubAppSys.modules.activity.service;

import java.util.List;

import com.clubAppSys.modules.activity.Dto.ActivitiesDTO;
import com.clubAppSys.modules.activity.model.Activities;
import com.clubAppSys.modules.activity.model.ActivityAndState;
import com.clubAppSys.modules.activity.model.ActivityUsers;

public interface ActivityServiceI {
	// 创建活动
	int createActivity(Activities activities);

	// 修改活动
	void updateActivity(Activities activities);

	// 参与活动
	Activities findJoinedpeopleNum(ActivityUsers activityUsers);

	// 查看活动
	List<ActivitiesDTO> findAllActivities();

	// 已参与活动
	List<Activities> selectByState(ActivityUsers activityUsers);

	// 退出活动
	Activities QuitActivity(ActivityUsers activityUsers);

	List<ActivitiesDTO> getMyActivitis(Integer id);
	
	//查询活动及状态
	List<ActivityAndState> getActivityAndState(Integer id);
	
	//查询指定活动参与人
	List<ActivityAndState> findActivityUser(Activities activities);
	
	//删除活动
	int deleteByPrimaryKey(Activities activities);
	
	//查询活动人通过活动ID
	List<ActivityUsers> selectUsersByActivityId(Activities activities);
	
	int deleteByActivityKey(Activities activities);
}
