package com.clubAppSys.modules.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubAppSys.modules.activity.Dto.ActivitiesDTO;
import com.clubAppSys.modules.activity.mapper.ActivitiesMapper;
import com.clubAppSys.modules.activity.mapper.ActivityUsersMapper;
import com.clubAppSys.modules.activity.model.Activities;
import com.clubAppSys.modules.activity.model.ActivityAndState;
import com.clubAppSys.modules.activity.model.ActivityUsers;

@Service("ActivityService")
public class ActivityServiceImpl implements ActivityServiceI {

	@Autowired
	private ActivitiesMapper activitiesMapper;

	@Autowired
	private ActivityUsersMapper activityUsersMapper;

	/**
	 * 创建活动
	 */
	@Override
	public int createActivity(Activities activities) {
		// TODO Auto-generated method stub
		int id = activitiesMapper.insert(activities);
		return id;
	}

	/**
	 * 查询活动
	 */
	@Override
	public List<ActivitiesDTO> findAllActivities() {
		return activitiesMapper.selectAll();
	}

	/**
	 * 修改活动
	 */
	@Override
	public void updateActivity(Activities activities) {
		activitiesMapper.updateByPrimaryKey(activities);
	}

	/**
	 * 已参与活动
	 */
	@Override
	public List<Activities> selectByState(ActivityUsers activityUsers) {
		// TODO Auto-generated method stub
		return activitiesMapper.selectByState(activityUsers);
	}

	/**
	 * 参与活动
	 */
	@Override
	public Activities findJoinedpeopleNum(ActivityUsers activityUsers) {
		// TODO Auto-generated method stub
		activityUsersMapper.insert(activityUsers);	//插入新参与者信息
		Activities activities = activityUsersMapper
				.findJoinedpeopleNum(activityUsers);// 查询活动已参与人数
		activitiesMapper.updateNum(activities);// 更新人数
		return activityUsersMapper.findJoinedpeopleNum(activityUsers);
	}

	/**
	 * 退出活动
	 */
	@Override
	public Activities QuitActivity(ActivityUsers activityUsers) {
		// TODO Auto-generated method stub
		activityUsersMapper.deleteUser(activityUsers);//退出活动,将参与者删除
		Activities activities = activityUsersMapper
				.findJoinedpeopleNum(activityUsers);// 查询活动已参与人数
		activitiesMapper.updateNum(activities);// 更新人数
		return activityUsersMapper.findJoinedpeopleNum(activityUsers);
	}

	@Override
	public List<ActivitiesDTO> getMyActivitis(Integer id) {
		List<ActivitiesDTO> list;
		list = activitiesMapper.getMyActivitis(id);
		return list;
	}

	
	/**
	 * 查询活动及对应状态
	 */
	@Override
	public List<ActivityAndState> getActivityAndState(Integer id) {
		// TODO Auto-generated method stub
		return activityUsersMapper.getActivityAndState(id);
	}

	@Override
	public List<ActivityAndState> findActivityUser(Activities activities) {		
		return activityUsersMapper.findActivityUser(activities);
	}

	
	/**
	 * 删除活动
	 */
	@Override
	public int deleteByPrimaryKey(Activities activities) {
		// TODO Auto-generated method stub
		return activitiesMapper.deleteByPrimaryKey(activities);
	}

	/**
	 * 通过活动ID查询所有活动用户
	 */
	@Override
	public List<ActivityUsers> selectUsersByActivityId(Activities activities) {
		
		return activityUsersMapper.selectByActivityKey(activities.getId());
	}

	/**
	 * 删除用户
	 */
	@Override
	public int deleteByActivityKey(Activities activities) {
		
		return activityUsersMapper.deleteByActivityKey(activities);
	}
}
