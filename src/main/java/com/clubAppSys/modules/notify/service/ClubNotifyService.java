package com.clubAppSys.modules.notify.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubAppSys.common.ConstantInfo;
import com.clubAppSys.modules.notify.mapper.ClubNotifyMapper;
import com.clubAppSys.modules.notify.model.ClubNotify;

@Service("ClubNotifyService")
public class ClubNotifyService {

	@Autowired
	ClubNotifyMapper mapper;

	public ClubNotifyMapper getMapper() {
		return mapper;
	}

	/**
	 * 根据用户角色获取社团通知
	 * 
	 * 注：
	 * 
	 * 1、所有用户能收到社团取消的通知；
	 * 
	 * 2、系统管理员能收到社团申请的通知;
	 * 
	 * 3、社团管理员能收到加入和退出社团的申请
	 * 
	 * 4、申请社团的用户能收到社团申请失败的通知
	 * 
	 * 5、申请加入社团的用户能收到社团申请加入失败和成功的通知
	 * 
	 * @param roleId
	 * @return
	 */
	public List<ClubNotify> getNotifyByUserRoleAndId(int userId, Integer roleId) {
		List<ClubNotify> result = new ArrayList<>();
		// 获取注销的社团
		List<ClubNotify> cancles = getMapper().getClubNotifyByState(
				ConstantInfo.CLUB_STATE_CANCLE);
		result.addAll(cancles);

		switch (roleId) {
		case ConstantInfo.SYSTEM_ROLE_SYSTEM_MANAGER:
			// 获取处于申请状态的社团
			List<ClubNotify> applys = getMapper().getClubNotifyByState(
					ConstantInfo.CLUB_STATE_APP);
			result.addAll(applys);
			break;
		case ConstantInfo.SYSTEM_ROLE_CLUB_MANAGER:
			// 获取申请加入社团的通知
			List<ClubNotify> joins = getMapper()
					.getClubMemnerNotifyByStateAndUserId(userId,
							ConstantInfo.CLUBUSERS_APP);
			result.addAll(joins);
			// 获取申请退出社团的通知
			List<ClubNotify> quits = getMapper()
					.getClubMemnerNotifyByStateAndUserId(userId,
							ConstantInfo.CLUBUSER_QUIT_APP);
			result.addAll(quits);
			break;
		case ConstantInfo.SYSTEM_ROLE_CLUB_MEMBER:
		case ConstantInfo.SYSTEM_ROLE_USER:

			// 获取申请创建社团被拒绝的通知
			List<ClubNotify> refuses = getMapper()
					.getClubNotifyByStateAndUserId(userId,
							ConstantInfo.CLUB_STATE_APP_REFUSE);
			result.addAll(refuses);

			// 获取加入社团被拒绝的通知
			List<ClubNotify> joinRefuses = getMapper()
					.getClubMemnerNotifyByStateAndUserId(userId,
							ConstantInfo.CLUBUSER_REFUSE);
			result.addAll(joinRefuses);

			// 获取允许加入社团的通知
			List<ClubNotify> joinAllows = getMapper()
					.getClubMemnerNotifyByStateAndUserId(userId,
							ConstantInfo.CLUBUSERS_ALLOW);
			result.addAll(joinAllows);
			break;
		default:
			break;
		}
		return result;
	}

}
