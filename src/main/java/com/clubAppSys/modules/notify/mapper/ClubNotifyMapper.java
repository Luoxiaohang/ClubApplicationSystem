package com.clubAppSys.modules.notify.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clubAppSys.modules.notify.model.ClubNotify;

public interface ClubNotifyMapper {

	/**
	 * 根据用户id和社团状态获取社团通知
	 * 
	 * @param userId
	 * @param clubStateAppRefuse
	 * @return
	 */
	List<ClubNotify> getClubNotifyByStateAndUserId(@Param("userId") int userId,
			@Param("state") int state);

	/**
	 * 
	 * @param 获取指定状态的社团通知
	 * @return
	 */
	List<ClubNotify> getClubNotifyByState(int state);

	/**
	 * 获取用户加入和退出社团的通知
	 * 
	 * @param userId
	 * @param clubStateAppRefuse
	 * @return
	 */
	List<ClubNotify> getClubMemnerNotifyByStateAndUserId(
			@Param("userId") int userId, @Param("state") int state);

}
