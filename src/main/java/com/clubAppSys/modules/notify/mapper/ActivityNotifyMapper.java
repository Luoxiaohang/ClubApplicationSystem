package com.clubAppSys.modules.notify.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clubAppSys.modules.notify.model.ActivityNotify;

public interface ActivityNotifyMapper {

	/**
	 * 根据活动状态获取活动通知
	 * 
	 * @param stateActivityCreated
	 * @return
	 */
	List<ActivityNotify> getActivityNotifyByState(Integer state);

	/**
	 * 根据用户Id和状态获取活动通知
	 * 
	 * @param userId
	 * @param stateActivityUserRefuse
	 * @return
	 */
	List<ActivityNotify> getActivityNotifyByStateAndUserId(
			@Param("userId") int userId, @Param("state") int state);
}
