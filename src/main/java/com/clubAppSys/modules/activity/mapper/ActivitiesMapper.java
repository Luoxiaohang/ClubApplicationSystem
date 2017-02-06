package com.clubAppSys.modules.activity.mapper;

import java.util.List;

import com.clubAppSys.modules.activity.Dto.ActivitiesDTO;
import com.clubAppSys.modules.activity.model.Activities;
import com.clubAppSys.modules.activity.model.ActivityAndState;
import com.clubAppSys.modules.activity.model.ActivityUsers;

public interface ActivitiesMapper {
	int deleteByPrimaryKey(Activities activities);// 根据id删除活动

	Activities selectByPrimaryKey(Activities activities);// 根据id查询活动
	// int updateByPrimaryKey(Integer id);//根据id修改活动

	/**
	 * 
	 * @Title: insert
	 * @Description: 创建活动
	 * @param @param activities
	 * @param @return
	 * @return int
	 * @throws
	 */
	int insert(Activities activities);

	/**
	 * 
	 * @Title: selectByState
	 * @Description: 已参与活动(根据用户id和state查询)
	 * @param @param activityUsers
	 * @param @return
	 * @return List<Activities>
	 * @throws
	 */
	List<Activities> selectByState(ActivityUsers activityUsers);// 根据参与人id、state查询活动--2.已参与活动

	/**
	 * 
	 * @Title: selectAll
	 * @Description: 查询活动
	 * @param @return
	 * @return List<Activities>
	 * @throws
	 */
	List<ActivitiesDTO> selectAll();// 查询所有活动--3.查询活动

	/**
	 * 
	 * @Title: updateByPrimaryKey
	 * @Description: 修改活动
	 * @param @param activities
	 * @param @return
	 * @return int
	 * @throws
	 */
	int updateByPrimaryKey(Activities activities);// 根据活动id修改活动--4.修改活动

//	int JoinActivityByActivityId(ActivityAndActivityUser activityAndActivityUser);// 根据活动id参与活动--5.参与活动

	int updateNum(Activities activities);// 更新活动参与人数

	int QuitActivityByActivityId(Activities activities);// 根据活动id退出活动--6.退出活动

	/**
	 * 获取用户所有的活动
	 * 
	 * @param userId
	 * @return
	 */
	List<ActivitiesDTO> getMyActivitis(Integer id);
}